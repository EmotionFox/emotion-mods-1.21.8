package fr.emotion.emomodfood.datagen;

import fr.emotion.emomodfood.init.EmoBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class EmoBlockLootSubProvider extends BlockLootSubProvider {
    protected EmoBlockLootSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.add(EmoBlocks.CAKE_CHOCOLATE.get(), noDrop());
        this.add(EmoBlocks.CAKE_FRUIT.get(), noDrop());
        this.add(EmoBlocks.CAKE_TOFFEE.get(), noDrop());
        this.add(EmoBlocks.CAKE_STRAWBERRY.get(), noDrop());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return EmoBlocks.getBlocks().getEntries().stream().map(Holder::value)::iterator;
    }
}
