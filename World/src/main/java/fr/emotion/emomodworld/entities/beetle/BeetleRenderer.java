package fr.emotion.emomodworld.entities.beetle;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.models.EmoModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BeetleRenderer extends MobRenderer<Beetle, BeetleRenderState, BeetleModel> {
    public BeetleRenderer(EntityRendererProvider.Context context) {
        super(context, new BeetleModel(context.bakeLayer(EmoModelLayers.BEETLE)), 0.1F);
    }

    @Override
    public ResourceLocation getTextureLocation(BeetleRenderState renderState) {
        return ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/beetle/beetle_" + renderState.variant.getSerializedName() + ".png");
    }

    @Override
    public BeetleRenderState createRenderState() {
        return new BeetleRenderState();
    }

    @Override
    public void extractRenderState(Beetle beetle, BeetleRenderState renderState, float yRot) {
        super.extractRenderState(beetle, renderState, yRot);
        renderState.variant = beetle.getVariant();
        renderState.idleAnimationState.copyFrom(beetle.idleAnimationState);
        renderState.walkAnimationState.copyFrom(beetle.walkAnimationState);
    }

    @Override
    protected void scale(BeetleRenderState renderState, PoseStack poseStack) {
        poseStack.scale(0.5F, 0.5F, 0.5F);
    }
}
