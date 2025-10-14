package fr.emotion.emomodore.recipes;

import fr.emotion.emomodore.components.PhaseRecord;
import fr.emotion.emomodore.init.EmoBlocks;
import fr.emotion.emomodore.init.EmoComponents;
import fr.emotion.emomodore.init.EmoItems;
import fr.emotion.emomodore.init.EmoRecipeSerializer;
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

public class FadingBlockItemRecipe extends CustomRecipe {
    public FadingBlockItemRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        if (input.ingredientCount()!=9) {
            return false;
        } else if (!input.getItem(0).isEmpty() && input.getItem(0).get(EmoComponents.PHASE)!=null) {
            int phase = input.getItem(0).get(EmoComponents.PHASE).value();
            ItemStack stack = input.getItem(0);

            for (int i = 1; i < input.size(); i++) {
                if (!input.getItem(i).is(stack.getItem()) || input.getItem(i).get(EmoComponents.PHASE)==null || input.getItem(i).get(EmoComponents.PHASE).value()!=phase)
                    return false;
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        if (input.getItem(0).get(EmoComponents.PHASE)!=null) {
            PhaseRecord phase = input.getItem(0).get(EmoComponents.PHASE);
            ItemStack stack = input.getItem(0).is(EmoItems.LUME_STONE) ? new ItemStack(EmoBlocks.LUME_BLOCK.asItem()):new ItemStack(EmoBlocks.VIRIDIS_BLOCK.asItem());
            stack.set(EmoComponents.PHASE, phase);
            stack.set(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.emomodore.phase.tooltip").append(": " + phase.value()).withStyle(ChatFormatting.DARK_AQUA))));
            return stack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return EmoRecipeSerializer.LUME_STONE.get();
    }
}
