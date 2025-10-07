package fr.emotion.emomodfood.datagen;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.init.EmoItems;
import fr.emotion.emomodfood.recipes.PotRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

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

        this.shaped(RecipeCategory.MISC, EmoItems.GLASS_BOWL, 6)
                .define('#', Blocks.GLASS)
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_fruit", this.has(Tags.Items.FOODS_FRUIT))
                .save(this.output);

        this.shapeless(RecipeCategory.FOOD, EmoItems.JUICE_PEAR)
                .requires(EmoItems.GLASS_BOWL)
                .requires(fr.emotion.emomodworld.init.EmoItems.PEAR)
                .requires(Items.SUGAR)
                .unlockedBy("has_glass_bowl", this.has(EmoItems.GLASS_BOWL))
                .unlockedBy("has_pear", this.has(fr.emotion.emomodworld.init.EmoItems.PEAR))
                .unlockedBy("has_sugar", this.has(Items.SUGAR))
                .save(this.output);

        this.shapeless(RecipeCategory.FOOD, EmoItems.JUICE_CHERRY)
                .requires(EmoItems.GLASS_BOWL)
                .requires(fr.emotion.emomodworld.init.EmoItems.CHERRY)
                .requires(Items.SUGAR)
                .unlockedBy("has_glass_bowl", this.has(EmoItems.GLASS_BOWL))
                .unlockedBy("has_cherry", this.has(fr.emotion.emomodworld.init.EmoItems.CHERRY))
                .unlockedBy("has_sugar", this.has(Items.SUGAR))
                .save(this.output);

        this.shapeless(RecipeCategory.FOOD, EmoItems.JUICE_ORANGE)
                .requires(EmoItems.GLASS_BOWL)
                .requires(fr.emotion.emomodworld.init.EmoItems.ORANGE)
                .requires(Items.SUGAR)
                .unlockedBy("has_glass_bowl", this.has(EmoItems.GLASS_BOWL))
                .unlockedBy("has_orange", this.has(fr.emotion.emomodworld.init.EmoItems.ORANGE))
                .unlockedBy("has_sugar", this.has(Items.SUGAR))
                .save(this.output);

        this.shapeless(RecipeCategory.FOOD, EmoItems.TOMATO)
                .requires(EmoItems.GLASS_BOWL)
                .requires(EmoItems.TOMATO)
                .unlockedBy("has_glass_bowl", this.has(EmoItems.GLASS_BOWL))
                .unlockedBy("has_tomato", this.has(EmoItems.TOMATO))
                .save(this.output);

        this.shapeless(RecipeCategory.FOOD, EmoItems.JUICE_APPLE)
                .requires(EmoItems.GLASS_BOWL)
                .requires(Items.APPLE)
                .requires(Items.SUGAR)
                .unlockedBy("has_glass_bowl", this.has(EmoItems.GLASS_BOWL))
                .unlockedBy("has_apple", this.has(Items.APPLE))
                .unlockedBy("has_sugar", this.has(Items.SUGAR))
                .save(this.output);

        this.shapeless(RecipeCategory.FOOD, EmoItems.PIE_PEAR)
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .requires(fr.emotion.emomodworld.init.EmoItems.PEAR)
                .unlockedBy("has_pear", this.has(fr.emotion.emomodworld.init.EmoItems.PEAR))
                .save(this.output);

        this.shapeless(RecipeCategory.FOOD, EmoItems.PIE_CHERRY)
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .requires(fr.emotion.emomodworld.init.EmoItems.CHERRY)
                .unlockedBy("has_cherry", this.has(fr.emotion.emomodworld.init.EmoItems.CHERRY))
                .save(this.output);

        this.shapeless(RecipeCategory.FOOD, EmoItems.PIE_ORANGE)
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .requires(fr.emotion.emomodworld.init.EmoItems.ORANGE)
                .unlockedBy("has_orange", this.has(fr.emotion.emomodworld.init.EmoItems.ORANGE))
                .save(this.output);

        this.shapeless(RecipeCategory.FOOD, EmoItems.PIE_APPLE)
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .requires(Items.APPLE)
                .unlockedBy("has_apple", this.has(Items.APPLE))
                .save(this.output);

        this.shapeless(RecipeCategory.FOOD, EmoItems.PIE_MELON)
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .requires(Items.MELON)
                .unlockedBy("has_melon", this.has(Blocks.MELON))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.MUFFIN_PEAR, 2)
                .define('#', fr.emotion.emomodworld.init.EmoItems.PEAR)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.MUFFIN_CHERRY, 2)
                .define('#', fr.emotion.emomodworld.init.EmoItems.CHERRY)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.MUFFIN_ORANGE, 2)
                .define('#', fr.emotion.emomodworld.init.EmoItems.ORANGE)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.MUFFIN_APPLE, 2)
                .define('#', Items.APPLE)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.MUFFIN_BLACKCURRANT, 2)
                .define('#', fr.emotion.emomodworld.init.EmoItems.BLACKCURRANT)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.MUFFIN_BLUEBERRY, 2)
                .define('#', fr.emotion.emomodworld.init.EmoItems.BLUEBERRY)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.MUFFIN_DREAMCURRANT, 2)
                .define('#', fr.emotion.emomodworld.init.EmoItems.DREAMCURRANT)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        this.shaped(RecipeCategory.FOOD, EmoItems.MUFFIN_STRAWBERRY, 2)
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

        this.shaped(RecipeCategory.FOOD, EmoItems.MUFFIN_SWEETBERRY, 2)
                .define('#', Items.SWEET_BERRIES)
                .define('X', Items.MILK_BUCKET)
                .define('Y', ItemTags.EGGS)
                .define('Z', Items.SUGAR)
                .define('S', Items.WHEAT)
                .pattern("#X#")
                .pattern("ZYZ")
                .pattern("SSS")
                .unlockedBy("has_egg", this.has(Items.EGG))
                .save(this.output);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.SUGAR), RecipeCategory.FOOD, EmoItems.TOFFEE, 0.35F, 200)
                .unlockedBy("has_sugar", this.has(Items.SUGAR))
                .save(this.output);

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.SUGAR), RecipeCategory.FOOD, EmoItems.TOFFEE, 0.35F, 200)
                .unlockedBy("has_sugar", this.has(Items.SUGAR))
                .save(this.output, EmoMain.MODID + ":toffee_smoking");

        this.shaped(RecipeCategory.FOOD, EmoItems.TOFFEE_APPLE)
                .define('#', EmoItems.TOFFEE)
                .define('X', Items.APPLE)
                .define('Y', Items.STICK)
                .pattern("#")
                .pattern("X")
                .pattern("Y")
                .unlockedBy("has_apple", this.has(Items.APPLE))
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
