package fr.emotion.emomodore.advancements;

import fr.emotion.emomodore.EmoMain;
import fr.emotion.emomodore.init.EmoBlocks;
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

public class MineViridis {
    public static void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver) {
        Advancement.Builder builder = Advancement.Builder.advancement();
        builder.parent(AdvancementSubProvider.createPlaceholder("emomodore:mine_purpura"));

        builder.display(
                new ItemStack(EmoBlocks.VIRIDIS_CRYSTAL.get()),
                Component.translatable("advancements.emomodore.mine_viridis.title"),
                Component.translatable("advancements.emomodore.mine_viridis.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
        );

        builder.addCriterion("viridis", InventoryChangeTrigger.TriggerInstance.hasItems(EmoBlocks.VIRIDIS_CRYSTAL.get()));
        builder.requirements(AdvancementRequirements.allOf(List.of("viridis")));
        builder.save(saver, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "mine_viridis"));
    }
}
