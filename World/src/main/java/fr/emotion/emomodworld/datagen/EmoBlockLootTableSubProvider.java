package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.blocks.EmoBushBlock;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class EmoBlockLootTableSubProvider extends BlockLootSubProvider {
    protected EmoBlockLootTableSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(EmoBlocks.FLOWER_KITTY.get());
        this.dropSelf(EmoBlocks.FLOWER_NOX.get());
        this.dropSelf(EmoBlocks.FLOWER_DELY.get());
        this.dropSelf(EmoBlocks.FLOWER_GNON.get());
        this.dropSelf(EmoBlocks.FLOWER_THORNY.get());
        this.dropSelf(EmoBlocks.FLOWER_CENTUS.get());
        this.dropSelf(EmoBlocks.FLOWER_NEBULA.get());
        this.dropSelf(EmoBlocks.FLOWER_NARCOTA.get());

        this.add(EmoBlocks.DREAM_SHORT_GRASS.get(), this::createGrassDrops);
        this.add(EmoBlocks.DREAM_TALL_GRASS.get(), block -> this.createDoublePlantWithSeedDrops(block, EmoBlocks.DREAM_SHORT_GRASS.get()));

        this.add(EmoBlocks.POTTED_FLOWER_KITTY.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_KITTY.get()));
        this.add(EmoBlocks.POTTED_FLOWER_NOX.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_NOX.get()));
        this.add(EmoBlocks.POTTED_FLOWER_DELY.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_DELY.get()));
        this.add(EmoBlocks.POTTED_FLOWER_GNON.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_GNON.get()));
        this.add(EmoBlocks.POTTED_FLOWER_THORNY.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_THORNY.get()));
        this.add(EmoBlocks.POTTED_FLOWER_CENTUS.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_CENTUS.get()));
        this.add(EmoBlocks.POTTED_FLOWER_NEBULA.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_NEBULA.get()));
        this.add(EmoBlocks.POTTED_FLOWER_NARCOTA.get(), this.createPotFlowerItemTable(EmoBlocks.FLOWER_NARCOTA.get()));

        this.add(EmoBlocks.BUSH_BLACKCURRANT.get(), block -> this.createBushItemTable(block, EmoItems.BLACKCURRANT.get()));
        this.add(EmoBlocks.BUSH_BLUEBERRY.get(), block -> this.createBushItemTable(block, EmoItems.BLUEBERRY.get()));
        this.add(EmoBlocks.BUSH_DREAMCURRANT.get(), block -> this.createBushItemTable(block, EmoItems.DREAMCURRANT.get()));
        this.add(EmoBlocks.BUSH_STRAWBERRY.get(), block -> this.createBushItemTable(block, EmoItems.STRAWBERRY.get()));
        this.add(EmoBlocks.BUSH_SWEET.get(), block -> this.createBushItemTable(block, Items.SWEET_BERRIES));

        this.dropSelf(EmoBlocks.BLUE_MUSHROOM.get());
        this.dropSelf(EmoBlocks.GREEN_MUSHROOM.get());

        this.add(EmoBlocks.BLUE_MUSHROOM_BLOCK.get(), block -> this.createMushroomBlockDrop(block, EmoBlocks.BLUE_MUSHROOM.get()));
        this.add(EmoBlocks.GREEN_MUSHROOM_BLOCK.get(), block -> this.createMushroomBlockDrop(block, EmoBlocks.GREEN_MUSHROOM.get()));

        this.add(EmoBlocks.POTTED_BLUE_MUSHROOM.get(), this.createPotFlowerItemTable(EmoBlocks.BLUE_MUSHROOM.get()));
        this.add(EmoBlocks.POTTED_GREEN_MUSHROOM.get(), this.createPotFlowerItemTable(EmoBlocks.GREEN_MUSHROOM.get()));

        woodLootTable();
    }

    protected LootTable.Builder createBushItemTable(Block block, Item item) {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .add(LootItem.lootTableItem(block))
                )
                .withPool(
                        LootPool.lootPool()
                                .add(LootItem.lootTableItem(item))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(EmoBushBlock.AGE, 3))
                                )
                );
    }

    protected void woodLootTable() {
        // PEAR
        this.dropSelf(EmoBlocks.PEAR_PLANKS.get());

        this.dropSelf(EmoBlocks.PEAR_SAPLING.get());
        this.add(EmoBlocks.POTTED_PEAR_SAPLING.get(), this.createPotFlowerItemTable(EmoBlocks.PEAR_SAPLING.get()));

        this.dropSelf(EmoBlocks.PEAR_LOG.get());
        this.dropSelf(EmoBlocks.STRIPPED_PEAR_LOG.get());
        this.dropSelf(EmoBlocks.PEAR_WOOD.get());
        this.dropSelf(EmoBlocks.STRIPPED_PEAR_WOOD.get());
        this.add(EmoBlocks.PEAR_LEAVES.get(), block -> this.createFruitLeavesDrops(block, EmoBlocks.PEAR_SAPLING.get(), EmoItems.PEAR.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(EmoBlocks.PEAR_SIGN.get());
        this.dropOther(EmoBlocks.PEAR_WALL_SIGN.get(), EmoBlocks.PEAR_SIGN.get());
        this.dropSelf(EmoBlocks.PEAR_HANGING_SIGN.get());
        this.dropOther(EmoBlocks.PEAR_WALL_HANGING_SIGN.get(), EmoBlocks.PEAR_HANGING_SIGN.get());
        this.dropSelf(EmoBlocks.PEAR_PRESSURE_PLATE.get());
        this.dropSelf(EmoBlocks.PEAR_TRAPDOOR.get());
        this.dropSelf(EmoBlocks.PEAR_STAIRS.get());
        this.dropSelf(EmoBlocks.PEAR_BUTTON.get());
        this.add(EmoBlocks.PEAR_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(EmoBlocks.PEAR_FENCE_GATE.get());
        this.dropSelf(EmoBlocks.PEAR_FENCE.get());
        this.add(EmoBlocks.PEAR_DOOR.get(), this::createDoorTable);

        // ORANGE
        this.dropSelf(EmoBlocks.ORANGE_PLANKS.get());

        this.dropSelf(EmoBlocks.ORANGE_SAPLING.get());
        this.add(EmoBlocks.POTTED_ORANGE_SAPLING.get(), this.createPotFlowerItemTable(EmoBlocks.ORANGE_SAPLING.get()));

        this.dropSelf(EmoBlocks.ORANGE_LOG.get());
        this.dropSelf(EmoBlocks.STRIPPED_ORANGE_LOG.get());
        this.dropSelf(EmoBlocks.ORANGE_WOOD.get());
        this.dropSelf(EmoBlocks.STRIPPED_ORANGE_WOOD.get());
        this.add(EmoBlocks.ORANGE_LEAVES.get(), block -> this.createFruitLeavesDrops(block, EmoBlocks.ORANGE_SAPLING.get(), EmoItems.ORANGE.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(EmoBlocks.ORANGE_SIGN.get());
        this.dropOther(EmoBlocks.ORANGE_WALL_SIGN.get(), EmoBlocks.ORANGE_SIGN.get());
        this.dropSelf(EmoBlocks.ORANGE_HANGING_SIGN.get());
        this.dropOther(EmoBlocks.ORANGE_WALL_HANGING_SIGN.get(), EmoBlocks.ORANGE_HANGING_SIGN.get());
        this.dropSelf(EmoBlocks.ORANGE_PRESSURE_PLATE.get());
        this.dropSelf(EmoBlocks.ORANGE_TRAPDOOR.get());
        this.dropSelf(EmoBlocks.ORANGE_STAIRS.get());
        this.dropSelf(EmoBlocks.ORANGE_BUTTON.get());
        this.add(EmoBlocks.ORANGE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(EmoBlocks.ORANGE_FENCE_GATE.get());
        this.dropSelf(EmoBlocks.ORANGE_FENCE.get());
        this.add(EmoBlocks.ORANGE_DOOR.get(), this::createDoorTable);

        // ATLAS
        this.dropSelf(EmoBlocks.ATLAS_PLANKS.get());

        this.dropSelf(EmoBlocks.ATLAS_SAPLING.get());
        this.add(EmoBlocks.POTTED_ATLAS_SAPLING.get(), this.createPotFlowerItemTable(EmoBlocks.ATLAS_SAPLING.get()));

        this.dropSelf(EmoBlocks.ATLAS_LOG.get());
        this.dropSelf(EmoBlocks.STRIPPED_ATLAS_LOG.get());
        this.dropSelf(EmoBlocks.ATLAS_WOOD.get());
        this.dropSelf(EmoBlocks.STRIPPED_ATLAS_WOOD.get());
        this.add(EmoBlocks.ATLAS_LEAVES.get(), block -> this.createLeavesDrops(block, EmoBlocks.ATLAS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(EmoBlocks.ATLAS_SIGN.get());
        this.dropOther(EmoBlocks.ATLAS_WALL_SIGN.get(), EmoBlocks.ATLAS_SIGN.get());
        this.dropSelf(EmoBlocks.ATLAS_HANGING_SIGN.get());
        this.dropOther(EmoBlocks.ATLAS_WALL_HANGING_SIGN.get(), EmoBlocks.ATLAS_HANGING_SIGN.get());
        this.dropSelf(EmoBlocks.ATLAS_PRESSURE_PLATE.get());
        this.dropSelf(EmoBlocks.ATLAS_TRAPDOOR.get());
        this.dropSelf(EmoBlocks.ATLAS_STAIRS.get());
        this.dropSelf(EmoBlocks.ATLAS_BUTTON.get());
        this.add(EmoBlocks.ATLAS_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(EmoBlocks.ATLAS_FENCE_GATE.get());
        this.dropSelf(EmoBlocks.ATLAS_FENCE.get());
        this.add(EmoBlocks.ATLAS_DOOR.get(), this::createDoorTable);

        // PINE
        this.dropSelf(EmoBlocks.PINE_PLANKS.get());

        this.dropSelf(EmoBlocks.PINE_SAPLING.get());
        this.add(EmoBlocks.POTTED_PINE_SAPLING.get(), this.createPotFlowerItemTable(EmoBlocks.PINE_SAPLING.get()));

        this.dropSelf(EmoBlocks.PINE_LOG.get());
        this.dropSelf(EmoBlocks.STRIPPED_PINE_LOG.get());
        this.dropSelf(EmoBlocks.PINE_WOOD.get());
        this.dropSelf(EmoBlocks.STRIPPED_PINE_WOOD.get());
        this.add(EmoBlocks.PINE_LEAVES.get(), block -> this.createLeavesDrops(block, EmoBlocks.PINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(EmoBlocks.PINE_SIGN.get());
        this.dropOther(EmoBlocks.PINE_WALL_SIGN.get(), EmoBlocks.PINE_SIGN.get());
        this.dropSelf(EmoBlocks.PINE_HANGING_SIGN.get());
        this.dropOther(EmoBlocks.PINE_WALL_HANGING_SIGN.get(), EmoBlocks.PINE_HANGING_SIGN.get());
        this.dropSelf(EmoBlocks.PINE_PRESSURE_PLATE.get());
        this.dropSelf(EmoBlocks.PINE_TRAPDOOR.get());
        this.dropSelf(EmoBlocks.PINE_STAIRS.get());
        this.dropSelf(EmoBlocks.PINE_BUTTON.get());
        this.add(EmoBlocks.PINE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(EmoBlocks.PINE_FENCE_GATE.get());
        this.dropSelf(EmoBlocks.PINE_FENCE.get());
        this.add(EmoBlocks.PINE_DOOR.get(), this::createDoorTable);

        // COCO
        this.dropSelf(EmoBlocks.COCO_PLANKS.get());

        this.dropSelf(EmoBlocks.COCO_SAPLING.get());
        this.add(EmoBlocks.POTTED_COCO_SAPLING.get(), this.createPotFlowerItemTable(EmoBlocks.COCO_SAPLING.get()));

        this.dropSelf(EmoBlocks.COCO_LOG.get());
        this.dropSelf(EmoBlocks.STRIPPED_COCO_LOG.get());
        this.dropSelf(EmoBlocks.COCO_WOOD.get());
        this.dropSelf(EmoBlocks.STRIPPED_COCO_WOOD.get());
        this.add(EmoBlocks.COCO_LEAVES.get(), block -> this.createLeavesDrops(block, EmoBlocks.COCO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(EmoBlocks.COCO_SIGN.get());
        this.dropOther(EmoBlocks.COCO_WALL_SIGN.get(), EmoBlocks.COCO_SIGN.get());
        this.dropSelf(EmoBlocks.COCO_HANGING_SIGN.get());
        this.dropOther(EmoBlocks.COCO_WALL_HANGING_SIGN.get(), EmoBlocks.COCO_HANGING_SIGN.get());
        this.dropSelf(EmoBlocks.COCO_PRESSURE_PLATE.get());
        this.dropSelf(EmoBlocks.COCO_TRAPDOOR.get());
        this.dropSelf(EmoBlocks.COCO_STAIRS.get());
        this.dropSelf(EmoBlocks.COCO_BUTTON.get());
        this.add(EmoBlocks.COCO_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(EmoBlocks.COCO_FENCE_GATE.get());
        this.dropSelf(EmoBlocks.COCO_FENCE.get());
        this.add(EmoBlocks.COCO_DOOR.get(), this::createDoorTable);

        // DREAM
        this.dropSelf(EmoBlocks.DREAM_PLANKS.get());

        this.dropSelf(EmoBlocks.DREAM_SAPLING.get());
        this.add(EmoBlocks.POTTED_DREAM_SAPLING.get(), this.createPotFlowerItemTable(EmoBlocks.DREAM_SAPLING.get()));

        this.dropSelf(EmoBlocks.DREAM_LOG.get());
        this.dropSelf(EmoBlocks.STRIPPED_DREAM_LOG.get());
        this.dropSelf(EmoBlocks.DREAM_WOOD.get());
        this.dropSelf(EmoBlocks.STRIPPED_DREAM_WOOD.get());
        this.add(EmoBlocks.DREAM_LEAVES.get(), block -> this.createLeavesDrops(block, EmoBlocks.DREAM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(EmoBlocks.DREAM_SIGN.get());
        this.dropOther(EmoBlocks.DREAM_WALL_SIGN.get(), EmoBlocks.DREAM_SIGN.get());
        this.dropSelf(EmoBlocks.DREAM_HANGING_SIGN.get());
        this.dropOther(EmoBlocks.DREAM_WALL_HANGING_SIGN.get(), EmoBlocks.DREAM_HANGING_SIGN.get());
        this.dropSelf(EmoBlocks.DREAM_PRESSURE_PLATE.get());
        this.dropSelf(EmoBlocks.DREAM_TRAPDOOR.get());
        this.dropSelf(EmoBlocks.DREAM_STAIRS.get());
        this.dropSelf(EmoBlocks.DREAM_BUTTON.get());
        this.add(EmoBlocks.DREAM_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(EmoBlocks.DREAM_FENCE_GATE.get());
        this.dropSelf(EmoBlocks.DREAM_FENCE.get());
        this.add(EmoBlocks.DREAM_DOOR.get(), this::createDoorTable);
    }

    protected LootTable.Builder createFruitLeavesDrops(Block leavesBlock, Block saplingBlock, Item fruit, float... chances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createLeavesDrops(leavesBlock, saplingBlock, chances)
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(this.hasShears().or(this.hasSilkTouch()).invert())
                                .add(
                                        ((LootPoolSingletonContainer.Builder<?>) this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(fruit)))
                                                .when(
                                                        BonusLevelTableCondition.bonusLevelFlatChance(
                                                                registrylookup.getOrThrow(Enchantments.FORTUNE), 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F
                                                        )
                                                )
                                )
                );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return EmoBlocks.getBlocks().getEntries().stream().map(Holder::value)::iterator;
    }
}
