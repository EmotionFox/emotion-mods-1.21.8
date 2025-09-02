package fr.emotion.emomodore.item;

import fr.emotion.emomodore.init.EmoComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jetbrains.annotations.Nullable;

public class LumeBlockItem extends FadedBlockItem {
    public LumeBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        int phase = itemStack.get(EmoComponents.PHASE.get()).value();
        return 32000 / 4 * phase;
    }
}
