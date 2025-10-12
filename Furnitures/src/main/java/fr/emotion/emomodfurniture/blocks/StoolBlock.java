package fr.emotion.emomodfurniture.blocks;

import fr.emotion.emomodfurniture.init.EmoStats;
import fr.emotion.emomodworld.entities.sittable.Sittable;
import fr.emotion.emomodworld.init.EmoEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.function.Supplier;

public class StoolBlock extends Block {
    private static final VoxelShape CHAIR_SHAPE = Block.box(3.0F, 0.0F, 3.0F, 13.0F, 12.0F, 13.0F);
    private static final VoxelShape shelf = Block.box(3d, 9d, 3d, 13d, 12d, 13d);

    private static final VoxelShape w_foot_1 = Block.box(3d, 0d, 3d, 5d, 9d, 5d);
    private static final VoxelShape w_foot_2 = Block.box(11d, 0d, 3d, 13d, 9d, 5d);
    private static final VoxelShape w_foot_3 = Block.box(3d, 0d, 11d, 5d, 9d, 13d);
    private static final VoxelShape w_foot_4 = Block.box(11d, 0d, 11d, 13d, 9d, 13d);
    private static final VoxelShape w_shelf = Block.box(4d, 5d, 4d, 12d, 7d, 12d);

    private static final VoxelShape wood = Shapes.or(shelf, w_foot_1, w_foot_2, w_foot_3, w_foot_4, w_shelf);

    private static final VoxelShape s_pillar = Block.box(4d, 2d, 4d, 12d, 9d, 12d);
    private static final VoxelShape s_shelf = Block.box(3d, 0d, 3d, 13d, 2d, 13d);

    private static final VoxelShape stone = Shapes.or(shelf, s_pillar, s_shelf);

    public boolean isStone = false;
    public Supplier<Block> texture;

    public StoolBlock(boolean isStone, Properties properties, Supplier<Block> texture) {
        this(properties, texture);
        this.isStone = isStone;
    }

    public StoolBlock(Properties props, Supplier<Block> texture) {
        super(props);
        this.texture = texture;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (isStone)
            return stone;
        else
            return wood;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            Entity entity = null;
            List<Sittable> sits = level.getEntities(EmoEntityType.SITTABLE.get(), new AABB(pos), sit -> true);

            if (sits.isEmpty()) {
                entity = EmoEntityType.SITTABLE.get().spawn((ServerLevel) level, pos, EntitySpawnReason.TRIGGERED);
            } else {
                entity = sits.getFirst();
            }

            player.startRiding(entity);
            player.awardStat(EmoStats.STOOL_SIT.get());
        }

        return InteractionResult.SUCCESS;
    }
}
