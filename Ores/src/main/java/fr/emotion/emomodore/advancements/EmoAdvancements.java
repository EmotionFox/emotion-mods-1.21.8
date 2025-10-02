package fr.emotion.emomodore.advancements;

import fr.emotion.emomodore.init.EmoBlocks;
import fr.emotion.emomodore.init.EmoItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
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
                        EmoItems.PURPURA_SHARD.get(),
                        Component.translatable("advancements.emo.mine_purpura.title"),
                        Component.translatable("advancements.emo.mine_purpura.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("purpura", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(itemRegistry, EmoItems.PURPURA_SHARD.get())))
                .save(writer, "emo/mine_purpura");
        AdvancementHolder advancementHolder1 = Advancement.Builder.advancement()
                .parent(advancementHolder)
                .display(
                        EmoBlocks.VIRIDIS_CRYSTAL.get(),
                        Component.translatable("advancements.emo.mine_viridis.title"),
                        Component.translatable("advancements.emo.mine_viridis.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("viridis", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(itemRegistry, EmoBlocks.VIRIDIS_CRYSTAL.get())))
                .save(writer, "emo/mine_viridis");
    }
}
