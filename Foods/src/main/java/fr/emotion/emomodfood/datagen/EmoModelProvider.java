package fr.emotion.emomodfood.datagen;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.blocks.entity.PotSpecialRenderer;
import fr.emotion.emomodfood.init.EmoBlocks;
import fr.emotion.emomodfood.init.EmoItems;
import fr.emotion.emomodfood.models.EmoModelTemplate;
import fr.emotion.emomodfood.models.EmoTextureMapping;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.SpecialModelWrapper;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.createBooleanModelDispatch;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class EmoModelProvider extends ModelProvider {
    public EmoModelProvider(PackOutput output) {
        super(output, EmoMain.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(EmoItems.SLICE_BREAD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.SLICE_PEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.SLICE_CHERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.SLICE_ORANGE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.SLICE_APPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.SLICE_BLACKCURRANT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.SLICE_BLUEBERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.SLICE_DREAMCURRANT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.SLICE_STRAWBERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.SLICE_SWEETBERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.SLICE_CHOCOLATE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.GLASS_BOWL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.JUICE_PEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.JUICE_CHERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.JUICE_ORANGE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.JUICE_TOMATO.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.JUICE_APPLE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.PIE_PEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PIE_CHERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PIE_ORANGE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PIE_APPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PIE_MELON.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.MUFFIN_PEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.MUFFIN_CHERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.MUFFIN_ORANGE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.MUFFIN_APPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.MUFFIN_BLACKCURRANT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.MUFFIN_BLUEBERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.MUFFIN_DREAMCURRANT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.MUFFIN_STRAWBERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.MUFFIN_SWEETBERRY.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.TOFFEE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.TOFFEE_APPLE.get(), ModelTemplates.FLAT_ITEM);

        createCakeBlock(blockModels, EmoItems.CAKE_CHOCOLATE.get(), EmoBlocks.CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.CANDLE, EmoBlocks.CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.WHITE_CANDLE, EmoBlocks.WHITE_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.ORANGE_CANDLE, EmoBlocks.ORANGE_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.MAGENTA_CANDLE, EmoBlocks.MAGENTA_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.LIGHT_BLUE_CANDLE, EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.YELLOW_CANDLE, EmoBlocks.YELLOW_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.LIME_CANDLE, EmoBlocks.LIME_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.PINK_CANDLE, EmoBlocks.PINK_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.GRAY_CANDLE, EmoBlocks.GRAY_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.LIGHT_GRAY_CANDLE, EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.CYAN_CANDLE, EmoBlocks.CYAN_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.PURPLE_CANDLE, EmoBlocks.PURPLE_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.BLUE_CANDLE, EmoBlocks.BLUE_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.BROWN_CANDLE, EmoBlocks.BROWN_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.GREEN_CANDLE, EmoBlocks.GREEN_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.RED_CANDLE, EmoBlocks.RED_CANDLE_CAKE_CHOCOLATE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_CHOCOLATE, new TextureMapping(), Blocks.BLACK_CANDLE, EmoBlocks.BLACK_CANDLE_CAKE_CHOCOLATE.get());

        createCakeBlock(blockModels, EmoItems.CAKE_FRUIT.get(), EmoBlocks.CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.CANDLE, EmoBlocks.CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.WHITE_CANDLE, EmoBlocks.WHITE_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.ORANGE_CANDLE, EmoBlocks.ORANGE_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.MAGENTA_CANDLE, EmoBlocks.MAGENTA_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.LIGHT_BLUE_CANDLE, EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.YELLOW_CANDLE, EmoBlocks.YELLOW_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.LIME_CANDLE, EmoBlocks.LIME_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.PINK_CANDLE, EmoBlocks.PINK_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.GRAY_CANDLE, EmoBlocks.GRAY_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.LIGHT_GRAY_CANDLE, EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.CYAN_CANDLE, EmoBlocks.CYAN_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.PURPLE_CANDLE, EmoBlocks.PURPLE_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.BLUE_CANDLE, EmoBlocks.BLUE_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.BROWN_CANDLE, EmoBlocks.BROWN_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.GREEN_CANDLE, EmoBlocks.GREEN_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.RED_CANDLE, EmoBlocks.RED_CANDLE_CAKE_FRUIT.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE_FRUIT, new TextureMapping(), Blocks.BLACK_CANDLE, EmoBlocks.BLACK_CANDLE_CAKE_FRUIT.get());

        createCakeBlock(blockModels, EmoItems.CAKE_TOFFEE.get(), EmoBlocks.CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.CANDLE, EmoBlocks.CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.WHITE_CANDLE, EmoBlocks.WHITE_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.ORANGE_CANDLE, EmoBlocks.ORANGE_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.MAGENTA_CANDLE, EmoBlocks.MAGENTA_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.LIGHT_BLUE_CANDLE, EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.YELLOW_CANDLE, EmoBlocks.YELLOW_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.LIME_CANDLE, EmoBlocks.LIME_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.PINK_CANDLE, EmoBlocks.PINK_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.GRAY_CANDLE, EmoBlocks.GRAY_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.LIGHT_GRAY_CANDLE, EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.CYAN_CANDLE, EmoBlocks.CYAN_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.PURPLE_CANDLE, EmoBlocks.PURPLE_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.BLUE_CANDLE, EmoBlocks.BLUE_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.BROWN_CANDLE, EmoBlocks.BROWN_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.GREEN_CANDLE, EmoBlocks.GREEN_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.RED_CANDLE, EmoBlocks.RED_CANDLE_CAKE_TOFFEE.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_TOFFEE.get()), Blocks.BLACK_CANDLE, EmoBlocks.BLACK_CANDLE_CAKE_TOFFEE.get());

        createCakeBlock(blockModels, EmoItems.CAKE_STRAWBERRY.get(), EmoBlocks.CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.CANDLE, EmoBlocks.CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.WHITE_CANDLE, EmoBlocks.WHITE_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.ORANGE_CANDLE, EmoBlocks.ORANGE_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.MAGENTA_CANDLE, EmoBlocks.MAGENTA_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.LIGHT_BLUE_CANDLE, EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.YELLOW_CANDLE, EmoBlocks.YELLOW_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.LIME_CANDLE, EmoBlocks.LIME_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.PINK_CANDLE, EmoBlocks.PINK_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.GRAY_CANDLE, EmoBlocks.GRAY_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.LIGHT_GRAY_CANDLE, EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.CYAN_CANDLE, EmoBlocks.CYAN_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.PURPLE_CANDLE, EmoBlocks.PURPLE_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.BLUE_CANDLE, EmoBlocks.BLUE_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.BROWN_CANDLE, EmoBlocks.BROWN_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.GREEN_CANDLE, EmoBlocks.GREEN_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.RED_CANDLE, EmoBlocks.RED_CANDLE_CAKE_STRAWBERRY.get());
        createCandleCake(blockModels, EmoModelTemplate.CANDLE_CAKE, EmoTextureMapping.cake(EmoBlocks.CAKE_STRAWBERRY.get()), Blocks.BLACK_CANDLE, EmoBlocks.BLACK_CANDLE_CAKE_STRAWBERRY.get());

        blockModels.createCropBlock(EmoBlocks.TOMATOES.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);

        blockModels.createParticleOnlyBlock(EmoBlocks.POT.get(), Blocks.GLASS);
        
        itemModels.itemModelOutput.accept(
                EmoItems.POT.get(),
                new SpecialModelWrapper.Unbaked(
                        ResourceLocation.fromNamespaceAndPath("minecraft", "item/template_chest"),
                        new PotSpecialRenderer.Unbaked(
                                ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pot/pot")
                        )
                )
        );
    }

    protected void createCakeBlock(BlockModelGenerators blockModels, Item cakeItem, Block cake) {
        blockModels.registerSimpleFlatItemModel(cakeItem);
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(cake)
                        .with(
                                PropertyDispatch.initial(BlockStateProperties.BITES)
                                        .select(0, plainVariant(ModelLocationUtils.getModelLocation(cake)))
                                        .select(1, plainVariant(ModelLocationUtils.getModelLocation(cake, "_slice1")))
                                        .select(2, plainVariant(ModelLocationUtils.getModelLocation(cake, "_slice2")))
                                        .select(3, plainVariant(ModelLocationUtils.getModelLocation(cake, "_slice3")))
                                        .select(4, plainVariant(ModelLocationUtils.getModelLocation(cake, "_slice4")))
                                        .select(5, plainVariant(ModelLocationUtils.getModelLocation(cake, "_slice5")))
                                        .select(6, plainVariant(ModelLocationUtils.getModelLocation(cake, "_slice6")))
                        )
        );
    }

    protected void createCandleCake(BlockModelGenerators blockModels, ModelTemplate template, TextureMapping mapping, Block candleBlock, Block candleCakeBlock) {
        MultiVariant multivariant8 = plainVariant(template.create(candleCakeBlock, mapping.put(TextureSlot.CANDLE, TextureMapping.getBlockTexture(candleBlock)), blockModels.modelOutput));
        MultiVariant multivariant9 = plainVariant(
                template.createWithSuffix(candleCakeBlock, "_lit", mapping.put(TextureSlot.CANDLE, TextureMapping.getBlockTexture(candleBlock, "_lit")), blockModels.modelOutput)
        );
        blockModels.blockStateOutput
                .accept(MultiVariantGenerator.dispatch(candleCakeBlock).with(createBooleanModelDispatch(BlockStateProperties.LIT, multivariant9, multivariant8)));
    }
}
