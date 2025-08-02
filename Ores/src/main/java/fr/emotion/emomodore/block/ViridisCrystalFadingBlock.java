package fr.emotion.emomodore.block;

import fr.emotion.emomodore.Config;
import fr.emotion.emomodore.block.state.EmoBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;

public class ViridisCrystalFadingBlock extends FadingBlock {
    public ViridisCrystalFadingBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextInt(Config.FADING_CHANCE_VIRIDIS_CRYSTAL.getAsInt())==0) {
            level.setBlockAndUpdate(pos, state.setValue(EmoBlockStateProperties.PHASE, (state.getValue(EmoBlockStateProperties.PHASE) - 1)));
        }
    }
}
