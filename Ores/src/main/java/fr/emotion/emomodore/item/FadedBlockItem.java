package fr.emotion.emomodore.item;

import fr.emotion.emomodore.block.state.EmoBlockStateProperties;
import fr.emotion.emomodore.components.PhaseRecord;
import fr.emotion.emomodore.init.EmoComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class FadedBlockItem extends BlockItem {
    public FadedBlockItem(Block block, Properties properties) {
        super(block, properties.component(EmoComponents.PHASE.get(), new PhaseRecord(4)).component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.emomodore.phase.tooltip").append(": " + 4).withStyle(ChatFormatting.DARK_AQUA)))));
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext context, BlockState state) {
        int phase = context.getItemInHand().get(EmoComponents.PHASE).value();
        return super.placeBlock(context, state.setValue(EmoBlockStateProperties.PHASE, phase));
    }
}
