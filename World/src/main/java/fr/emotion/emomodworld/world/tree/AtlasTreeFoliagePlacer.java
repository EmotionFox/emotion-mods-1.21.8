package fr.emotion.emomodworld.world.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoFoliagePlacerType;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class AtlasTreeFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<AtlasTreeFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> foliagePlacerParts(instance).apply(instance, AtlasTreeFoliagePlacer::new));

    public AtlasTreeFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return EmoFoliagePlacerType.ATLAS_TREE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos pos = attachment.pos();
        int rOffset = attachment.radiusOffset();

        for (int a = -3 + rOffset; a <= 3 - rOffset; a++) {
            for (int b = -1; b <= 1; b++) {
                tryPlaceLeaf(level, blockSetter, random, config, pos.offset(a, -2, b));
                tryPlaceLeaf(level, blockSetter, random, config, pos.offset(b, -2, a));
            }
        }

        for(int y = 0; y <= 3 - rOffset; y++){
            for(int x = -2 + rOffset; x <= 2 - rOffset; x++) {
                for(int z = -2 + rOffset; z <= 2 - rOffset; z++){
                    boolean flagX = x == -2 + rOffset || x == 2 - rOffset;
                    boolean flagZ = z == -2 + rOffset || z == 2 - rOffset;
                    boolean flag = y == 3 - rOffset && (flagX && flagZ);

                    if(!flag) tryPlaceLeaf(level, blockSetter, random, config, pos.offset(x, y - 2, z));
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
