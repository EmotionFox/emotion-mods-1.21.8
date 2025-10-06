package fr.emotion.emomodfood.init;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.recipes.PotRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoRecipeSerializer {
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, EmoMain.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, CustomRecipe.Serializer<PotRecipe>> POT = RECIPE_SERIALIZER.register("crafting_special_pot", () -> new CustomRecipe.Serializer<>(PotRecipe::new));

    public static void init(IEventBus event) {
        RECIPE_SERIALIZER.register(event);
    }
}
