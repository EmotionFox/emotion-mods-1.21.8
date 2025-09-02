package fr.emotion.emomodore.tags;

import fr.emotion.emomodore.EmoMain;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class CustomModelTemplate {
    public static final ModelTemplate CRYSTAL = new ModelTemplate(
            Optional.of(
                    ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "block/crystal")
            ),
            Optional.empty(),
            CustomTextureSlot.CRYSTAL
    );
}
