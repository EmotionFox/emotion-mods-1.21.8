package fr.emotion.emomodore.item;

import fr.emotion.emomodore.init.ComponentRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jetbrains.annotations.Nullable;

public class LumeStone extends FadedItem {
    public LumeStone(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        int phase = itemStack.get(ComponentRegistry.PHASE.get()).value();
        return 3200 / 4 * phase;
    }
}
