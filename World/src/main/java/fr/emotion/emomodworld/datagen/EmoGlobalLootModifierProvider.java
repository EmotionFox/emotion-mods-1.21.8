package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class EmoGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public EmoGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, EmoMain.MODID);
    }

    @Override
    protected void start() {
        this.add(
                "cherry_glm",
                new AddTableLootModifier(new LootItemCondition[]{
                        LootTableIdCondition.builder(ResourceLocation.fromNamespaceAndPath("minecraft", "blocks/cherry_leaves")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "inject/cherry_glm")))
        );
    }
}
