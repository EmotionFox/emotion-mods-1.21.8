package fr.emotion.emomodfurniture.models;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.world.level.block.Block;

public class EmoTextureMapping {
    public static TextureMapping furniture(TextureSlot slot, Block block) {
        return new TextureMapping()
                .put(slot, TextureMapping.getBlockTexture(block));
    }
}
