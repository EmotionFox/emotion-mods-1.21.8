package fr.emotion.emomodfurniture.models;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class EmoTextureMapping {
    public static TextureMapping table(TextureSlot slot, Block block) {
        ResourceLocation rl = TextureMapping.getBlockTexture(block);

        if (block.equals(Blocks.SMOOTH_RED_SANDSTONE))
            rl = TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE).withSuffix("_top");
        else if (block.equals(Blocks.SMOOTH_SANDSTONE))
            rl = TextureMapping.getBlockTexture(Blocks.SANDSTONE).withSuffix("_top");

        return new TextureMapping()
                .put(slot, rl);
    }
}
