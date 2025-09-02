package fr.emotion.emomodcore.core;

import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;

public interface DispenserReactive {
    public default ItemStack react(LevelReader level, BlockSource source, ItemStack stack) {
        return stack;
    }
}
