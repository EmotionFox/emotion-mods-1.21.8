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

public class FadingBlockRecipe extends CustomRecipe {
    public FadingBlockRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        if (input.ingredientCount()!=1) {
            return false;
        } else if (input.getItem(0).is(EmoBlocks.LUME_BLOCK.asItem()) || input.getItem(0).is(EmoBlocks.VIRIDIS_BLOCK.asItem())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        PhaseRecord phase = input.getItem(0).get(EmoComponents.PHASE);
        ItemStack stack = input.getItem(0).is(EmoBlocks.LUME_BLOCK.asItem()) ? new ItemStack(EmoItems.LUME_STONE.get(), 9):new ItemStack(EmoBlocks.VIRIDIS_CRYSTAL.asItem(), 9);
        stack.set(EmoComponents.PHASE, phase);
        stack.set(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.emomodore.phase.tooltip").append(": " + phase.value()).withStyle(ChatFormatting.DARK_AQUA))));
        return stack;
    }

    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return EmoRecipeSerializer.LUME_BLOCK.get();
    }
}
