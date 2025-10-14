package fr.emotion.emomodore.tags;

import fr.emotion.emomodore.EmoMain;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

import java.util.Optional;

public class CustomModelTemplate {
    public static final ModelTemplate CRYSTAL = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/crystal"))
            .renderType("cutout")
            .guiLight(UnbakedModel.GuiLight.FRONT)
            .requiredTextureSlot(CustomTextureSlot.CRYSTAL)
            .build();
}
