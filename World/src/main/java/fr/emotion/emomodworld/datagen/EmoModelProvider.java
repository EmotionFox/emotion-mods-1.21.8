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

        blockModels.woodProvider(EmoBlocks.PEAR_LOG.get()).logWithHorizontal(EmoBlocks.PEAR_LOG.get()).wood(EmoBlocks.PEAR_WOOD.get());
        blockModels.woodProvider(EmoBlocks.STRIPPED_PEAR_LOG.get()).logWithHorizontal(EmoBlocks.STRIPPED_PEAR_LOG.get()).wood(EmoBlocks.STRIPPED_PEAR_WOOD.get());
        blockModels.createTintedLeaves(EmoBlocks.PEAR_LEAVES.get(), TexturedModel.LEAVES, 0x6A9E3F);
        blockModels.createHangingSign(EmoBlocks.STRIPPED_PEAR_LOG.get(), EmoBlocks.PEAR_HANGING_SIGN.get(), EmoBlocks.PEAR_WALL_HANGING_SIGN.get());

        blockModels.createPlantWithDefaultItem(EmoBlocks.PEAR_SAPLING.get(), EmoBlocks.POTTED_PEAR_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        EmoBlockFamilies.getAllFamilies()
                .filter(BlockFamily::shouldGenerateModel)
                .forEach(blockFamily -> blockModels.family(blockFamily.getBaseBlock()).generateFor(blockFamily));

        createBush(EmoBlocks.BUSH_BLACKCURRANT.get(), blockModels);
        createBush(EmoBlocks.BUSH_BLUEBERRY.get(), blockModels);
        createBush(EmoBlocks.BUSH_DREAMCURRANT.get(), blockModels);
        createBush(EmoBlocks.BUSH_STRAWBERRY.get(), blockModels);
        createBush(EmoBlocks.BUSH_SWEET.get(), blockModels);

        itemModels.generateFlatItem(EmoItems.PEAR_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PEAR_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.BLACKCURRANT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.BLUEBERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.DREAMCURRANT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.STRAWBERRY.get(), ModelTemplates.FLAT_ITEM);
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
