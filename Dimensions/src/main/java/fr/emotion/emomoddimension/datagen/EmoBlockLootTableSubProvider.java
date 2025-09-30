package fr.emotion.emomoddimension.datagen;

import fr.emotion.emomoddimension.init.EmoBlocks;
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
        this.add(EmoBlocks.DREAM_SHORT_GRASS.get(), this::createGrassDrops);
        this.add(EmoBlocks.DREAM_TALL_GRASS.get(), block -> this.createDoublePlantWithSeedDrops(block, EmoBlocks.DREAM_SHORT_GRASS.get()));

        this.add(EmoBlocks.DREAM_PORTAL.get(), noDrop());

        this.add(EmoBlocks.DREAM_STONE.get(), block -> this.createSingleItemTableWithSilkTouch(block, EmoBlocks.DREAM_COBBLESTONE.get()));
        this.dropSelf(EmoBlocks.DREAM_COBBLESTONE.get());
        this.add(EmoBlocks.DREAM_GRASS_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, EmoBlocks.DREAM_STONE.get()));
        this.dropSelf(EmoBlocks.DREAM_CATCHER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return EmoBlocks.getBlocks().getEntries().stream().map(Holder::value)::iterator;
    }
}
