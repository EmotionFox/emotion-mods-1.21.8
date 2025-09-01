package fr.emotion.emomoddimension.datagen;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.init.EmoBlocks;
import net.minecraft.client.color.item.GrassColorSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public class EmoModelProvider extends ModelProvider {
    public EmoModelProvider(PackOutput output) {
        super(output, EmoMain.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(EmoBlocks.DREAM_PORTAL.get());
        blockModels.createTrivialCube(EmoBlocks.DREAM_STONE.get());
        createDreamGrassBlocks(blockModels);
    }

    private void createDreamGrassBlocks(BlockModelGenerators blockModels) {
        ResourceLocation resourceLocation = TextureMapping.getBlockTexture(EmoBlocks.DREAM_STONE.get());
        TextureMapping texturemapping = new TextureMapping()
                .put(TextureSlot.BOTTOM, resourceLocation)
                .copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(EmoBlocks.DREAM_GRASS_BLOCK.get(), "_top"))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(EmoBlocks.DREAM_GRASS_BLOCK.get(), "_snow"));
        MultiVariant multivariant = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(EmoBlocks.DREAM_GRASS_BLOCK.get(), "_snow", texturemapping, blockModels.modelOutput));
        ResourceLocation resourcelocation1 = ModelLocationUtils.getModelLocation(EmoBlocks.DREAM_GRASS_BLOCK.get());
        blockModels.createGrassLikeBlock(EmoBlocks.DREAM_GRASS_BLOCK.get(), BlockModelGenerators.createRotatedVariants(BlockModelGenerators.plainModel(resourcelocation1)), multivariant);
        blockModels.registerSimpleTintedItemModel(EmoBlocks.DREAM_GRASS_BLOCK.get(), resourcelocation1, new GrassColorSource());
    }
}
