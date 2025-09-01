package fr.emotion.emomoddimension.datagen;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.init.EmoBlocks;
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
        this.tag(BlockTags.PORTALS)
                .add(
                        EmoBlocks.DREAM_PORTAL.get()
                );
        this.tag(BlockTags.VALID_SPAWN)
                .add(
                        EmoBlocks.DREAM_GRASS_BLOCK.get()
                );
        this.tag(BlockTags.SMALL_DRIPLEAF_PLACEABLE)
                .add(
                        EmoBlocks.DREAM_GRASS_BLOCK.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        EmoBlocks.DREAM_GRASS_BLOCK.get()
                );
        this.tag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(
                        EmoBlocks.DREAM_GRASS_BLOCK.get()
                );
        this.tag(BlockTags.PARROTS_SPAWNABLE_ON)
                .add(
                        EmoBlocks.DREAM_GRASS_BLOCK.get()
                );
        this.tag(BlockTags.RABBITS_SPAWNABLE_ON)
                .add(
                        EmoBlocks.DREAM_GRASS_BLOCK.get()
                );
        this.tag(BlockTags.FOXES_SPAWNABLE_ON)
                .add(
                        EmoBlocks.DREAM_GRASS_BLOCK.get()
                );
        this.tag(BlockTags.WOLVES_SPAWNABLE_ON)
                .add(
                        EmoBlocks.DREAM_GRASS_BLOCK.get()
                );
        this.tag(BlockTags.FROGS_SPAWNABLE_ON)
                .add(
                        EmoBlocks.DREAM_GRASS_BLOCK.get()
                );
        this.tag(BlockTags.SNIFFER_DIGGABLE_BLOCK)
                .add(
                        EmoBlocks.DREAM_GRASS_BLOCK.get()
                );
    }
}
