package fr.emotion.emomoddimension.blocks;

import fr.emotion.emomoddimension.datagen.setBuilder.vegetation.EmoVegetationPlacedFeature;
import fr.emotion.emomoddimension.init.EmoBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.lighting.LightEngine;

import java.util.List;
import java.util.Optional;

public class DreamGrassBlock extends GrassBlock {
    public DreamGrassBlock(Properties props) {
        super(props);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = EmoBlocks.DREAM_SHORT_GRASS.get().defaultBlockState();
        Optional<Holder.Reference<PlacedFeature>> optional = level.registryAccess()
                .lookupOrThrow(Registries.PLACED_FEATURE)
                .get(EmoVegetationPlacedFeature.DREAM_GRASS_BONEMEAL);

        label51:
        for (int i = 0; i < 128; i++) {
            BlockPos blockpos1 = blockpos;

            for (int j = 0; j < i / 16; j++) {
                blockpos1 = blockpos1.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                if (!level.getBlockState(blockpos1.below()).is(this) || level.getBlockState(blockpos1).isCollisionShapeFullBlock(level, blockpos1)) {
                    continue label51;
                }
            }

            BlockState blockstate1 = level.getBlockState(blockpos1);
            if (blockstate1.is(blockstate.getBlock()) && random.nextInt(10)==0) {
                BonemealableBlock bonemealableblock = (BonemealableBlock) blockstate.getBlock();
                if (bonemealableblock.isValidBonemealTarget(level, blockpos1, blockstate1)) {
                    bonemealableblock.performBonemeal(level, random, blockpos1, blockstate1);
                }
            }

            if (blockstate1.isAir()) {
                Holder<PlacedFeature> holder;
                if (random.nextInt(8)==0) {
                    List<ConfiguredFeature<?, ?>> list = level.getBiome(blockpos1).value().getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    int k = random.nextInt(list.size());
                    holder = ((RandomPatchConfiguration) list.get(k).config()).feature();
                } else {
                    if (!optional.isPresent()) {
                        continue;
                    }

                    holder = optional.get();
                }

                holder.value().place(level, level.getChunkSource().getGenerator(), random, blockpos1);
            }
        }
    }

    private static boolean canBeDreamGrass(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockPos = pos.above();
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.is(Blocks.SNOW) && blockState.getValue(SnowLayerBlock.LAYERS)==1) {
            return true;
        } else if (blockState.getFluidState().getAmount()==8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(state, blockState, Direction.UP, blockState.getLightBlock());
            return i < 15;
        }
    }

    private static boolean canPropagate(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockPos = pos.above();
        return canBeDreamGrass(state, level, pos) && !level.getFluidState(blockPos).is(FluidTags.WATER);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canBeDreamGrass(state, level, pos)) {
            if (!level.isAreaLoaded(pos, 1)) return;
            level.setBlockAndUpdate(pos, EmoBlocks.DREAM_STONE.get().defaultBlockState());
        } else {
            if (!level.isAreaLoaded(pos, 3)) return;
            if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
                BlockState blockState = this.defaultBlockState();

                for (int i = 0; i < 4; i++) {
                    BlockPos blockPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (level.getBlockState(blockPos).is(EmoBlocks.DREAM_STONE.get()) && canPropagate(blockState, level, blockPos)) {
                        level.setBlockAndUpdate(blockPos, blockState.setValue(SNOWY, isSnowySetting(level.getBlockState(blockPos.above()))));
                    }
                }
            }
        }
    }
}
