package fr.emotion.emomodore.datagen;

import fr.emotion.emomodore.block.state.EmoBlockStateProperties;
import fr.emotion.emomodore.components.PhaseRecord;
import fr.emotion.emomodore.init.BlockRegistry;
import fr.emotion.emomodore.init.ComponentRegistry;
import fr.emotion.emomodore.init.ItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.component.predicates.DataComponentPredicates;
import net.minecraft.core.component.predicates.EnchantmentsPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetComponentsFunction;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.List;
import java.util.Set;

public class EmoBlockLootTableSubProvider extends BlockLootSubProvider {
    protected EmoBlockLootTableSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(BlockRegistry.FOSSIL_ORE.get(), block -> createOreDrop(BlockRegistry.FOSSIL_ORE.get(), ItemRegistry.FOSSIL.get()));
        dropSelf(BlockRegistry.FOSSIL_BLOCK.get());

        add(BlockRegistry.PURPURA_ORE.get(), block -> createOreDrop(BlockRegistry.PURPURA_ORE.get(), ItemRegistry.PURPURA_SHARD.get()));
        add(BlockRegistry.DEEPSLATE_PURPURA_ORE.get(), block -> createOreDrop(BlockRegistry.DEEPSLATE_PURPURA_ORE.get(), ItemRegistry.PURPURA_SHARD.get()));
        dropSelf(BlockRegistry.PURPURA_BLOCK.get());

        dropWhenSilkTouch(BlockRegistry.VIRIDIS_ORE.get());
        add(BlockRegistry.VIRIDIS_CRYSTAL.get(), block -> createPhaseDrop(BlockRegistry.VIRIDIS_CRYSTAL.get(), BlockRegistry.VIRIDIS_CRYSTAL.get().asItem()));
        dropSelf(BlockRegistry.VIRIDIS_BLOCK.get());

        add(BlockRegistry.NETHER_LUME_ORE.get(), block -> createPhaseOreDrop(BlockRegistry.NETHER_LUME_ORE.get(), ItemRegistry.LUME_STONE.get()));
        dropSelf(BlockRegistry.LUME_BLOCK.get());
    }

    protected LootTable.Builder createPhaseDrop(Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        LootPool.Builder normalPool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F));

        for (int phase = 0; phase <= 4; phase++) {
            normalPool.add(
                    this.applyExplosionDecay(
                            block,
                            LootItem.lootTableItem(item)
                                    .apply(SetComponentsFunction.setComponent(
                                            ComponentRegistry.PHASE.get(), new PhaseRecord(phase)
                                    ))
                                    .apply(SetComponentsFunction.setComponent(
                                            DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.emomodore.phase.tooltip").append(": " + phase).withStyle(ChatFormatting.DARK_AQUA)))
                                    ))
                                    .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                                    .hasProperty(EmoBlockStateProperties.PHASE, phase)
                                            )
                                    )
                    )
            );
        }

        return LootTable.lootTable()
                .withPool(normalPool);
    }

    protected LootTable.Builder createPhaseOreDrop(Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        LootItemCondition.Builder silkTouchCondition = MatchTool.toolMatches(ItemPredicate.Builder.item()
                .withComponents(DataComponentMatchers.Builder.components()
                        .partial(
                                DataComponentPredicates.ENCHANTMENTS,
                                EnchantmentsPredicate.enchantments(List.of(
                                        new EnchantmentPredicate(
                                                enchantments.getOrThrow(Enchantments.SILK_TOUCH),
                                                MinMaxBounds.Ints.atLeast(1)
                                        )
                                ))
                        ).build()
                )
        );

        LootPool.Builder silkTouchPool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .when(silkTouchCondition);

        for (int phase = 0; phase <= 4; phase++) {
            silkTouchPool.add(
                    LootItem.lootTableItem(block)
                            .apply(SetComponentsFunction.setComponent(
                                    ComponentRegistry.PHASE.get(), new PhaseRecord(phase)
                            ))
                            .apply(SetComponentsFunction.setComponent(
                                    DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.emomodore.phase.tooltip").append(": " + phase).withStyle(ChatFormatting.DARK_AQUA)))
                            ))
                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                    .setProperties(StatePropertiesPredicate.Builder.properties()
                                            .hasProperty(EmoBlockStateProperties.PHASE, phase)
                                    )
                            )
            );
        }

        LootPool.Builder normalPool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .when(InvertedLootItemCondition.invert(silkTouchCondition));

        for (int phase = 0; phase <= 4; phase++) {
            normalPool.add(
                    this.applyExplosionDecay(
                            block,
                            LootItem.lootTableItem(item)
                                    .apply(SetComponentsFunction.setComponent(
                                            ComponentRegistry.PHASE.get(), new PhaseRecord(phase)
                                    ))
                                    .apply(SetComponentsFunction.setComponent(
                                            DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.emomodore.phase.tooltip").append(": " + phase).withStyle(ChatFormatting.DARK_AQUA)))
                                    ))
                                    .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                                    .hasProperty(EmoBlockStateProperties.PHASE, phase)
                                            )
                                    )
                    )
            );
        }

        return LootTable.lootTable()
                .withPool(silkTouchPool)
                .withPool(normalPool);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
