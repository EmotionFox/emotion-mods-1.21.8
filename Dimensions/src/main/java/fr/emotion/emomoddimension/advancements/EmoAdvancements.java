package fr.emotion.emomoddimension.advancements;

import fr.emotion.emomoddimension.datagen.setBuilder.EmoDimension;
import fr.emotion.emomoddimension.init.EmoBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

public class EmoAdvancements implements AdvancementSubProvider {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> writer) {
        HolderLookup<Item> itemRegistry = registries.lookupOrThrow(Registries.ITEM);

        AdvancementHolder advancementHolder = Advancement.Builder.advancement()
                .parent(fr.emotion.emomodcore.advancements.EmoAdvancements.mainAdvancementHolder)
                .display(
                        EmoBlocks.DREAM_CATCHER,
                        Component.translatable("advancements.emo.craft_dream_catcher.title"),
                        Component.translatable("advancements.emo.craft_dream_catcher.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .addCriterion("craft_dream_catcher", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(itemRegistry, EmoBlocks.DREAM_CATCHER.asItem())))
                .save(writer, "emo/craft_dream_catcher");
        AdvancementHolder advancementHolder1 = Advancement.Builder.advancement()
                .parent(advancementHolder)
                .display(
                        EmoBlocks.DREAM_GRASS_BLOCK,
                        Component.translatable("advancements.emo.enter_the_dream.title"),
                        Component.translatable("advancements.emo.enter_the_dream.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("entered_dream", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(EmoDimension.DREAM))
                .save(writer, "emo/enter_the_dream");
    }
}
