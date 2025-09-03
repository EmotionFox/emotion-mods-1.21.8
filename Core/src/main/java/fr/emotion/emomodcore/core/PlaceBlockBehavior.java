package fr.emotion.emomodcore.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;

public class PlaceBlockBehavior extends DefaultDispenseItemBehavior {
    protected final DispenseItemBehavior vanillaBehavior;

    public PlaceBlockBehavior() {
        this.vanillaBehavior = null;
    }

    public PlaceBlockBehavior(DispenseItemBehavior itemBehavior) {
        this.vanillaBehavior = itemBehavior;
    }

    @Override
    protected ItemStack execute(BlockSource blockSource, ItemStack stack) {
        BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
        ServerLevel level = blockSource.level();

        if (stack.getItem() instanceof BlockItem item) {
            Block block = item.getBlock();

            if (block.defaultBlockState().canSurvive(level, blockPos.above())) {
                level.setBlockAndUpdate(blockPos.above(), block.defaultBlockState());
                level.gameEvent(null, GameEvent.BLOCK_PLACE, blockPos.above());
                stack.shrink(1);

                return stack;
            }
        }

        return vanillaBehavior!=null ? vanillaBehavior.dispense(blockSource, stack):super.execute(blockSource, stack);
    }
}
