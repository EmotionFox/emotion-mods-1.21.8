package fr.emotion.emomodworld.models;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.AbstractBoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.BoatRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class EmoBoatRenderer extends AbstractBoatRenderer {
    private final Model waterPatchModel;
    private final ResourceLocation texture;
    private final EntityModel<BoatRenderState> model;

    public EmoBoatRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayer) {
        super(context);
        this.texture = modelLayer.model().withPath(path -> "textures/entity/" + path + ".png");
        this.waterPatchModel = new Model.Simple(context.bakeLayer(ModelLayers.BOAT_WATER_PATCH), resourceLocation -> RenderType.waterMask());
        this.model = new BoatModel(context.bakeLayer(modelLayer));
    }

    @Override
    protected EntityModel<BoatRenderState> model() {
        return this.model;
    }

    @Override
    protected RenderType renderType() {
        return RenderType.entityTranslucent(this.texture);
    }

    @Override
    protected void renderTypeAdditions(BoatRenderState renderState, PoseStack posStack, MultiBufferSource multiBufferSource, int packedLight) {
        if (!renderState.isUnderWater) {
            this.waterPatchModel
                    .renderToBuffer(posStack, multiBufferSource.getBuffer(this.waterPatchModel.renderType(this.texture)), packedLight, OverlayTexture.NO_OVERLAY);
        }
    }
}
