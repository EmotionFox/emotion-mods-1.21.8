package fr.emotion.emomodfood.blocks;

import com.mojang.serialization.MapCodec;
import fr.emotion.emomodfood.blocks.entity.PotBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class EmoPotBlock extends Block implements EntityBlock {
    public static final MapCodec<EmoPotBlock> CODEC = simpleCodec(EmoPotBlock::new);
    private static final VoxelShape JAR = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);
    private static final VoxelShape CORK = Block.box(5.0D, 9.0D, 5.0D, 11.0D, 11.0D, 11.0D);

    private static final VoxelShape POT = Shapes.or(JAR, CORK);

    public EmoPotBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos)!=null && level.getBlockEntity(pos) instanceof PotBlockEntity potBlockEntity) {
            return potBlockEntity.use(player, hand);
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return POT;
    }

    @Override
    protected MapCodec<EmoPotBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PotBlockEntity(pos, state);
    }
}
