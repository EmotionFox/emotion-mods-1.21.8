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
        dropSelf(EmoBlocks.FLOWER_1.get());
        dropSelf(EmoBlocks.FLOWER_2.get());
        dropSelf(EmoBlocks.FLOWER_3.get());
        dropSelf(EmoBlocks.FLOWER_4.get());
        dropSelf(EmoBlocks.FLOWER_5.get());
        dropSelf(EmoBlocks.FLOWER_6.get());
        dropSelf(EmoBlocks.FLOWER_7.get());
        dropSelf(EmoBlocks.FLOWER_8.get());
        dropSelf(EmoBlocks.FLOWER_9.get());

        add(EmoBlocks.POTTED_FLOWER_1.get(), createPotFlowerItemTable(EmoBlocks.FLOWER_1.get()));
        add(EmoBlocks.POTTED_FLOWER_2.get(), createPotFlowerItemTable(EmoBlocks.FLOWER_2.get()));
        add(EmoBlocks.POTTED_FLOWER_3.get(), createPotFlowerItemTable(EmoBlocks.FLOWER_3.get()));
        add(EmoBlocks.POTTED_FLOWER_4.get(), createPotFlowerItemTable(EmoBlocks.FLOWER_4.get()));
        add(EmoBlocks.POTTED_FLOWER_5.get(), createPotFlowerItemTable(EmoBlocks.FLOWER_5.get()));
        add(EmoBlocks.POTTED_FLOWER_6.get(), createPotFlowerItemTable(EmoBlocks.FLOWER_6.get()));
        add(EmoBlocks.POTTED_FLOWER_7.get(), createPotFlowerItemTable(EmoBlocks.FLOWER_7.get()));
        add(EmoBlocks.POTTED_FLOWER_8.get(), createPotFlowerItemTable(EmoBlocks.FLOWER_8.get()));
        add(EmoBlocks.POTTED_FLOWER_9.get(), createPotFlowerItemTable(EmoBlocks.FLOWER_9.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return EmoBlocks.getBlocks().getEntries().stream().map(Holder::value)::iterator;
    }
}
