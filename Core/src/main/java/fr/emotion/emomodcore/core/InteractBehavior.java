package fr.emotion.emomodcore.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

public class InteractBehavior extends DefaultDispenseItemBehavior {
    protected final DispenseItemBehavior vanillaBehavior;

    public InteractBehavior() {
        this.vanillaBehavior = null;
    }

    public InteractBehavior(DispenseItemBehavior itemBehavior) {
        this.vanillaBehavior = itemBehavior;
    }

    @Override
    protected ItemStack execute(BlockSource blockSource, ItemStack stack) {
        Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
        BlockPos blockPos = blockSource.pos().relative(direction);
        ServerLevel level = blockSource.level();
        BlockState blockState = level.getBlockState(blockPos);
        Block block = blockState.getBlock();

        if (block instanceof DispenserReactive reactiveBlock) {
            if (reactiveBlock.react(level, blockState, blockPos, stack)==InteractionResult.SUCCESS)
                return this.consumeWithRemainder(blockSource, stack, new ItemStack(Items.BUCKET));
        }

        return vanillaBehavior!=null ? vanillaBehavior.dispense(blockSource, stack):super.execute(blockSource, stack);
    }
}
