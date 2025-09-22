package fr.emotion.emomodcore.advancements;

import fr.emotion.emomodcore.EmoMain;
import fr.emotion.emomodcore.init.EmoBlocksAndItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class EmoAdvancements implements AdvancementSubProvider {
    public static AdvancementHolder mainAdvancementHolder = Advancement.Builder.advancement().build(ResourceLocation.parse("emo/root"));

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> writer) {
        mainAdvancementHolder = Advancement.Builder.advancement()
                .display(
                        EmoBlocksAndItems.ADVANCEMENT_ITEM.get(),
                        Component.translatable("advancements.emo.root.title"),
                        Component.translatable("advancements.emo.root.description"),
                        ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "gui/advancements/backgrounds/emo"),
                        AdvancementType.TASK,
                        false,
                        false,
                        false
                )
                .addCriterion("crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CRAFTING_TABLE))
                .save(writer, "emo/root");
    }
}
