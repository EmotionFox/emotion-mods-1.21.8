package fr.emotion.emomodfood.advancements;

import fr.emotion.emomodfood.components.PotRecord;
import fr.emotion.emomodfood.components.PotsPredicate;
import fr.emotion.emomodfood.init.EmoBlocks;
import fr.emotion.emomodfood.init.EmoComponents;
import fr.emotion.emomodfood.init.EmoDataComponentPredicates;
import fr.emotion.emomodfood.init.EmoItems;
import fr.emotion.emomodfood.tags.EmoItemTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class EmoAdvancements implements AdvancementSubProvider {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> writer) {
        HolderLookup<Item> itemRegistry = registries.lookupOrThrow(Registries.ITEM);
        HolderLookup<Block> blockRegistry = registries.lookupOrThrow(Registries.BLOCK);

        ItemStack potCherry = new ItemStack(EmoItems.POT.get());
        potCherry.set(EmoComponents.POT, new PotRecord("cherry", 2));

        ItemStack potLava = new ItemStack(EmoItems.POT.get());
        potLava.set(EmoComponents.POT, new PotRecord("lava", 4));

        AdvancementHolder advancementHolder = Advancement.Builder.advancement()
                .parent(fr.emotion.emomodcore.advancements.EmoAdvancements.mainAdvancementHolder)
                .display(
                        EmoItems.POT,
                        Component.translatable("advancements.emo.craft_pot.title"),
                        Component.translatable("advancements.emo.craft_pot.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .addCriterion(
                        "craft_pot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(itemRegistry, EmoItems.POT.get())
                        )
                )
                .save(writer, "emo/craft_pot");
        AdvancementHolder advancementHolder1 = Advancement.Builder.advancement()
                .parent(advancementHolder)
                .display(
                        potCherry,
                        Component.translatable("advancements.emo.craft_special_pot.title"),
                        Component.translatable("advancements.emo.craft_special_pot.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .addCriterion(
                        "craft_special_pot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(itemRegistry, EmoItems.POT.get())
                                .withComponents(DataComponentMatchers.Builder.components().partial(
                                        EmoDataComponentPredicates.POTS.get(),
                                        new PotsPredicate(4)
                                ).build())
                        )
                )
                .save(writer, "emo/craft_special_pot");
        AdvancementHolder advancementHolder1b = Advancement.Builder.advancement()
                .parent(advancementHolder)
                .display(
                        potLava,
                        Component.translatable("advancements.emo.use_pot.title"),
                        Component.translatable("advancements.emo.use_pot.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .addCriterion(
                        "use_pot",
                        ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                                LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(blockRegistry, EmoBlocks.POT.get())),
                                ItemPredicate.Builder.item().of(itemRegistry, Items.WATER_BUCKET)
                        )
                )
                .save(writer, "emo/use_pot");
        AdvancementHolder advancementHolder2 = Advancement.Builder.advancement()
                .parent(advancementHolder1)
                .display(
                        EmoItems.SLICE_CHERRY,
                        Component.translatable("advancements.emo.use_special_pot.title"),
                        Component.translatable("advancements.emo.use_special_pot.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .addCriterion(
                        "use_special_pot",
                        ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                                LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(blockRegistry, EmoBlocks.POT.get())),
                                ItemPredicate.Builder.item().of(itemRegistry, EmoItems.SLICE_BREAD)
                        )
                )
                .save(writer, "emo/use_special_pot");
        AdvancementHolder advancementHolder1c = Advancement.Builder.advancement()
                .parent(fr.emotion.emomodcore.advancements.EmoAdvancements.mainAdvancementHolder)
                .display(
                        EmoItems.MUFFIN_APPLE,
                        Component.translatable("advancements.emo.craft_muffin.title"),
                        Component.translatable("advancements.emo.craft_muffin.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .addCriterion(
                        "craft_muffin",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(itemRegistry, EmoItemTags.MUFFIN))
                )
                .save(writer, "emo/craft_muffin");
    }
}
