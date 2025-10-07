package fr.emotion.emomodfurniture.datagen;

import fr.emotion.emomodfurniture.EmoMain;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public class EmoRecipeProvider extends RecipeProvider {
    protected EmoRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

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
