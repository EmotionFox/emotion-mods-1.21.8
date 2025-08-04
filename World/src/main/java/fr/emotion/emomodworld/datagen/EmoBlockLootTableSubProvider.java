package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.init.EmoBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class EmoBlockLootTableSubProvider extends BlockLootSubProvider {
    protected EmoBlockLootTableSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(EmoBlocks.FLOWER_1.get());
        this.dropSelf(EmoBlocks.FLOWER_2.get());
        this.dropSelf(EmoBlocks.FLOWER_3.get());
        this.dropSelf(EmoBlocks.FLOWER_4.get());
        this.dropSelf(EmoBlocks.FLOWER_5.get());
        this.dropSelf(EmoBlocks.FLOWER_6.get());
        this.dropSelf(EmoBlocks.FLOWER_7.get());
        this.dropSelf(EmoBlocks.FLOWER_8.get());
        this.dropSelf(EmoBlocks.FLOWER_9.get());

        this.add(EmoBlocks.POTTED_FLOWER_1.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_1.get()));
        this.add(EmoBlocks.POTTED_FLOWER_2.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_2.get()));
        this.add(EmoBlocks.POTTED_FLOWER_3.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_3.get()));
        this.add(EmoBlocks.POTTED_FLOWER_4.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_4.get()));
        this.add(EmoBlocks.POTTED_FLOWER_5.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_5.get()));
        this.add(EmoBlocks.POTTED_FLOWER_6.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_6.get()));
        this.add(EmoBlocks.POTTED_FLOWER_7.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_7.get()));
        this.add(EmoBlocks.POTTED_FLOWER_8.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_8.get()));
        this.add(EmoBlocks.POTTED_FLOWER_9.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_9.get()));

        this.dropSelf(EmoBlocks.PEAR_PLANKS.get());

        this.dropSelf(EmoBlocks.PEAR_SAPLING.get());
        this.add(EmoBlocks.POTTED_PEAR_SAPLING.get(), this.createPotFlowerItemTable(EmoBlocks.PEAR_SAPLING.get()));

        this.dropSelf(EmoBlocks.PEAR_LOG.get());
        this.dropSelf(EmoBlocks.STRIPPED_PEAR_LOG.get());
        this.dropSelf(EmoBlocks.PEAR_WOOD.get());
        this.dropSelf(EmoBlocks.STRIPPED_PEAR_WOOD.get());
        this.add(EmoBlocks.PEAR_LEAVES.get(), block -> this.createLeavesDrops(block, EmoBlocks.PEAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(EmoBlocks.PEAR_SIGN.get());
        this.dropOther(EmoBlocks.PEAR_WALL_SIGN.get(), EmoBlocks.PEAR_SIGN.get());
        this.dropSelf(EmoBlocks.PEAR_HANGING_SIGN.get());
        this.dropOther(EmoBlocks.PEAR_WALL_HANGING_SIGN.get(), EmoBlocks.PEAR_HANGING_SIGN.get());
        this.dropSelf(EmoBlocks.PEAR_PRESSURE_PLATE.get());
        this.dropSelf(EmoBlocks.PEAR_TRAPDOOR.get());
        this.dropSelf(EmoBlocks.PEAR_STAIRS.get());
        this.dropSelf(EmoBlocks.PEAR_BUTTON.get());
        this.add(EmoBlocks.PEAR_SLAB.get(), block -> this.createSlabItemTable(block));
        this.dropSelf(EmoBlocks.PEAR_FENCE_GATE.get());
        this.dropSelf(EmoBlocks.PEAR_FENCE.get());
        this.add(EmoBlocks.PEAR_DOOR.get(), block -> this.createDoorTable(block));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return EmoBlocks.getBlocks().getEntries().stream().map(Holder::value)::iterator;
    }
}
