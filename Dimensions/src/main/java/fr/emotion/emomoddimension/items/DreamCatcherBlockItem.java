package fr.emotion.emomoddimension.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DreamCatcherBlockItem extends BlockItem {
    public DreamCatcherBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean canPlace(BlockPlaceContext context, BlockState state) {
        return context.getLevel().getBlockState(context.getClickedPos()).canBeReplaced() && context.getClickedFace().getAxis().isHorizontal() && context.getLevel().getBlockState(context.getClickedPos().relative(context.getClickedFace().getOpposite())).isSolidRender();
    }
}
