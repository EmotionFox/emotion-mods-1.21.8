package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.blocks.EmoBushBlock;
import fr.emotion.emomodworld.init.EmoBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
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

        this.dropSelf(EmoBlocks.PEAR_PLANKS.get());

        this.dropSelf(EmoBlocks.PEAR_SAPLING.get());
        this.add(EmoBlocks.POTTED_PEAR_SAPLING.get(), this.createPotFlowerItemTable(EmoBlocks.PEAR_SAPLING.get()));

        this.dropSelf(EmoBlocks.PEAR_LOG.get());
        this.dropSelf(EmoBlocks.STRIPPED_PEAR_LOG.get());
        this.dropSelf(EmoBlocks.PEAR_WOOD.get());
        this.dropSelf(EmoBlocks.STRIPPED_PEAR_WOOD.get());
        this.add(EmoBlocks.PEAR_LEAVES.get(), block -> this.createLeavesDrops(block, EmoBlocks.PEAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(EmoBlocks.PEAR_SIGN.get());
        this.dropOther(EmoBlocks.PEAR_WALL_SIGN.get(), EmoBlocks.PEAR_SIGN.get());
        this.dropSelf(EmoBlocks.PEAR_HANGING_SIGN.get());
        this.dropOther(EmoBlocks.PEAR_WALL_HANGING_SIGN.get(), EmoBlocks.PEAR_HANGING_SIGN.get());
        this.dropSelf(EmoBlocks.PEAR_PRESSURE_PLATE.get());
        this.dropSelf(EmoBlocks.PEAR_TRAPDOOR.get());
        this.dropSelf(EmoBlocks.PEAR_STAIRS.get());
        this.dropSelf(EmoBlocks.PEAR_BUTTON.get());
        this.add(EmoBlocks.PEAR_SLAB.get(), block -> this.createSlabItemTable(block));
        this.dropSelf(EmoBlocks.PEAR_FENCE_GATE.get());
        this.dropSelf(EmoBlocks.PEAR_FENCE.get());
        this.add(EmoBlocks.PEAR_DOOR.get(), block -> this.createDoorTable(block));

        this.add(EmoBlocks.BUSH_BLACKCURRANT.get(), block -> this.createBushItemTable(block, Items.SWEET_BERRIES));
        this.add(EmoBlocks.BUSH_BLUEBERRY.get(), block -> this.createBushItemTable(block, Items.SWEET_BERRIES));
        this.add(EmoBlocks.BUSH_DREAMCURRANT.get(), block -> this.createBushItemTable(block, Items.SWEET_BERRIES));
        this.add(EmoBlocks.BUSH_STRAWBERRY.get(), block -> this.createBushItemTable(block, Items.SWEET_BERRIES));
        this.add(EmoBlocks.BUSH_SWEET.get(), block -> this.createBushItemTable(block, Items.SWEET_BERRIES));
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

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return EmoBlocks.getBlocks().getEntries().stream().map(Holder::value)::iterator;
    }
}
