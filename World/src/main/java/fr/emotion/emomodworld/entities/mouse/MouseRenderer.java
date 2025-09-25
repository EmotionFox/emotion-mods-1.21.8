package fr.emotion.emomodworld.entities.mouse;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.models.EmoModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MouseRenderer extends MobRenderer<Mouse, MouseRenderState, MouseModel> {
    public MouseRenderer(EntityRendererProvider.Context context) {
        super(context, new MouseModel(context.bakeLayer(EmoModelLayers.MOUSE)), 0.1F);
    }

    @Override
    public ResourceLocation getTextureLocation(MouseRenderState renderState) {
        return ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/mouse/mouse_" + renderState.variant.getSerializedName() + ".png");
    }

    @Override
    public MouseRenderState createRenderState() {
        return new MouseRenderState();
    }

    @Override
    public void extractRenderState(Mouse mouse, MouseRenderState renderState, float yRot) {
        super.extractRenderState(mouse, renderState, yRot);
        renderState.variant = mouse.getVariant();
    }

    @Override
    protected void scale(MouseRenderState renderState, PoseStack poseStack) {
        poseStack.scale(0.5F, 0.5F, 0.5F);
    }
}
