package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoItems;
import fr.emotion.emomodworld.tags.EmoItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class EmoItemTagsProvider extends ItemTagsProvider {
    public EmoItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, EmoMain.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.PLANKS)
                .add(
                        EmoBlocks.PEAR_PLANKS.asItem()
                );
        this.tag(ItemTags.SAPLINGS)
                .add(
                        EmoBlocks.PEAR_SAPLING.asItem()
                );
        this.tag(EmoItemTags.PEAR_LOGS)
                .add(
                        EmoBlocks.PEAR_LOG.asItem(),
                        EmoBlocks.PEAR_WOOD.asItem(),
                        EmoBlocks.STRIPPED_PEAR_LOG.asItem(),
                        EmoBlocks.STRIPPED_PEAR_WOOD.asItem()
                );
        this.tag(ItemTags.LEAVES)
                .add(
                        EmoBlocks.PEAR_LEAVES.asItem()
                );
        this.tag(ItemTags.SIGNS)
                .add(
                        EmoBlocks.PEAR_SIGN.asItem()
                );
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(
                        EmoBlocks.PEAR_PRESSURE_PLATE.asItem()
                );
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(
                        EmoBlocks.PEAR_TRAPDOOR.asItem()
                );
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(
                        EmoBlocks.PEAR_STAIRS.asItem()
                );
        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(
                        EmoBlocks.PEAR_BUTTON.asItem()
                );
        this.tag(ItemTags.WOODEN_SLABS)
                .add(
                        EmoBlocks.PEAR_SLAB.asItem()
                );
        this.tag(ItemTags.FENCE_GATES)
                .add(
                        EmoBlocks.PEAR_FENCE_GATE.asItem()
                );
        this.tag(ItemTags.WOODEN_FENCES)
                .add(
                        EmoBlocks.PEAR_FENCE.asItem()
                );
        this.tag(ItemTags.WOODEN_DOORS)
                .add(
                        EmoBlocks.PEAR_DOOR.asItem()
                );
        this.tag(ItemTags.BOATS)
                .add(
                        EmoItems.PEAR_BOAT.get()
                );
        this.tag(ItemTags.CHEST_BOATS)
                .add(
                        EmoItems.PEAR_CHEST_BOAT.get()
                );
        this.tag(ItemTags.FOX_FOOD)
                .add(
                        EmoItems.BLACKCURRANT.get(),
                        EmoItems.BLUEBERRY.get(),
                        EmoItems.DREAMCURRANT.get(),
                        EmoItems.STRAWBERRY.get()
                );
        this.tag(Tags.Items.FOODS_BERRY)
                .add(
                        EmoItems.BLACKCURRANT.get(),
                        EmoItems.BLUEBERRY.get(),
                        EmoItems.DREAMCURRANT.get(),
                        EmoItems.STRAWBERRY.get()
                );
    }
}
