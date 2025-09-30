package fr.emotion.emomoddimension.models;

import fr.emotion.emomoddimension.EmoMain;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

public class EmoModelTemplate {
    public static final ModelTemplate DREAM_CATCHER = ExtendedModelTemplateBuilder.builder()
            .parent(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/dream_catcher_model"))
            .renderType("cutout_mipped")
            .guiLight(UnbakedModel.GuiLight.FRONT)
            .build();
}
