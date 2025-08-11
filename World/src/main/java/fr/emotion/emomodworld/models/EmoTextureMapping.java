package fr.emotion.emomodworld.models;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class EmoTextureMapping {
    public static TextureMapping bush(Block block, int age, int moisture) {
        return new TextureMapping()
                .put(EmoTextureSlot.BUSH, TextureMapping.getBlockTexture(block, "_age" + age + (moisture < 2 ? "_moisture" + moisture:"_moisture2")))
                .put(EmoTextureSlot.BASE, getBlockTexture(block, "base_"));
    }

    public static TextureMapping lowFlower(Block block) {
        return new TextureMapping()
                .put(TextureSlot.PLANT, TextureMapping.getBlockTexture(block))
                .put(EmoTextureSlot.BASE, TextureMapping.getBlockTexture(block, "_base"));
    }

    public static TextureMapping pottedLowFlower(Block block) {
        return new TextureMapping()
                .put(TextureSlot.PLANT, TextureMapping.getBlockTexture(block))
                .put(EmoTextureSlot.BASE, TextureMapping.getBlockTexture(block, "_base"));
    }

    public static ResourceLocation getBlockTexture(Block block, String prefix) {
        ResourceLocation resourcelocation = BuiltInRegistries.BLOCK.getKey(block);
        return resourcelocation.withPrefix("block/" + prefix);
    }
}
