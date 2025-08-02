package fr.emotion.emomodore.item;

import fr.emotion.emomodore.components.PhaseRecord;
import fr.emotion.emomodore.init.ComponentRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class LumeBlockItem extends FadedBlockItem {
    public LumeBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

//    @Override
//    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
//        PhaseRecord phase = stack.get(ComponentRegistry.PHASE.get());
//        tooltipAdder.accept(Component.literal("Burning Time: " + (32000 / 4 * phase.value())));
//        super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, flag);
//    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        int phase = itemStack.get(ComponentRegistry.PHASE.get()).value();
        return 32000 / 4 * phase;
    }
}
