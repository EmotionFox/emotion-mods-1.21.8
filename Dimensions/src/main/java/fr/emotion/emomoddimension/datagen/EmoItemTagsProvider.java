package fr.emotion.emomoddimension.datagen;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.init.EmoBlocks;
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
        this.tag(ItemTags.STONE_TOOL_MATERIALS)
                .add(
                        EmoBlocks.DREAM_COBBLESTONE.asItem()
                );
        this.tag(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(
                        EmoBlocks.DREAM_COBBLESTONE.asItem()
                );
        this.tag(Tags.Items.STONES)
                .add(
                        EmoBlocks.DREAM_STONE.asItem()
                );
    }
}
