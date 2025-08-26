package fr.emotion.emomodworld.world.mushroom;

import com.mojang.serialization.Codec;
import fr.emotion.emomodworld.init.EmoBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

public class HugeBlueMushroomFeature extends AbstractHugeMushroomFeature {
    boolean placed = false;

    public HugeBlueMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<HugeMushroomFeatureConfiguration> featurePlaceContext) {
        placed = super.place(featurePlaceContext);
        return placed;
    }

    @Override
    protected int getTreeHeight(RandomSource random) {
        int i = random.nextInt(2) + 8;
        if (random.nextInt(12)==0) {
            i *= 2;
        }

        return i;
    }

    //Should really optimise this old crap
    @Override
    protected void makeCap(LevelAccessor level, RandomSource random, BlockPos pos, int treeHeight, BlockPos.MutableBlockPos mutablePos, HugeMushroomFeatureConfiguration config) {
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                for (int z = -2; z <= 2; z++) {
                    this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 2, (treeHeight - 5) + y, 2),
                            EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.WEST, false).setValue(HugeMushroomBlock.NORTH, false));
                    this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 2, (treeHeight - 5) + y, -2),
                            EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.WEST, false).setValue(HugeMushroomBlock.SOUTH, false));
                    this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, -2, (treeHeight - 5) + y, 2),
                            EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.EAST, false).setValue(HugeMushroomBlock.NORTH, false));
                    this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, -2, (treeHeight - 5) + y, -2),
                            EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.EAST, false).setValue(HugeMushroomBlock.SOUTH, false));
                }
            }
        }

        for (int x = -1; x <= 1; x++) {
            for (int y = 0; y <= 1; y++) {
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, (treeHeight - 5) + y, 3), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.NORTH, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, (treeHeight - 5) + y, -3), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.SOUTH, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 3, (treeHeight - 5) + y, x), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.WEST, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, -3, (treeHeight - 5) + y, x), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.EAST, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 2, (treeHeight - 2) + y, x), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.WEST, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, -2, (treeHeight - 2) + y, x), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.EAST, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, (treeHeight - 2) + y, 2), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.NORTH, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, (treeHeight - 2) + y, -2), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.SOUTH, false));
            }

            if (x==-1 || x==1) {
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, (treeHeight - 3), 2), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.WEST, false)
                        .setValue(HugeMushroomBlock.NORTH, false).setValue(HugeMushroomBlock.EAST, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, (treeHeight - 3), -2), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.WEST, false)
                        .setValue(HugeMushroomBlock.SOUTH, false).setValue(HugeMushroomBlock.EAST, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 2, (treeHeight - 3), x), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.NORTH, false)
                        .setValue(HugeMushroomBlock.WEST, false).setValue(HugeMushroomBlock.SOUTH, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, -2, (treeHeight - 3), x), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.EAST, false)
                        .setValue(HugeMushroomBlock.SOUTH, false).setValue(HugeMushroomBlock.NORTH, false));

                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, treeHeight - 1, 1), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.EAST, false)
                        .setValue(HugeMushroomBlock.SOUTH, false).setValue(HugeMushroomBlock.WEST, false).setValue(HugeMushroomBlock.NORTH, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, treeHeight - 1, -1), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.EAST, false)
                        .setValue(HugeMushroomBlock.SOUTH, false).setValue(HugeMushroomBlock.WEST, false).setValue(HugeMushroomBlock.NORTH, false));
            }

            this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, treeHeight, 0), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
            this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 0, treeHeight, x), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
        }

        this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 0, (treeHeight - 3), -3), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.SOUTH, false));
        this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, -3, (treeHeight - 3), 0), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.EAST, false));
        this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 0, (treeHeight - 3), 3), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.NORTH, false));
        this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 3, (treeHeight - 3), 0), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.WEST, false));

        this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 0, (treeHeight - 2), 3), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState());
        this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 3, (treeHeight - 2), 0), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState());
        this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, 0, (treeHeight - 2), -3), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState());
        this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, -3, (treeHeight - 2), 0), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState());

        for (int x = -2; x <= 2; x++) {
            for (int y = -2; y <= 2; y++) {
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, (treeHeight - 5), y), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.UP, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, x, (treeHeight - 5), y), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.UP, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, -x, (treeHeight - 5), y), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.UP, false));
                this.placeMushroomBlock(level, mutablePos.setWithOffset(pos, -x, (treeHeight - 5), y), EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.UP, false));
            }
        }

        if (!this.placed && random.nextInt(7)==0) {
            BlockPos chestPos = mutablePos.setWithOffset(pos, 0, treeHeight - 3, 0);
            level.setBlock(chestPos, Blocks.CHEST.defaultBlockState(), 3);

            BlockEntity entity = level.getBlockEntity(chestPos);
            if (entity instanceof ChestBlockEntity chest) {
                chest.setLootTable(BuiltInLootTables.SIMPLE_DUNGEON, random.nextLong());
            }
        }
    }

    @Override
    protected int getTreeRadiusForHeight(int unused, int treetreeHeight, int foliageRadius, int y) {
        return 1;
    }
}
