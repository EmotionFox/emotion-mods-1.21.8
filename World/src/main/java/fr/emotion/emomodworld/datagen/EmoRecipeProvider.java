package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoItems;
import fr.emotion.emomodworld.tags.EmoItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmokingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class EmoRecipeProvider extends RecipeProvider {
    protected EmoRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        this.oneToOneConversionRecipe(Items.YELLOW_DYE, EmoBlocks.FLOWER_KITTY, "yellow_dye");
        this.oneToOneConversionRecipe(Items.CYAN_DYE, EmoBlocks.FLOWER_NOX, "cyan_dye");
        this.oneToOneConversionRecipe(Items.PURPLE_DYE, EmoBlocks.FLOWER_DELY, "purple_dye");
        this.oneToOneConversionRecipe(Items.ORANGE_DYE, EmoBlocks.FLOWER_GNON, "orange_dye");
        this.oneToOneConversionRecipe(Items.STICK, EmoBlocks.FLOWER_THORNY, "stick", 2);
        this.oneToOneConversionRecipe(Items.STICK, Blocks.DEAD_BUSH, "stick", 2);
        this.oneToOneConversionRecipe(Items.BLUE_DYE, EmoBlocks.FLOWER_CENTUS, "blue_dye");
        this.oneToOneConversionRecipe(Items.LIGHT_GRAY_DYE, EmoBlocks.FLOWER_NEBULA, "light_gray_dye");
        this.oneToOneConversionRecipe(Items.LIGHT_GRAY_DYE, EmoBlocks.FLOWER_NARCOTA, "light_gray_dye");

        // PEAR
        this.planksFromLogs(EmoBlocks.PEAR_PLANKS, EmoItemTags.PEAR_LOGS, 4);
        this.woodFromLogs(EmoBlocks.PEAR_WOOD, EmoBlocks.PEAR_LOG);
        this.woodFromLogs(EmoBlocks.STRIPPED_PEAR_WOOD, EmoBlocks.STRIPPED_PEAR_LOG);
        this.hangingSign(EmoBlocks.PEAR_HANGING_SIGN, EmoBlocks.STRIPPED_PEAR_LOG);

        this.woodenBoat(EmoItems.PEAR_BOAT, EmoBlocks.PEAR_PLANKS);
        this.chestBoat(EmoItems.PEAR_CHEST_BOAT, EmoItems.PEAR_BOAT);

        // ORANGE
        this.planksFromLogs(EmoBlocks.ORANGE_PLANKS, EmoItemTags.ORANGE_LOGS, 4);
        this.woodFromLogs(EmoBlocks.ORANGE_WOOD, EmoBlocks.ORANGE_LOG);
        this.woodFromLogs(EmoBlocks.STRIPPED_ORANGE_WOOD, EmoBlocks.STRIPPED_ORANGE_LOG);
        this.hangingSign(EmoBlocks.ORANGE_HANGING_SIGN, EmoBlocks.STRIPPED_ORANGE_LOG);

        this.woodenBoat(EmoItems.ORANGE_BOAT, EmoBlocks.ORANGE_PLANKS);
        this.chestBoat(EmoItems.ORANGE_CHEST_BOAT, EmoItems.ORANGE_BOAT);

        // ATLAS
        this.planksFromLogs(EmoBlocks.ATLAS_PLANKS, EmoItemTags.ATLAS_LOGS, 4);
        this.woodFromLogs(EmoBlocks.ATLAS_WOOD, EmoBlocks.ATLAS_LOG);
        this.woodFromLogs(EmoBlocks.STRIPPED_ATLAS_WOOD, EmoBlocks.STRIPPED_ATLAS_LOG);
        this.hangingSign(EmoBlocks.ATLAS_HANGING_SIGN, EmoBlocks.STRIPPED_ATLAS_LOG);

        this.woodenBoat(EmoItems.ATLAS_BOAT, EmoBlocks.ATLAS_PLANKS);
        this.chestBoat(EmoItems.ATLAS_CHEST_BOAT, EmoItems.ATLAS_BOAT);

        // PINE
        this.planksFromLogs(EmoBlocks.PINE_PLANKS, EmoItemTags.PINE_LOGS, 4);
        this.woodFromLogs(EmoBlocks.PINE_WOOD, EmoBlocks.PINE_LOG);
        this.woodFromLogs(EmoBlocks.STRIPPED_PINE_WOOD, EmoBlocks.STRIPPED_PINE_LOG);
        this.hangingSign(EmoBlocks.PINE_HANGING_SIGN, EmoBlocks.STRIPPED_PINE_LOG);

        this.woodenBoat(EmoItems.PINE_BOAT, EmoBlocks.PINE_PLANKS);
        this.chestBoat(EmoItems.PINE_CHEST_BOAT, EmoItems.PINE_BOAT);

        // COCO
        this.planksFromLogs(EmoBlocks.COCO_PLANKS, EmoItemTags.COCO_LOGS, 4);
        this.woodFromLogs(EmoBlocks.COCO_WOOD, EmoBlocks.COCO_LOG);
        this.woodFromLogs(EmoBlocks.STRIPPED_COCO_WOOD, EmoBlocks.STRIPPED_COCO_LOG);
        this.hangingSign(EmoBlocks.COCO_HANGING_SIGN, EmoBlocks.STRIPPED_COCO_LOG);

        this.woodenBoat(EmoItems.COCO_BOAT, EmoBlocks.COCO_PLANKS);
        this.chestBoat(EmoItems.COCO_CHEST_BOAT, EmoItems.COCO_BOAT);

        // DREAM
        this.planksFromLogs(EmoBlocks.DREAM_PLANKS, EmoItemTags.DREAM_LOGS, 4);
        this.woodFromLogs(EmoBlocks.DREAM_WOOD, EmoBlocks.DREAM_LOG);
        this.woodFromLogs(EmoBlocks.STRIPPED_DREAM_WOOD, EmoBlocks.STRIPPED_DREAM_LOG);
        this.hangingSign(EmoBlocks.DREAM_HANGING_SIGN, EmoBlocks.STRIPPED_DREAM_LOG);

        this.woodenBoat(EmoItems.DREAM_BOAT, EmoBlocks.DREAM_PLANKS);
        this.chestBoat(EmoItems.DREAM_CHEST_BOAT, EmoItems.DREAM_BOAT);

        EmoBlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateRecipe).forEach(blockFamily -> this.generateRecipes(blockFamily, FeatureFlagSet.of(FeatureFlags.VANILLA)));

        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_WHITE, Blocks.WHITE_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_ORANGE, Blocks.ORANGE_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_MAGENTA, Blocks.MAGENTA_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_YELLOW, Blocks.YELLOW_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_LIME, Blocks.LIME_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_PINK, Blocks.PINK_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_GRAY, Blocks.GRAY_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_CYAN, Blocks.CYAN_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_PURPLE, Blocks.PURPLE_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_BLUE, Blocks.BLUE_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_BROWN, Blocks.BROWN_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_GREEN, Blocks.GREEN_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_RED, Blocks.RED_WOOL);
        this.netFromSticksAndWool(EmoItems.BUTTERFLY_NET_BLACK, Blocks.BLACK_WOOL);

        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_PEAR_PLANKS, EmoBlocks.PEAR_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_ORANGE_PLANKS, EmoBlocks.ORANGE_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_ATLAS_PLANKS, EmoBlocks.ATLAS_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_PINE_PLANKS, EmoBlocks.PINE_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_COCO_PLANKS, EmoBlocks.COCO_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_DREAM_PLANKS, EmoBlocks.DREAM_PLANKS);

        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_OAK_PLANKS, Blocks.OAK_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_SPRUCE_PLANKS, Blocks.SPRUCE_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_BIRCH_PLANKS, Blocks.BIRCH_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_JUNGLE_PLANKS, Blocks.JUNGLE_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_ACACIA_PLANKS, Blocks.ACACIA_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_CHERRY_PLANKS, Blocks.CHERRY_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_DARK_OAK_PLANKS, Blocks.DARK_OAK_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_PALE_OAK_PLANKS, Blocks.PALE_OAK_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_MANGROVE_PLANKS, Blocks.MANGROVE_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_BAMBOO_PLANKS, Blocks.BAMBOO_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_CRIMSON_PLANKS, Blocks.CRIMSON_PLANKS);
        this.verticalPlanksFromPlanks(EmoBlocks.VERTICAL_WARPED_PLANKS, Blocks.WARPED_PLANKS);

        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_PEAR_PLANKS, EmoBlocks.PEAR_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_ORANGE_PLANKS, EmoBlocks.ORANGE_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_ATLAS_PLANKS, EmoBlocks.ATLAS_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_PINE_PLANKS, EmoBlocks.PINE_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_COCO_PLANKS, EmoBlocks.COCO_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_DREAM_PLANKS, EmoBlocks.DREAM_PLANKS);

        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_OAK_PLANKS, Blocks.OAK_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_SPRUCE_PLANKS, Blocks.SPRUCE_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_BIRCH_PLANKS, Blocks.BIRCH_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_JUNGLE_PLANKS, Blocks.JUNGLE_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_ACACIA_PLANKS, Blocks.ACACIA_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_CHERRY_PLANKS, Blocks.CHERRY_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_DARK_OAK_PLANKS, Blocks.DARK_OAK_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_PALE_OAK_PLANKS, Blocks.PALE_OAK_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_MANGROVE_PLANKS, Blocks.MANGROVE_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_BAMBOO_PLANKS, Blocks.BAMBOO_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_CRIMSON_PLANKS, Blocks.CRIMSON_PLANKS);
        this.planksFromVerticalPlanks(EmoBlocks.VERTICAL_WARPED_PLANKS, Blocks.WARPED_PLANKS);

        this.smeltingResultFromBase(EmoItems.COOKED_HALF_HAM, EmoItems.HALF_HAM);
        this.smeltingResultFromBase(EmoItems.COOKED_HAM, EmoItems.HAM);

        this.cookRecipes("smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, 100);
        this.cookRecipes("campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, 600);
    }

    protected void netFromSticksAndWool(ItemLike net, ItemLike wool) {
        this.shaped(RecipeCategory.TOOLS, net)
                .define('#', wool)
                .define('X', Items.STICK)
                .pattern("#")
                .pattern("X")
                .pattern("X")
                .group("net")
                .unlockedBy(getHasName(wool), this.has(wool))
                .save(this.output);
    }

    protected void verticalPlanksFromPlanks(ItemLike verticalPlanks, ItemLike planks) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, verticalPlanks, 9)
                .define('#', planks)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group("vertical_planks")
                .unlockedBy(getHasName(planks), this.has(planks))
                .save(this.output);
    }

    protected void planksFromVerticalPlanks(ItemLike verticalPlanks, ItemLike planks) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, planks, 9)
                .define('#', verticalPlanks)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group("planks")
                .unlockedBy(getHasName(verticalPlanks), this.has(verticalPlanks))
                .save(this.output, ResourceKey.create(Registries.RECIPE, BuiltInRegistries.ITEM.getKey(planks.asItem()).withSuffix("2")));
    }

    protected <T extends AbstractCookingRecipe> void cookRecipes(
            String cookingMethod, RecipeSerializer<T> cookingSerializer, AbstractCookingRecipe.Factory<T> recipeFactory, int cookingTime
    ) {
        this.simpleCookingRecipe(cookingMethod, cookingSerializer, recipeFactory, cookingTime, EmoItems.HALF_HAM, EmoItems.COOKED_HALF_HAM, 0.2F);
        this.simpleCookingRecipe(cookingMethod, cookingSerializer, recipeFactory, cookingTime, EmoItems.HAM, EmoItems.COOKED_HAM, 0.4F);
    }

    public static class Runner extends RecipeProvider.Runner {
        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new EmoRecipeProvider(provider, output);
        }

        @Override
        public String getName() {
            return EmoMain.MODID + " recipes";
        }
    }
}
