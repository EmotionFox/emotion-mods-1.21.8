package fr.emotion.emomodcore.core;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public interface DispenserReactive {
    public InteractionResult react(ServerLevel level, BlockState blockState, BlockPos blockPos, ItemStack stack);
}
