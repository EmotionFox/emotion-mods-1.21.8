package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoItems;
import fr.emotion.emomodworld.models.EmoModelTemplate;
import fr.emotion.emomodworld.models.EmoTextureMapping;
import fr.emotion.emomodworld.models.EmoTextureSlot;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Holder;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.stream.Stream;

public class EmoModelProvider extends ModelProvider {
    public EmoModelProvider(PackOutput output) {
        super(output, EmoMain.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_KITTY.get(), EmoBlocks.POTTED_FLOWER_KITTY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_NOX.get(), EmoBlocks.POTTED_FLOWER_NOX.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_DELY.get(), EmoBlocks.POTTED_FLOWER_DELY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_GNON.get(), EmoBlocks.POTTED_FLOWER_GNON.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_THORNY.get(), EmoBlocks.POTTED_FLOWER_THORNY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_CENTUS.get(), EmoBlocks.POTTED_FLOWER_CENTUS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_NEBULA.get(), EmoBlocks.POTTED_FLOWER_NEBULA.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        this.createLowPlantWithDefaultItem(blockModels, EmoBlocks.FLOWER_NARCOTA.get(), EmoBlocks.POTTED_FLOWER_NARCOTA.get());

        blockModels.createCrossBlock(EmoBlocks.DREAM_SHORT_GRASS.get(), BlockModelGenerators.PlantType.TINTED);
        blockModels.createItemWithGrassTint(EmoBlocks.DREAM_SHORT_GRASS.get());

        blockModels.createTintedDoublePlant(EmoBlocks.DREAM_TALL_GRASS.get());

        EmoBlockFamilies.getAllFamilies()
                .filter(BlockFamily::shouldGenerateModel)
                .forEach(blockFamily -> blockModels.family(blockFamily.getBaseBlock()).generateFor(blockFamily));

        createBush(EmoBlocks.BUSH_BLACKCURRANT.get(), blockModels);
        createBush(EmoBlocks.BUSH_BLUEBERRY.get(), blockModels);
        createBush(EmoBlocks.BUSH_DREAMCURRANT.get(), blockModels);
        createBush(EmoBlocks.BUSH_STRAWBERRY.get(), blockModels);
        createBush(EmoBlocks.BUSH_SWEET.get(), blockModels);

        blockModels.createMushroomBlock(EmoBlocks.BLUE_MUSHROOM_BLOCK.get());
        blockModels.createMushroomBlock(EmoBlocks.GREEN_MUSHROOM_BLOCK.get());

        blockModels.createPlantWithDefaultItem(EmoBlocks.BLUE_MUSHROOM.get(), EmoBlocks.POTTED_BLUE_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.GREEN_MUSHROOM.get(), EmoBlocks.POTTED_GREEN_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        itemModels.generateFlatItem(EmoItems.BLACKCURRANT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.BLUEBERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.DREAMCURRANT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.STRAWBERRY.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.PEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.CHERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.ORANGE.get(), ModelTemplates.FLAT_ITEM);

        woodModel(blockModels, itemModels);
    }

    protected void woodModel(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // PEAR
        blockModels.woodProvider(EmoBlocks.PEAR_LOG.get()).logWithHorizontal(EmoBlocks.PEAR_LOG.get()).wood(EmoBlocks.PEAR_WOOD.get());
        blockModels.woodProvider(EmoBlocks.STRIPPED_PEAR_LOG.get()).logWithHorizontal(EmoBlocks.STRIPPED_PEAR_LOG.get()).wood(EmoBlocks.STRIPPED_PEAR_WOOD.get());
        blockModels.createTintedLeaves(EmoBlocks.PEAR_LEAVES.get(), TexturedModel.LEAVES, 0x6A9E3F);
        blockModels.createHangingSign(EmoBlocks.STRIPPED_PEAR_LOG.get(), EmoBlocks.PEAR_HANGING_SIGN.get(), EmoBlocks.PEAR_WALL_HANGING_SIGN.get());

        blockModels.createPlantWithDefaultItem(EmoBlocks.PEAR_SAPLING.get(), EmoBlocks.POTTED_PEAR_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        itemModels.generateFlatItem(EmoItems.PEAR_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PEAR_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);

        // ORANGE
        blockModels.woodProvider(EmoBlocks.ORANGE_LOG.get()).logWithHorizontal(EmoBlocks.ORANGE_LOG.get()).wood(EmoBlocks.ORANGE_WOOD.get());
        blockModels.woodProvider(EmoBlocks.STRIPPED_ORANGE_LOG.get()).logWithHorizontal(EmoBlocks.STRIPPED_ORANGE_LOG.get()).wood(EmoBlocks.STRIPPED_ORANGE_WOOD.get());
        blockModels.createTintedLeaves(EmoBlocks.ORANGE_LEAVES.get(), TexturedModel.LEAVES, 0x45a14a);
        blockModels.createHangingSign(EmoBlocks.STRIPPED_ORANGE_LOG.get(), EmoBlocks.ORANGE_HANGING_SIGN.get(), EmoBlocks.ORANGE_WALL_HANGING_SIGN.get());

        blockModels.createPlantWithDefaultItem(EmoBlocks.ORANGE_SAPLING.get(), EmoBlocks.POTTED_ORANGE_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        itemModels.generateFlatItem(EmoItems.ORANGE_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.ORANGE_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);

        // ATLAS
        blockModels.woodProvider(EmoBlocks.ATLAS_LOG.get()).logWithHorizontal(EmoBlocks.ATLAS_LOG.get()).wood(EmoBlocks.ATLAS_WOOD.get());
        blockModels.woodProvider(EmoBlocks.STRIPPED_ATLAS_LOG.get()).logWithHorizontal(EmoBlocks.STRIPPED_ATLAS_LOG.get()).wood(EmoBlocks.STRIPPED_ATLAS_WOOD.get());
        blockModels.createTintedLeaves(EmoBlocks.ATLAS_LEAVES.get(), TexturedModel.LEAVES, 0x4496c4);
        blockModels.createHangingSign(EmoBlocks.STRIPPED_ATLAS_LOG.get(), EmoBlocks.ATLAS_HANGING_SIGN.get(), EmoBlocks.ATLAS_WALL_HANGING_SIGN.get());

        blockModels.createPlantWithDefaultItem(EmoBlocks.ATLAS_SAPLING.get(), EmoBlocks.POTTED_ATLAS_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        itemModels.generateFlatItem(EmoItems.ATLAS_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.ATLAS_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);

        // PINE
        blockModels.woodProvider(EmoBlocks.PINE_LOG.get()).logWithHorizontal(EmoBlocks.PINE_LOG.get()).wood(EmoBlocks.PINE_WOOD.get());
        blockModels.woodProvider(EmoBlocks.STRIPPED_PINE_LOG.get()).logWithHorizontal(EmoBlocks.STRIPPED_PINE_LOG.get()).wood(EmoBlocks.STRIPPED_PINE_WOOD.get());
        blockModels.createTintedLeaves(EmoBlocks.PINE_LEAVES.get(), TexturedModel.LEAVES, 0x2E5B2C);
        blockModels.createHangingSign(EmoBlocks.STRIPPED_PINE_LOG.get(), EmoBlocks.PINE_HANGING_SIGN.get(), EmoBlocks.PINE_WALL_HANGING_SIGN.get());

        blockModels.createPlantWithDefaultItem(EmoBlocks.PINE_SAPLING.get(), EmoBlocks.POTTED_PINE_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        itemModels.generateFlatItem(EmoItems.PINE_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PINE_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);

        // COCO
        blockModels.woodProvider(EmoBlocks.COCO_LOG.get()).logWithHorizontal(EmoBlocks.COCO_LOG.get()).wood(EmoBlocks.COCO_WOOD.get());
        blockModels.woodProvider(EmoBlocks.STRIPPED_COCO_LOG.get()).logWithHorizontal(EmoBlocks.STRIPPED_COCO_LOG.get()).wood(EmoBlocks.STRIPPED_COCO_WOOD.get());
        blockModels.createTintedLeaves(EmoBlocks.COCO_LEAVES.get(), TexturedModel.LEAVES, 0x6DB67E);
        blockModels.createHangingSign(EmoBlocks.STRIPPED_COCO_LOG.get(), EmoBlocks.COCO_HANGING_SIGN.get(), EmoBlocks.COCO_WALL_HANGING_SIGN.get());

        blockModels.createPlantWithDefaultItem(EmoBlocks.COCO_SAPLING.get(), EmoBlocks.POTTED_COCO_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        itemModels.generateFlatItem(EmoItems.COCO_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.COCO_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);

        // DREAM
        blockModels.woodProvider(EmoBlocks.DREAM_LOG.get()).logWithHorizontal(EmoBlocks.DREAM_LOG.get()).wood(EmoBlocks.DREAM_WOOD.get());
        blockModels.woodProvider(EmoBlocks.STRIPPED_DREAM_LOG.get()).logWithHorizontal(EmoBlocks.STRIPPED_DREAM_LOG.get()).wood(EmoBlocks.STRIPPED_DREAM_WOOD.get());
        blockModels.createTintedLeaves(EmoBlocks.DREAM_LEAVES.get(), TexturedModel.LEAVES, 0x42ab71);
        blockModels.createHangingSign(EmoBlocks.STRIPPED_DREAM_LOG.get(), EmoBlocks.DREAM_HANGING_SIGN.get(), EmoBlocks.DREAM_WALL_HANGING_SIGN.get());

        blockModels.createPlantWithDefaultItem(EmoBlocks.DREAM_SAPLING.get(), EmoBlocks.POTTED_DREAM_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        itemModels.generateFlatItem(EmoItems.DREAM_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.DREAM_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
    }

    public static void createBush(Block block, BlockModelGenerators blockModels) {
        blockModels.blockStateOutput
                .accept(
                        MultiVariantGenerator.dispatch(block)
                                .with(

                                        PropertyDispatch.initial(
                                                        BlockStateProperties.AGE_3,
                                                        BlockStateProperties.MOISTURE
                                                )
                                                .generate(
                                                        (a, m) -> BlockModelGenerators.plainVariant(
                                                                blockModels.createSuffixedVariant(block, "_age" + a + "_moisture" + m, EmoModelTemplate.BUSH, rl -> EmoTextureMapping.bush(block, a, m))
                                                        )
                                                )
                                )
                );
    }

    private static TextureMapping bush(ResourceLocation resourceLocation, int moisture) {
        ResourceLocation bush = resourceLocation;
        ResourceLocation base = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, resourceLocation.getPath().replaceAll("block/(.+?)_age\\d+_moisture\\d+", "block/base_$1"));

        if (moisture > 2) {
            bush = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, bush.getPath().replace("moisture" + moisture, "moisture2"));
        }

        return new TextureMapping().put(EmoTextureSlot.BUSH, bush).put(EmoTextureSlot.BASE, base);
    }

    // Should I skype plantType?
    public void createLowPlantWithDefaultItem(BlockModelGenerators blockModels, Block block, Block pottedBlock) {
        createLowFlowerWithDefaultItem(blockModels, block);
        createFlowerPotLow(blockModels, block, pottedBlock);
    }

    // Just in case I need more
    private void createLowFlowerWithDefaultItem(BlockModelGenerators blockModels, Block block) {
        blockModels.registerSimpleFlatItemModel(block);
        createLowFlower(blockModels, block);
    }

    private void createLowFlower(BlockModelGenerators blockModels, Block block) {
        MultiVariant multiVariant = BlockModelGenerators.plainVariant(EmoModelTemplate.LOW_FLOWER.create(block, EmoTextureMapping.lowFlower(block), blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, multiVariant));
    }

    private void createFlowerPotLow(BlockModelGenerators blockModels, Block block, Block pottedBlock) {
        MultiVariant multiVariant = BlockModelGenerators.plainVariant(EmoModelTemplate.FLOWER_POT_LOW.create(pottedBlock, EmoTextureMapping.pottedLowFlower(block), blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pottedBlock, multiVariant));
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return EmoBlocks.getBlocks().getEntries().stream();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return EmoItems.getItems().getEntries().stream();
    }
}
