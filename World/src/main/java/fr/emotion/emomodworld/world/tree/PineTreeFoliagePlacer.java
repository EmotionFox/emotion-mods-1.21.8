package fr.emotion.emomodworld.world.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.emotion.emomodworld.init.EmoFoliagePlacerType;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PineTreeFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PineTreeFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> foliagePlacerParts(instance).apply(instance, PineTreeFoliagePlacer::new));

    public PineTreeFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return EmoFoliagePlacerType.PINE_TREE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos basePos = attachment.pos().above(offset);
        int rOffset = attachment.radiusOffset();

        for (int y = -1; y <= 1; y++) {
            for (int x = -1 - rOffset; x <= 1 + rOffset; x++) {
                for (int z = -1 - rOffset; z <= 1 + rOffset; z++) {
                    if (y==1) {
                        boolean flag = (x==-1 - rOffset || x==1 + rOffset) && (z==-1 - rOffset || z==1 + rOffset);
                        if (!flag) tryPlaceLeaf(level, blockSetter, random, config, basePos.offset(x, y, z));
                    } else {
                        tryPlaceLeaf(level, blockSetter, random, config, basePos.offset(x, y, z));
                    }
                }
            }
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return false;
    }
}
