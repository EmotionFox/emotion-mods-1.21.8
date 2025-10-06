package fr.emotion.emomodfood.datagen;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.init.EmoItems;
import fr.emotion.emomodfood.tags.EmoItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class EmoItemTagsProvider extends ItemTagsProvider {
    public EmoItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, EmoMain.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(EmoItemTags.JUICE)
                .add(
                        EmoItems.JUICE_PEAR.get(),
                        EmoItems.JUICE_CHERRY.get(),
                        EmoItems.JUICE_ORANGE.get(),
                        EmoItems.JUICE_TOMATO.get(),
                        EmoItems.JUICE_APPLE.get()
                );
        this.tag(EmoItemTags.MUFFIN)
                .add(
                        EmoItems.MUFFIN_PEAR.get(),
                        EmoItems.MUFFIN_CHERRY.get(),
                        EmoItems.MUFFIN_ORANGE.get(),
                        EmoItems.MUFFIN_ORANGE.get(),
                        EmoItems.MUFFIN_APPLE.get(),
                        EmoItems.MUFFIN_BLACKCURRANT.get(),
                        EmoItems.MUFFIN_BLUEBERRY.get(),
                        EmoItems.MUFFIN_DREAMCURRANT.get(),
                        EmoItems.MUFFIN_STRAWBERRY.get(),
                        EmoItems.MUFFIN_SWEETBERRY.get()
                );

        this.tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED)
                .add(
                        EmoItems.CAKE_CHOCOLATE.get(),
                        EmoItems.CAKE_FRUIT.get(),
                        EmoItems.CAKE_TOFFEE.get(),
                        EmoItems.CAKE_STRAWBERRY.get()
                );
        this.tag(Tags.Items.FOODS_CANDY)
                .add(
                        EmoItems.TOFFEE_APPLE.get()
                );
        this.tag(Tags.Items.FOODS_BREAD)
                .add(
                        EmoItems.SLICE_BREAD.get(),
                        EmoItems.SLICE_PEAR.get(),
                        EmoItems.SLICE_CHERRY.get(),
                        EmoItems.SLICE_ORANGE.get(),
                        EmoItems.SLICE_APPLE.get(),
                        EmoItems.SLICE_BLACKCURRANT.get(),
                        EmoItems.SLICE_BLUEBERRY.get(),
                        EmoItems.SLICE_DREAMCURRANT.get(),
                        EmoItems.SLICE_STRAWBERRY.get(),
                        EmoItems.SLICE_SWEETBERRY.get(),
                        EmoItems.SLICE_CHOCOLATE.get()
                );
        this.tag(Tags.Items.FOODS_PIE)
                .add(
                        EmoItems.PIE_PEAR.get(),
                        EmoItems.PIE_CHERRY.get(),
                        EmoItems.PIE_ORANGE.get(),
                        EmoItems.PIE_APPLE.get(),
                        EmoItems.PIE_MELON.get()
                );
    }
}
