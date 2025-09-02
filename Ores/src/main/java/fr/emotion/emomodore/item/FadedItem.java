package fr.emotion.emomodore.item;

import fr.emotion.emomodore.components.PhaseRecord;
import fr.emotion.emomodore.init.EmoComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemLore;

import java.util.List;

public class FadedItem extends Item {
    public FadedItem(Properties properties) {
        super(properties.component(EmoComponents.PHASE.get(), new PhaseRecord(4)).component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.emomodore.phase.tooltip").append(": " + 4).withStyle(ChatFormatting.DARK_AQUA)))));
    }
}
