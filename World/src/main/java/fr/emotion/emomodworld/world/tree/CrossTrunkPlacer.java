package fr.emotion.emomodworld.world.tree;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.emotion.emomodworld.init.EmoTrunkPlacerType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class CrossTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<CrossTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> trunkPlacerParts(instance).apply(instance, CrossTrunkPlacer::new)
    );

    public CrossTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return EmoTrunkPlacerType.CROSS_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        setDirtAt(level, blockSetter, random, pos.below(), config);

        for (int y = 0; y < freeTreeHeight; y++) {
            this.placeLog(level, blockSetter, random, pos.above(y), config);
        }

        for (int xz = -2; xz < 3; xz++) {
            this.placeLog(level, blockSetter, random, pos.offset(xz, freeTreeHeight - 3, 0), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
            this.placeLog(level, blockSetter, random, pos.offset(0, freeTreeHeight - 3, xz), config, state -> state.trySetValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(freeTreeHeight - 1), 0, false));
    }
}
