package fr.emotion.emomodfood.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class HoleCandleCakeBlock extends CandleCakeBlock {
    private static final VoxelShape SHAPE_HOLE = Block.column(14.0, 0.0, 8.0);
    private static final Iterable<Vec3> PARTICLE_OFFSETS_HOLE = List.of(new Vec3(8.0, 8.0, 8.0).scale(0.0625));

    public HoleCandleCakeBlock(Properties properties) {
        super(Blocks.CANDLE, properties);
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState blockState) {
        return PARTICLE_OFFSETS_HOLE;
    }

    @Override
    protected VoxelShape getShape(BlockState p_152875_, BlockGetter p_152876_, BlockPos p_152877_, CollisionContext p_152878_) {
        return SHAPE_HOLE;
    }
}
