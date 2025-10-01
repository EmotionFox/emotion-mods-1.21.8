package fr.emotion.emomodfood.models;

import fr.emotion.emomodfood.EmoMain;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

public class EmoModelTemplate {
    public static final ModelTemplate CANDLE_CAKE = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/cake_candle_model"))
            .requiredTextureSlot(TextureSlot.CANDLE)
            .requiredTextureSlot(TextureSlot.BOTTOM)
            .requiredTextureSlot(TextureSlot.TOP)
            .requiredTextureSlot(TextureSlot.SIDE)
            .build();

    public static final ModelTemplate CANDLE_CAKE_CHOCOLATE = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/cake_chocolate_candle_model"))
            .requiredTextureSlot(TextureSlot.CANDLE)
            .build();

    public static final ModelTemplate CANDLE_CAKE_FRUIT = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/cake_fruit_candle_model"))
            .requiredTextureSlot(TextureSlot.CANDLE)
            .build();
}
