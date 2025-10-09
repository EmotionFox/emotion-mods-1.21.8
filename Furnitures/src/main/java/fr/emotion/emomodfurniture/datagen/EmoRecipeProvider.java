package fr.emotion.emomodfurniture.datagen;

import fr.emotion.emomodfurniture.EmoMain;
import fr.emotion.emomodfurniture.blocks.TableBlock;
import fr.emotion.emomodfurniture.init.EmoBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.concurrent.CompletableFuture;

public class EmoRecipeProvider extends RecipeProvider {
    protected EmoRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        for (DeferredHolder<Block, ? extends Block> block : EmoBlocks.getBlocks().getEntries()) {
            if (block.get() instanceof TableBlock table) {
                if (table.isStone) {
                    this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, table, table.texture.get());
                    this.shaped(RecipeCategory.BUILDING_BLOCKS, table, 4)
                            .define('#', table.texture.get())
                            .define('X', Blocks.SMOOTH_STONE_SLAB)
                            .pattern("XXX")
                            .pattern(" # ")
                            .pattern("###")
                            .group("stone_table")
                            .unlockedBy("has_stone", this.has(table.texture.get()))
                            .save(this.output);
                } else {
                    this.shaped(RecipeCategory.BUILDING_BLOCKS, table, 4)
                            .define('#', table.texture.get())
                            .define('X', Items.STICK)
                            .pattern("XXX")
                            .pattern(" # ")
                            .pattern("###")
                            .group("wood_table")
                            .unlockedBy("has_planks", this.has(ItemTags.PLANKS))
                            .save(this.output);
                }
            }
        }
    }

    public static class Runner extends RecipeProvider.Runner {
        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new EmoRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return EmoMain.MODID + " recipes";
        }
    }
}
