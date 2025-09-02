package fr.emotion.emomodore.advancements;

import fr.emotion.emomodore.EmoMain;
import fr.emotion.emomodore.init.EmoItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Consumer;

public class MinePurpura {
    public static void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver) {
        Advancement.Builder builder = Advancement.Builder.advancement();
        builder.parent(AdvancementSubProvider.createPlaceholder("minecraft:story/mine_diamond"));

        builder.display(
                new ItemStack(EmoItems.PURPURA_SHARD.get()),
                Component.translatable("advancements.emomodore.mine_purpura.title"),
                Component.translatable("advancements.emomodore.mine_purpura.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
        );

        builder.addCriterion("purpura", InventoryChangeTrigger.TriggerInstance.hasItems(EmoItems.PURPURA_SHARD.get()));
        builder.requirements(AdvancementRequirements.allOf(List.of("purpura")));
        builder.save(saver, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "mine_purpura"));
    }
}
