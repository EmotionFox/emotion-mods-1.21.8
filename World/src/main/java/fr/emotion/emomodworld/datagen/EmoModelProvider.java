package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.core.Holder;
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
