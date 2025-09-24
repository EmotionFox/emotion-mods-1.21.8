package fr.emotion.emomodworld.advancements;

import fr.emotion.emomodworld.datagen.EmoItemTagsProvider;
import fr.emotion.emomodworld.init.EmoItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class EmoAdvancements implements AdvancementSubProvider {
    private static final List<Item> BUTTERFLIES_TO_GET = Arrays.asList(
            EmoItems.BUTTERFLY_BLUE.get(),
            EmoItems.BUTTERFLY_BROWN.get(),
            EmoItems.BUTTERFLY_GREEN.get(),
            EmoItems.BUTTERFLY_PINK.get(),
            EmoItems.BUTTERFLY_RED.get(),
            EmoItems.BUTTERFLY_YELLOW.get()
    );

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> writer) {
        HolderLookup<Item> itemRegistry = registries.lookupOrThrow(Registries.ITEM);
        HolderLookup<Block> blockRegistry = registries.lookupOrThrow(Registries.BLOCK);

        AdvancementHolder advancementHolder1 = Advancement.Builder.advancement()
                .parent(fr.emotion.emomodcore.advancements.EmoAdvancements.mainAdvancementHolder)
                .display(
                        EmoItems.BUTTERFLY_NET_WHITE,
                        Component.translatable("advancements.emo.get_butterfly_net.title"),
                        Component.translatable("advancements.emo.get_butterfly_net.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "get_butterfly_net", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(itemRegistry, EmoItemTagsProvider.BUTTERFLY_NET))
                )
                .save(writer, "emo/get_butterfly_net");
        AdvancementHolder advancementHolder2 = addButterfliesToGet(Advancement.Builder.advancement(), itemRegistry, BUTTERFLIES_TO_GET)
                .parent(advancementHolder1)
                .display(
                        EmoItems.BUTTERFLY_BLUE,
                        Component.translatable("advancements.emo.get_all_butterfly.title"),
                        Component.translatable("advancements.emo.get_all_butterfly.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .save(writer, "emo/get_all_butterfly");
    }

    private static Advancement.Builder addButterfliesToGet(Advancement.Builder builder, HolderGetter<Item> itemRegistry, List<Item> butterfliesToGet) {
        butterfliesToGet.forEach(
                input -> builder.addCriterion(
                        BuiltInRegistries.ITEM.getKey(input).toString(),
                        InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(itemRegistry, input))
                )
        );
        return builder;
    }
}
