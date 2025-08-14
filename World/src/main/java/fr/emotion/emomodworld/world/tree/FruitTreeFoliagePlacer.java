package fr.emotion.emomodworld.world.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.emotion.emomodworld.init.EmoFoliagePlacerType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.HashSet;
import java.util.Set;

public class FruitTreeFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<FruitTreeFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> foliagePlacerParts(instance).apply(instance, FruitTreeFoliagePlacer::new));

    public FruitTreeFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return EmoFoliagePlacerType.FRUIT_TREE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int trunkHeight, FoliageAttachment attachment, int foliageHeight, int radius, int offset
    ) {
        BlockPos basePos = attachment.pos().above(offset);

        Set<BlockPos> bottomHole = new HashSet<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                bottomHole.add(basePos.offset(dx, foliageHeight - 3, dz));
            }
        }

        for (int x = 1; x <= 3; x++) {
            for (int z = 0; z <= 2; z++) {
                for (int y = -3; y <= -1; y++) {
                    tryPlaceLeaf(level, foliageSetter, random, config, basePos.offset(x, foliageHeight + y, z), bottomHole);
                    tryPlaceLeaf(level, foliageSetter, random, config, basePos.offset(-x, foliageHeight + y, -z), bottomHole);
                    tryPlaceLeaf(level, foliageSetter, random, config, basePos.offset(-z, foliageHeight + y, x), bottomHole);
                    tryPlaceLeaf(level, foliageSetter, random, config, basePos.offset(z, foliageHeight + y, -x), bottomHole);
                }
            }
        }

        BlockPos[] cornerOffsets = {
                new BlockPos(1, foliageHeight - 2, 3),
                new BlockPos(-1, foliageHeight - 2, -3),
                new BlockPos(3, foliageHeight - 2, -1),
                new BlockPos(-3, foliageHeight - 2, 1)
        };
        for (BlockPos corner : cornerOffsets) {
            tryPlaceLeaf(level, foliageSetter, random, config, basePos.offset(corner), bottomHole);
            tryPlaceLeaf(level, foliageSetter, random, config, basePos.offset(corner).above(), bottomHole);
            for (Direction dir : new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST}) {
                BlockPos p = basePos.offset(corner).relative(dir);
                if (Math.abs(p.getX() - basePos.getX()) <= 3 && Math.abs(p.getZ() - basePos.getZ()) <= 3) {
                    tryPlaceLeaf(level, foliageSetter, random, config, p, bottomHole);
                }
            }
        }

        for (int x = -2; x <= 2; x++) {
            for (int y = 0; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    tryPlaceLeaf(level, foliageSetter, random, config, basePos.offset(x, foliageHeight + y, z), bottomHole);
                    tryPlaceLeaf(level, foliageSetter, random, config, basePos.offset(z, foliageHeight + y, x), bottomHole);
                }
            }
        }

        for (int i = -3; i <= 3; i++) {
            tryPlaceLeaf(level, foliageSetter, random, config, basePos.offset(i, foliageHeight, 0), bottomHole);
            tryPlaceLeaf(level, foliageSetter, random, config, basePos.offset(0, foliageHeight, i), bottomHole);
        }
    }

    private void tryPlaceLeaf(
            LevelSimulatedReader level,
            FoliageSetter foliageSetter,
            RandomSource random,
            TreeConfiguration config,
            BlockPos pos,
            Set<BlockPos> bottomHole
    ) {
        if (!bottomHole.contains(pos)) {
            FoliagePlacer.tryPlaceLeaf(level, foliageSetter, random, config, pos);
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
