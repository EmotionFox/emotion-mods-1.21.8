package fr.emotion.emomodfood.datagen;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.init.EmoBlocks;
import fr.emotion.emomodfood.init.EmoItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

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
        createCakeBlock(blockModels, EmoItems.CAKE_FRUIT.get(), EmoBlocks.CAKE_FRUIT.get());
        createCakeBlock(blockModels, EmoItems.CAKE_TOFFEE.get(), EmoBlocks.CAKE_TOFFEE.get());
        createCakeBlock(blockModels, EmoItems.CAKE_STRAWBERRY.get(), EmoBlocks.CAKE_STRAWBERRY.get());
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
}
