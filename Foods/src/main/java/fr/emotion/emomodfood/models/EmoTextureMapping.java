package fr.emotion.emomodfood.models;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.world.level.block.Block;

import static net.minecraft.client.data.models.model.TextureMapping.getBlockTexture;

public class EmoTextureMapping {
    public static TextureMapping cake(Block block) {
        return new TextureMapping()
                .put(TextureSlot.BOTTOM, getBlockTexture(block, "_bottom"))
                .put(TextureSlot.TOP, getBlockTexture(block, "_top"))
                .put(TextureSlot.SIDE, getBlockTexture(block, "_side"));
    }
}
