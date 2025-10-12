package fr.emotion.emomodfood.recipes;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.blocks.entity.PotBlockEntity;
import fr.emotion.emomodfood.components.PotRecord;
import fr.emotion.emomodfood.init.EmoComponents;
import fr.emotion.emomodfood.init.EmoItems;
import fr.emotion.emomodfood.init.EmoRecipeSerializer;
import fr.emotion.emomodfood.utils.EmoUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class PotRecipe extends CustomRecipe {
    private ItemStack fruit = null;

    public PotRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        if (input.ingredientCount()!=6) {
            return false;
        } else {
            boolean hasEmptyPot = false;
            boolean hasSugar = false;
            int fruitCount = 0;
            this.fruit = null;

            for (int i = 0; i < input.size(); i++) {
                ItemStack stack = input.getItem(i);

                EmoMain.LOGGER.info("Stack: " + stack.toString());

                if (stack.is(EmoItems.POT.get())) {
                    PotRecord component = stack.getComponents().get(EmoComponents.POT);

                    if (component!=null) {
                        if (!component.contentType().equals("empty"))
                            return false;
                        else {
                            hasEmptyPot = true;
                        }
                    }
                } else if (stack.is(Items.SUGAR)) {
                    hasSugar = true;
                } else if (!stack.is(Items.AIR)) {
                    if (this.fruit==null) {
                        if (stack.is(Items.COCOA_BEANS) || stack.is(Items.SWEET_BERRIES) || PotBlockEntity.PotContentType.byName(BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath())!=PotBlockEntity.PotContentType.EMPTY) {
                            this.fruit = stack;
                            fruitCount++;
                        } else {
                            return false;
                        }
                    } else if (stack.is(this.fruit.getItem())) {
                        fruitCount++;
                    } else {
                        return false;
                    }
                }
            }

            if (hasEmptyPot && fruitCount==4 && hasSugar) return true;
            else return false;
        }
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        ItemStack stack = new ItemStack(EmoItems.POT.get());
        PotRecord component = new PotRecord("empty", 0);

        if (this.fruit!=null) {
            if (this.fruit.is(Items.COCOA_BEANS)) component = new PotRecord("chocolate", 4);
            else if (this.fruit.is(Items.SWEET_BERRIES)) component = new PotRecord("sweetberry", 4);
            else component = new PotRecord(BuiltInRegistries.ITEM.getKey(this.fruit.getItem()).getPath(), 4);
        }

        return EmoUtils.definePotDataComponents(stack, component);
    }

    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return EmoRecipeSerializer.POT.get();
    }
}
