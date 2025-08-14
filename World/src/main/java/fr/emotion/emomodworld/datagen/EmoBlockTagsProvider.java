package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.tags.EmoBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class EmoBlockTagsProvider extends BlockTagsProvider {
    public EmoBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, EmoMain.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.REPLACEABLE_BY_TREES)
                .add(
                        EmoBlocks.DREAM_SHORT_GRASS.get(),
                        EmoBlocks.DREAM_TALL_GRASS.get()
                );
        this.tag(BlockTags.REPLACEABLE_BY_MUSHROOMS)
                .add(
                        EmoBlocks.DREAM_SHORT_GRASS.get(),
                        EmoBlocks.DREAM_TALL_GRASS.get()
                );
        this.tag(BlockTags.FLOWER_POTS)
                .add(
                        EmoBlocks.POTTED_FLOWER_KITTY.get(),
                        EmoBlocks.POTTED_FLOWER_NOX.get(),
                        EmoBlocks.POTTED_FLOWER_DELY.get(),
                        EmoBlocks.POTTED_FLOWER_GNON.get(),
                        EmoBlocks.POTTED_FLOWER_THORNY.get(),
                        EmoBlocks.POTTED_FLOWER_CENTUS.get(),
                        EmoBlocks.POTTED_FLOWER_NEBULA.get(),
                        EmoBlocks.POTTED_FLOWER_NARCOTA.get(),
                        EmoBlocks.POTTED_PEAR_SAPLING.get()
                );
        this.tag(BlockTags.PLANKS)
                .add(
                        EmoBlocks.PEAR_PLANKS.get()
                );
        this.tag(BlockTags.SAPLINGS)
                .add(
                        EmoBlocks.PEAR_SAPLING.get()
                );
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(
                        EmoBlocks.PEAR_LOG.get()
                );
        this.tag(Tags.Blocks.STRIPPED_LOGS)
                .add(
                        EmoBlocks.STRIPPED_PEAR_LOG.get()
                );
        this.tag(EmoBlockTags.PEAR_LOGS)
                .add(
                        EmoBlocks.PEAR_LOG.get(),
                        EmoBlocks.PEAR_WOOD.get(),
                        EmoBlocks.STRIPPED_PEAR_LOG.get(),
                        EmoBlocks.STRIPPED_PEAR_WOOD.get()
                );
        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(EmoBlockTags.PEAR_LOGS);
        this.tag(BlockTags.LEAVES)
                .add(
                        EmoBlocks.PEAR_LEAVES.get()
                );
        this.tag(BlockTags.STANDING_SIGNS)
                .add(
                        EmoBlocks.PEAR_SIGN.get()
                );
        this.tag(BlockTags.WALL_SIGNS)
                .add(
                        EmoBlocks.PEAR_WALL_SIGN.get()
                );
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(
                        EmoBlocks.PEAR_PRESSURE_PLATE.get()
                );
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(
                        EmoBlocks.PEAR_TRAPDOOR.get()
                );
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(
                        EmoBlocks.PEAR_STAIRS.get()
                );
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(
                        EmoBlocks.PEAR_BUTTON.get()
                );
        this.tag(BlockTags.WOODEN_SLABS)
                .add(
                        EmoBlocks.PEAR_SLAB.get()
                );
        this.tag(BlockTags.FENCE_GATES)
                .add(
                        EmoBlocks.PEAR_FENCE_GATE.get()
                );
        this.tag(BlockTags.WOODEN_FENCES)
                .add(
                        EmoBlocks.PEAR_FENCE.get()
                );
        this.tag(BlockTags.WOODEN_DOORS)
                .add(
                        EmoBlocks.PEAR_DOOR.get()
                );
    }
}
