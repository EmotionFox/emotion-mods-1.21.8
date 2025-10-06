package fr.emotion.emomodfood.items;

import fr.emotion.emomodfood.blocks.entity.PotBlockEntity;
import fr.emotion.emomodfood.components.PotRecord;
import fr.emotion.emomodfood.init.EmoComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PotBlockItem extends BlockItem {
    public PotBlockItem(Block block, Properties properties) {
        super(block, properties.component(EmoComponents.POT.get(), new PotRecord("empty", 0)));
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext context, BlockState state) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        boolean placed = level.setBlock(pos, state, 11);

        if (placed && level.getBlockEntity(pos)!=null && level.getBlockEntity(pos) instanceof PotBlockEntity potBlockEntity) {

            ItemStack stack = context.getItemInHand();
            PotRecord potRecord = stack.getComponents().getOrDefault(EmoComponents.POT.get(), new PotRecord("empty", 0));
            potBlockEntity.setPot(potRecord.contentType(), potRecord.fillLevel());
        }

        return placed;
    }
}
