package fr.emotion.emomodore.init;

import fr.emotion.emomodore.EmoMain;
import fr.emotion.emomodore.recipes.LumeBlockRecipe;
import fr.emotion.emomodore.recipes.LumeRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoRecipeSerializer {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, EmoMain.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, CustomRecipe.Serializer<LumeRecipe>> LUME_BLOCK = SERIALIZER.register("crafting_special_lume_block", () -> new CustomRecipe.Serializer<>(LumeRecipe::new));
    public static final DeferredHolder<RecipeSerializer<?>, CustomRecipe.Serializer<LumeBlockRecipe>> LUME_STONE = SERIALIZER.register("crafting_special_lume_stone", () -> new CustomRecipe.Serializer<>(LumeBlockRecipe::new));

    public static void init(IEventBus event) {
        SERIALIZER.register(event);
    }
}
