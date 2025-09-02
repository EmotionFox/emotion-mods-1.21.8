package fr.emotion.emomodcore.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;

public class InteractBehavior extends DefaultDispenseItemBehavior {
    @Override
    protected ItemStack execute(BlockSource blockSource, ItemStack stack) {
        Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
        BlockPos blockPos = blockSource.pos().relative(direction);
        ServerLevel level = blockSource.level();
        Block block = level.getBlockState(blockPos).getBlock();

        if (block instanceof DispenserReactive reactiveBlock) return reactiveBlock.react(level, blockSource, stack);
        else return super.execute(blockSource, stack);
    }
}
