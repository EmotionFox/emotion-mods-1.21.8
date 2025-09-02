package fr.emotion.emomodcore.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

public class InteractBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

    @Override
    protected ItemStack execute(BlockSource blockSource, ItemStack stack) {
        Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
        BlockPos blockPos = blockSource.pos().relative(direction);
        ServerLevel level = blockSource.level();
        BlockState blockState = level.getBlockState(blockPos);
        Block block = blockState.getBlock();
        InteractionResult result = InteractionResult.FAIL;

        if (block instanceof DispenserReactive reactiveBlock) {
            result = reactiveBlock.react(level, blockState, blockPos, stack);
        }

        if (stack.getItem() instanceof DispensibleContainerItem reactiveItem) {
            if (result==InteractionResult.SUCCESS) {
                return this.consumeWithRemainder(blockSource, stack, new ItemStack(Items.BUCKET));
            } else if (reactiveItem.emptyContents(null, level, blockPos, null, stack)) {
                reactiveItem.checkExtraContent(null, level, stack, blockPos);
                return this.consumeWithRemainder(blockSource, stack, new ItemStack(Items.BUCKET));
            }
        }

        return super.execute(blockSource, stack);
    }
}
