package fr.emotion.emomodworld.world.mushroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugeGreenMushroomFeature extends AbstractHugeMushroomFeature {
    public HugeGreenMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected int getTreeHeight(RandomSource random) {
        int i = random.nextInt(2) + 7;
        if (random.nextInt(12)==0) {
            i *= 2;
        }

        return i;
    }

    @Override
    protected void makeCap(LevelAccessor level, RandomSource random, BlockPos pos, int treeHeight, BlockPos.MutableBlockPos mutablePos, HugeMushroomFeatureConfiguration config) {
        BlockState blockState = config.capProvider.getState(random, pos);

        for (int xz = -1; xz <= 1; xz++) {
            //Top cross
            this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, xz, treeHeight, 0), blockState);
            this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 0, treeHeight, xz), blockState);

            for (int y = 1; y <= 2; y++) {
                // Middle diamond pattern
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, xz + 1, treeHeight - y, xz - 1), blockState.setValue(HugeMushroomBlock.SOUTH, !(xz <= 0)).setValue(HugeMushroomBlock.WEST, !(xz >= 0)));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, xz - 1, treeHeight - y, xz + 1), blockState.setValue(HugeMushroomBlock.NORTH, !(xz >= 0)).setValue(HugeMushroomBlock.EAST, !(xz <= 0)));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, xz + 1, treeHeight - y, -xz + 1), blockState.setValue(HugeMushroomBlock.NORTH, !(xz <= 0)).setValue(HugeMushroomBlock.WEST, !(xz >= 0)));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, xz - 1, treeHeight - y, -xz - 1), blockState.setValue(HugeMushroomBlock.SOUTH, !(xz >= 0)).setValue(HugeMushroomBlock.EAST, !(xz <= 0)));
            }

            //Cube without corner
            this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, xz, treeHeight - 3, -2), blockState.setValue(HugeMushroomBlock.SOUTH, false));
            this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, xz, treeHeight - 3, +2), blockState.setValue(HugeMushroomBlock.NORTH, false));
            this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, -2, treeHeight - 3, xz), blockState.setValue(HugeMushroomBlock.EAST, false));
            this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, +2, treeHeight - 3, xz), blockState.setValue(HugeMushroomBlock.WEST, false));
        }

        //Base exterior blocks
        for (int xz = -3; xz <= 3; xz += 6) {
            this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, xz, treeHeight - 4, 0), blockState);
            this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 0, treeHeight - 4, xz), blockState);
        }

        //Base
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, treeHeight - 4, z), blockState.setValue(HugeMushroomBlock.UP, !(x > -2 && x < 2)));
            }
        }
    }

    @Override
    protected int getTreeRadiusForHeight(int unused, int height, int foliageRadius, int y) {
        return 1;
    }
}
