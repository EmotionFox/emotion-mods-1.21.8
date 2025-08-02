package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
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
        this.tag(BlockTags.FLOWER_POTS)
                .add(
                        EmoBlocks.POTTED_FLOWER_1.get(),
                        EmoBlocks.POTTED_FLOWER_2.get(),
                        EmoBlocks.POTTED_FLOWER_3.get(),
                        EmoBlocks.POTTED_FLOWER_4.get(),
                        EmoBlocks.POTTED_FLOWER_5.get(),
                        EmoBlocks.POTTED_FLOWER_6.get(),
                        EmoBlocks.POTTED_FLOWER_7.get(),
                        EmoBlocks.POTTED_FLOWER_8.get(),
                        EmoBlocks.POTTED_FLOWER_9.get()
                );
    }
}
