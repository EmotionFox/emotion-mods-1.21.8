package fr.emotion.emomodfurniture.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class TableBlock extends Block {
    public static final EnumProperty<TableDir> DIR = EnumProperty.create("table", TableDir.class);
    public static final VoxelShape shelf = Block.box(0d, 12d, 0d, 16d, 16d, 16d);
    public static final VoxelShape full = Shapes.or(shelf);

    public static final VoxelShape pillar = Block.box(6d, 3d, 6d, 10d, 12d, 10d);
    public static final VoxelShape foot_ns = Block.box(6d, 0d, 0d, 10d, 2d, 16d);
    public static final VoxelShape foot_ew = Block.box(0d, 0d, 6d, 16d, 2d, 10d);
    public static final VoxelShape foot_shelf = Block.box(3d, 2d, 3d, 13d, 3d, 13d);
    public static final VoxelShape normal = Shapes.or(shelf, pillar, foot_ns, foot_ew, foot_shelf);
    public static final VoxelShape straight_ns = Shapes.or(shelf, foot_ns);
    public static final VoxelShape straight_ew = Shapes.or(shelf, foot_ew);

    public static final VoxelShape s_pillar = Block.box(4d, 2d, 4d, 12d, 10d, 12d);
    public static final VoxelShape s_foot_shelf_t = Block.box(3d, 10d, 3d, 13d, 12d, 13d);
    public static final VoxelShape s_foot_shelf_b = Block.box(3d, 0d, 3d, 13d, 2d, 13d);
    public static final VoxelShape s_normal = Shapes.or(shelf, s_pillar, s_foot_shelf_t, s_foot_shelf_b);

    public boolean isStone = false;
    public Supplier<Block> texture;

    public TableBlock(boolean isStone, Properties props, Supplier<Block> texture) {
        this(props, texture);
        this.isStone = isStone;
    }

    public TableBlock(Properties props, Supplier<Block> texture) {
        super(props);
        this.texture = texture;
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIR, TableDir.NORMAL));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(DIR)) {
            case STRAIGHT_NS -> {
                if (this.isStone)
                    yield full;
                yield straight_ns;
            }
            case STRAIGHT_EW -> {
                if (this.isStone)
                    yield full;
                yield straight_ew;
            }
            case FULL -> full;
            default -> {
                if (this.isStone)
                    yield s_normal;
                yield normal;
            }
        };
    }

    public final boolean connectsTo(BlockState state) {
        return state.getBlock() instanceof TableBlock;
    }

    public BlockState checkAround(LevelReader level, BlockPos pos) {
        BlockPos north = pos.north();
        BlockPos south = pos.south();
        BlockPos east = pos.east();
        BlockPos west = pos.west();
        BlockState stateNorth = level.getBlockState(north);
        BlockState stateSouth = level.getBlockState(south);
        BlockState stateEast = level.getBlockState(east);
        BlockState stateWest = level.getBlockState(west);

        boolean boolNorth = this.connectsTo(stateNorth);
        boolean boolSouth = this.connectsTo(stateSouth);
        boolean boolEast = this.connectsTo(stateEast);
        boolean boolWest = this.connectsTo(stateWest);

        if (boolNorth && boolSouth && boolEast && boolWest)
            return this.defaultBlockState().setValue(DIR, TableDir.FULL);
        else if (boolNorth && boolSouth) {
            if (level.getBlockState(north).getValueOrElse(DIR, TableDir.NORMAL)!=TableDir.NORMAL || level.getBlockState(south).getValueOrElse(DIR, TableDir.NORMAL)!=TableDir.NORMAL)
                return this.defaultBlockState().setValue(DIR, TableDir.FULL);
            else
                return this.defaultBlockState().setValue(DIR, TableDir.STRAIGHT_NS);
        } else if (boolEast && boolWest) {
            if (level.getBlockState(east).getValueOrElse(DIR, TableDir.NORMAL)!=TableDir.NORMAL || level.getBlockState(west).getValueOrElse(DIR, TableDir.NORMAL)!=TableDir.NORMAL)
                return this.defaultBlockState().setValue(DIR, TableDir.FULL);
            else
                return this.defaultBlockState().setValue(DIR, TableDir.STRAIGHT_EW);
        } else
            return this.defaultBlockState().setValue(DIR, TableDir.NORMAL);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return checkAround(context.getLevel(), context.getClickedPos());
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        return checkAround(level, pos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIR);
    }

    public enum TableDir implements StringRepresentable {
        NORMAL("normal"), STRAIGHT_NS("ns"), STRAIGHT_EW("ew"), FULL("full");

        private final String name;

        TableDir(String name) {
            this.name = name;
        }

        @Override
        public @NotNull String getSerializedName() {
            return name;
        }
    }
}
