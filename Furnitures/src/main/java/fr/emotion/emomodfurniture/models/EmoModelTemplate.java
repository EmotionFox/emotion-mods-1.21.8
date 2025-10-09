package fr.emotion.emomodfurniture.models;

import fr.emotion.emomodfurniture.EmoMain;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

public class EmoModelTemplate {
    public static final ModelTemplate WOOD_TABLE = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/wood_table"))
            .requiredTextureSlot(EmoTextureSlot.WOOD)
            .renderType("cutout")
            .build();

    public static final ModelTemplate WOOD_TABLE_EW = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/wood_table_ew"))
            .requiredTextureSlot(EmoTextureSlot.WOOD)
            .renderType("cutout")
            .build();

    public static final ModelTemplate WOOD_TABLE_FULL = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/wood_table_full"))
            .requiredTextureSlot(EmoTextureSlot.WOOD)
            .renderType("cutout")
            .build();

    public static final ModelTemplate WOOD_TABLE_NS = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/wood_table_ns"))
            .requiredTextureSlot(EmoTextureSlot.WOOD)
            .renderType("cutout")
            .build();

    public static final ModelTemplate STONE_TABLE = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/stone_table"))
            .requiredTextureSlot(EmoTextureSlot.STONE)
            .renderType("cutout")
            .build();

    public static final ModelTemplate STONE_TABLE_EW = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/stone_table_ew"))
            .requiredTextureSlot(EmoTextureSlot.STONE)
            .renderType("cutout")
            .build();

    public static final ModelTemplate STONE_TABLE_FULL = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/stone_table_full"))
            .requiredTextureSlot(EmoTextureSlot.STONE)
            .renderType("cutout")
            .build();

    public static final ModelTemplate STONE_TABLE_NS = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/stone_table_ns"))
            .requiredTextureSlot(EmoTextureSlot.STONE)
            .renderType("cutout")
            .build();

    public static final ModelTemplate WOOD_STOOL = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/wood_stool"))
            .requiredTextureSlot(EmoTextureSlot.WOOD)
            .renderType("cutout")
            .build();

    public static final ModelTemplate STONE_STOOL = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/stone_stool"))
            .requiredTextureSlot(EmoTextureSlot.STONE)
            .renderType("cutout")
            .build();

    public static final ModelTemplate NIGHT_STAND = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/nightstand"))
            .requiredTextureSlot(EmoTextureSlot.WOOD)
            .build();
}
