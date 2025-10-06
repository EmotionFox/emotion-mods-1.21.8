package fr.emotion.emomodfood.datagen;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.init.EmoItems;
import fr.emotion.emomodfood.recipes.PotRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class EmoRecipeProvider extends RecipeProvider {
    protected EmoRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        this.shaped(RecipeCategory.MISC, EmoItems.POT)
                .define('#', ItemTags.PLANKS)
                .define('X', Blocks.GLASS)
                .pattern("X#X")
                .pattern("X X")
                .pattern("XXX")
                .group("pot")
                .unlockedBy("has_glass", this.has(Blocks.GLASS))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.CAKE_CHOCOLATE)
                .define('#', Items.COCOA_BEANS)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.CAKE_STRAWBERRY)
                .define('#', fr.emotion.emomodworld.init.EmoItems.STRAWBERRY)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.CAKE_FRUIT)
                .define('#', fr.emotion.emomodworld.init.EmoItems.PEAR)
                .define('&', fr.emotion.emomodworld.init.EmoItems.ORANGE)
                .define('=', fr.emotion.emomodworld.init.EmoItems.CHERRY)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X&")
                .pattern("=YZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.CAKE_TOFFEE)
                .define('#', EmoItems.TOFFEE)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        SpecialRecipeBuilder.special(PotRecipe::new).save(this.output, EmoMain.MODID + ":pot_fruit");
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
