package fr.emotion.emomodworld.models;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

import java.util.Optional;

public class EmoModelTemplate {
    public static final ModelTemplate BUSH = new ModelTemplate(
            Optional.of(
                    ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/bush")
            ),
            Optional.empty(),
            EmoTextureSlot.BUSH,
            EmoTextureSlot.BASE
    );

    public static final ModelTemplate LOW_FLOWER = new ModelTemplate(
            Optional.of(
                    ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/low_flower")
            ),
            Optional.empty(),
            TextureSlot.PLANT,
            EmoTextureSlot.BASE
    );

    public static final ModelTemplate FLOWER_POT_LOW = new ModelTemplate(
            Optional.of(
                    ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/flower_pot_low")
            ),
            Optional.empty(),
            TextureSlot.PLANT,
            EmoTextureSlot.BASE
    );

    public static final ModelTemplate BUTTERFLY_NET = new ModelTemplate(
            Optional.of(
                    ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "item/net")
            ),
            Optional.empty(),
            TextureSlot.WOOL
    );
}
