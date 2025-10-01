package fr.emotion.emomodfood.datagen;

import fr.emotion.emomodfood.init.EmoBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Set;

public class EmoBlockLootSubProvider extends BlockLootSubProvider {
    protected EmoBlockLootSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.add(EmoBlocks.CAKE_CHOCOLATE.get(), noDrop());
        this.add(EmoBlocks.CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.CANDLE));
        this.add(EmoBlocks.WHITE_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.WHITE_CANDLE));
        this.add(EmoBlocks.ORANGE_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.ORANGE_CANDLE));
        this.add(EmoBlocks.MAGENTA_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.MAGENTA_CANDLE));
        this.add(EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.LIGHT_BLUE_CANDLE));
        this.add(EmoBlocks.YELLOW_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.YELLOW_CANDLE));
        this.add(EmoBlocks.LIME_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.LIME_CANDLE));
        this.add(EmoBlocks.PINK_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.PINK_CANDLE));
        this.add(EmoBlocks.GRAY_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.GRAY_CANDLE));
        this.add(EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.LIGHT_GRAY_CANDLE));
        this.add(EmoBlocks.CYAN_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.CYAN_CANDLE));
        this.add(EmoBlocks.PURPLE_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.PURPLE_CANDLE));
        this.add(EmoBlocks.BLUE_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.BLUE_CANDLE));
        this.add(EmoBlocks.BROWN_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.BROWN_CANDLE));
        this.add(EmoBlocks.GREEN_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.GREEN_CANDLE));
        this.add(EmoBlocks.RED_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.RED_CANDLE));
        this.add(EmoBlocks.BLACK_CANDLE_CAKE_CHOCOLATE.get(), createCandleCakeDrops(Blocks.BLACK_CANDLE));

        this.add(EmoBlocks.CAKE_FRUIT.get(), noDrop());
        this.add(EmoBlocks.CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.CANDLE));
        this.add(EmoBlocks.WHITE_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.WHITE_CANDLE));
        this.add(EmoBlocks.ORANGE_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.ORANGE_CANDLE));
        this.add(EmoBlocks.MAGENTA_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.MAGENTA_CANDLE));
        this.add(EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.LIGHT_BLUE_CANDLE));
        this.add(EmoBlocks.YELLOW_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.YELLOW_CANDLE));
        this.add(EmoBlocks.LIME_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.LIME_CANDLE));
        this.add(EmoBlocks.PINK_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.PINK_CANDLE));
        this.add(EmoBlocks.GRAY_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.GRAY_CANDLE));
        this.add(EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.LIGHT_GRAY_CANDLE));
        this.add(EmoBlocks.CYAN_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.CYAN_CANDLE));
        this.add(EmoBlocks.PURPLE_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.PURPLE_CANDLE));
        this.add(EmoBlocks.BLUE_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.BLUE_CANDLE));
        this.add(EmoBlocks.BROWN_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.BROWN_CANDLE));
        this.add(EmoBlocks.GREEN_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.GREEN_CANDLE));
        this.add(EmoBlocks.RED_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.RED_CANDLE));
        this.add(EmoBlocks.BLACK_CANDLE_CAKE_FRUIT.get(), createCandleCakeDrops(Blocks.BLACK_CANDLE));

        this.add(EmoBlocks.CAKE_TOFFEE.get(), noDrop());
        this.add(EmoBlocks.CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.CANDLE));
        this.add(EmoBlocks.WHITE_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.WHITE_CANDLE));
        this.add(EmoBlocks.ORANGE_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.ORANGE_CANDLE));
        this.add(EmoBlocks.MAGENTA_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.MAGENTA_CANDLE));
        this.add(EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.LIGHT_BLUE_CANDLE));
        this.add(EmoBlocks.YELLOW_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.YELLOW_CANDLE));
        this.add(EmoBlocks.LIME_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.LIME_CANDLE));
        this.add(EmoBlocks.PINK_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.PINK_CANDLE));
        this.add(EmoBlocks.GRAY_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.GRAY_CANDLE));
        this.add(EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.LIGHT_GRAY_CANDLE));
        this.add(EmoBlocks.CYAN_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.CYAN_CANDLE));
        this.add(EmoBlocks.PURPLE_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.PURPLE_CANDLE));
        this.add(EmoBlocks.BLUE_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.BLUE_CANDLE));
        this.add(EmoBlocks.BROWN_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.BROWN_CANDLE));
        this.add(EmoBlocks.GREEN_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.GREEN_CANDLE));
        this.add(EmoBlocks.RED_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.RED_CANDLE));
        this.add(EmoBlocks.BLACK_CANDLE_CAKE_TOFFEE.get(), createCandleCakeDrops(Blocks.BLACK_CANDLE));

        this.add(EmoBlocks.CAKE_STRAWBERRY.get(), noDrop());
        this.add(EmoBlocks.CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.CANDLE));
        this.add(EmoBlocks.WHITE_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.WHITE_CANDLE));
        this.add(EmoBlocks.ORANGE_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.ORANGE_CANDLE));
        this.add(EmoBlocks.MAGENTA_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.MAGENTA_CANDLE));
        this.add(EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.LIGHT_BLUE_CANDLE));
        this.add(EmoBlocks.YELLOW_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.YELLOW_CANDLE));
        this.add(EmoBlocks.LIME_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.LIME_CANDLE));
        this.add(EmoBlocks.PINK_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.PINK_CANDLE));
        this.add(EmoBlocks.GRAY_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.GRAY_CANDLE));
        this.add(EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.LIGHT_GRAY_CANDLE));
        this.add(EmoBlocks.CYAN_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.CYAN_CANDLE));
        this.add(EmoBlocks.PURPLE_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.PURPLE_CANDLE));
        this.add(EmoBlocks.BLUE_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.BLUE_CANDLE));
        this.add(EmoBlocks.BROWN_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.BROWN_CANDLE));
        this.add(EmoBlocks.GREEN_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.GREEN_CANDLE));
        this.add(EmoBlocks.RED_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.RED_CANDLE));
        this.add(EmoBlocks.BLACK_CANDLE_CAKE_STRAWBERRY.get(), createCandleCakeDrops(Blocks.BLACK_CANDLE));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return EmoBlocks.getBlocks().getEntries().stream().map(Holder::value)::iterator;
    }
}
