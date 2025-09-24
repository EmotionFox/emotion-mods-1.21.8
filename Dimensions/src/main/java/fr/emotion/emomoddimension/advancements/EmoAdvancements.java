package fr.emotion.emomoddimension.advancements;

import fr.emotion.emomoddimension.datagen.setBuilder.EmoDimension;
import fr.emotion.emomoddimension.init.EmoBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class EmoAdvancements implements AdvancementSubProvider {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> writer) {
        AdvancementHolder advancementHolder = Advancement.Builder.advancement()
                .parent(fr.emotion.emomodcore.advancements.EmoAdvancements.mainAdvancementHolder)
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
