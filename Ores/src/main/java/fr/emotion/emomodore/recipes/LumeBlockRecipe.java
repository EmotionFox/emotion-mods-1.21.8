package fr.emotion.emomodore.recipes;

import fr.emotion.emomodore.components.PhaseRecord;
import fr.emotion.emomodore.init.BlockRegistry;
import fr.emotion.emomodore.init.ComponentRegistry;
import fr.emotion.emomodore.init.ItemRegistry;
import fr.emotion.emomodore.init.RecipeSerializerRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

import java.util.List;

public class LumeBlockRecipe extends CustomRecipe {
    public LumeBlockRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        if (input.ingredientCount()!=9) {
            return false;
        } else {
            int phase = input.getItem(0).get(ComponentRegistry.PHASE).value();

            for (int i = 1; i < input.size(); i++) {
                if ((input.getItem(i).getItem()!=ItemRegistry.LUME_STONE.get()) || (input.getItem(i).get(ComponentRegistry.PHASE).value()!=phase))
                    return false;
            }

            return true;
        }
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        PhaseRecord phase = input.getItem(0).get(ComponentRegistry.PHASE);
        ItemStack stack = new ItemStack(BlockRegistry.LUME_BLOCK.get().asItem());
        stack.set(ComponentRegistry.PHASE, phase);
        stack.set(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.emomodore.phase.tooltip").append(": " + phase.value()).withStyle(ChatFormatting.DARK_AQUA))));
        return stack;
    }

    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return RecipeSerializerRegistry.LUME_STONE.get();
    }
}
