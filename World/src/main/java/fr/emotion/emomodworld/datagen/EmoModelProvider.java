package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Holder;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class EmoModelProvider extends ModelProvider {
    public EmoModelProvider(PackOutput output) {
        super(output, EmoMain.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_1.get(), EmoBlocks.POTTED_FLOWER_1.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_2.get(), EmoBlocks.POTTED_FLOWER_2.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_3.get(), EmoBlocks.POTTED_FLOWER_3.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_4.get(), EmoBlocks.POTTED_FLOWER_4.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_5.get(), EmoBlocks.POTTED_FLOWER_5.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_6.get(), EmoBlocks.POTTED_FLOWER_6.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_7.get(), EmoBlocks.POTTED_FLOWER_7.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_8.get(), EmoBlocks.POTTED_FLOWER_8.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(EmoBlocks.FLOWER_9.get(), EmoBlocks.POTTED_FLOWER_9.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        blockModels.createPlantWithDefaultItem(EmoBlocks.PEAR_SAPLING.get(), EmoBlocks.POTTED_PEAR_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.woodProvider(EmoBlocks.PEAR_LOG.get()).logWithHorizontal(EmoBlocks.PEAR_LOG.get()).wood(EmoBlocks.PEAR_WOOD.get());
        blockModels.woodProvider(EmoBlocks.STRIPPED_PEAR_LOG.get()).logWithHorizontal(EmoBlocks.STRIPPED_PEAR_LOG.get()).wood(EmoBlocks.STRIPPED_PEAR_WOOD.get());
        blockModels.createTintedLeaves(EmoBlocks.PEAR_LEAVES.get(), TexturedModel.LEAVES, 0x6A9E3F);
        blockModels.createHangingSign(EmoBlocks.STRIPPED_PEAR_LOG.get(), EmoBlocks.PEAR_HANGING_SIGN.get(), EmoBlocks.PEAR_WALL_HANGING_SIGN.get());

        EmoBlockFamilies.getAllFamilies()
                .filter(BlockFamily::shouldGenerateModel)
                .forEach(blockFamily -> blockModels.family(blockFamily.getBaseBlock()).generateFor(blockFamily));

        itemModels.generateFlatItem(EmoItems.PEAR_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PEAR_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
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
