package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoItems;
import fr.emotion.emomodworld.tags.EmoItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;

import java.util.concurrent.CompletableFuture;

public class EmoRecipeProvider extends RecipeProvider {
    protected EmoRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        this.planksFromLogs(EmoBlocks.PEAR_PLANKS, EmoItemTags.PEAR_LOGS, 4);
        this.woodFromLogs(EmoBlocks.PEAR_WOOD, EmoBlocks.PEAR_LOG);
        this.woodFromLogs(EmoBlocks.STRIPPED_PEAR_WOOD, EmoBlocks.STRIPPED_PEAR_LOG);
        this.hangingSign(EmoBlocks.PEAR_HANGING_SIGN, EmoBlocks.STRIPPED_PEAR_LOG);

        EmoBlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateRecipe).forEach(blockFamily -> this.generateRecipes(blockFamily, FeatureFlagSet.of(FeatureFlags.VANILLA)));

        this.woodenBoat(EmoItems.PEAR_BOAT, EmoBlocks.PEAR_PLANKS);
        this.chestBoat(EmoItems.PEAR_CHEST_BOAT, EmoItems.PEAR_BOAT);
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
