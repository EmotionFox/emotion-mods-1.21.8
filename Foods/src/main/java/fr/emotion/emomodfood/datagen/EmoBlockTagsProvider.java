package fr.emotion.emomodfood.datagen;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.init.EmoBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class EmoBlockTagsProvider extends BlockTagsProvider {
    public EmoBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, EmoMain.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.CANDLE_CAKES)
                .add(
                        EmoBlocks.CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.WHITE_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.ORANGE_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.MAGENTA_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.YELLOW_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.LIME_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.PINK_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.GRAY_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.CYAN_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.PURPLE_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.BLUE_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.BROWN_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.GREEN_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.RED_CANDLE_CAKE_CHOCOLATE.get(),
                        EmoBlocks.BLACK_CANDLE_CAKE_CHOCOLATE.get(),

                        EmoBlocks.CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.WHITE_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.ORANGE_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.MAGENTA_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.YELLOW_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.LIME_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.PINK_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.GRAY_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.CYAN_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.PURPLE_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.BLUE_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.BROWN_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.GREEN_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.RED_CANDLE_CAKE_FRUIT.get(),
                        EmoBlocks.BLACK_CANDLE_CAKE_FRUIT.get(),

                        EmoBlocks.CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.WHITE_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.ORANGE_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.MAGENTA_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.YELLOW_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.LIME_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.PINK_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.GRAY_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.CYAN_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.PURPLE_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.BLUE_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.BROWN_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.GREEN_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.RED_CANDLE_CAKE_TOFFEE.get(),
                        EmoBlocks.BLACK_CANDLE_CAKE_TOFFEE.get(),

                        EmoBlocks.CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.WHITE_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.ORANGE_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.MAGENTA_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.YELLOW_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.LIME_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.PINK_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.GRAY_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.CYAN_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.PURPLE_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.BLUE_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.BROWN_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.GREEN_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.RED_CANDLE_CAKE_STRAWBERRY.get(),
                        EmoBlocks.BLACK_CANDLE_CAKE_STRAWBERRY.get()
                );
        this.tag(BlockTags.CROPS)
                .add(
                        EmoBlocks.TOMATOES.get()
                );
    }
}
