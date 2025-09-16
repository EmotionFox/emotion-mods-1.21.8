package fr.emotion.emomodworld.entities.butterfly;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.models.EmoModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ButterflyRenderer extends MobRenderer<Butterfly, ButterflyRenderState, ButterflyModel> {
    public ButterflyRenderer(EntityRendererProvider.Context context) {
        super(context, new ButterflyModel(context.bakeLayer(EmoModelLayers.BUTTERFLY)), 0F);
    }

    @Override
    public ResourceLocation getTextureLocation(ButterflyRenderState renderState) {
        return ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/butterfly/butterfly_" + renderState.variant.getSerializedName() + ".png");
    }

    @Override
    public ButterflyRenderState createRenderState() {
        return new ButterflyRenderState();
    }

    @Override
    public void extractRenderState(Butterfly butterfly, ButterflyRenderState renderState, float yRot) {
        super.extractRenderState(butterfly, renderState, yRot);
        renderState.variant = butterfly.getVariant();
        renderState.isResting = butterfly.isResting();
        renderState.flyAnimationState.copyFrom(butterfly.flyAnimationState);
        renderState.landAnimationState.copyFrom(butterfly.landAnimationState);
        renderState.restAnimationState.copyFrom(butterfly.restAnimationState);
    }

    @Override
    protected void scale(ButterflyRenderState renderState, PoseStack poseStack) {
        poseStack.scale(0.3F, 0.3F, 0.3F);
    }
}
