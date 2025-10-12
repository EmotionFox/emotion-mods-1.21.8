package fr.emotion.emomodworld.entities.boar;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.models.EmoModelLayers;
import net.minecraft.client.model.AdultAndBabyModelPair;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.resources.ResourceLocation;

public class BoarRenderer extends MobRenderer<Boar, BoarRenderState, BoarModel> {
    private static final ResourceLocation BOAR_LOCATION = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/boar/boar.png");
    private static final ResourceLocation BOARLET_LOCATION = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/boar/boarlet.png");
    private final AdultAndBabyModelPair<BoarModel> models;

    public BoarRenderer(EntityRendererProvider.Context context) {
        super(context, new BoarModel(context.bakeLayer(EmoModelLayers.BOAR)), 0.9F);
        this.models = new AdultAndBabyModelPair<>(new BoarModel(context.bakeLayer(EmoModelLayers.BOAR)), new BoarModel(context.bakeLayer(EmoModelLayers.BOARLET)));
    }

    @Override
    public ResourceLocation getTextureLocation(BoarRenderState renderState) {
        return renderState.isBaby ? BOARLET_LOCATION:BOAR_LOCATION;
    }

    @Override
    public BoarRenderState createRenderState() {
        return new BoarRenderState();
    }

    @Override
    public void extractRenderState(Boar boar, BoarRenderState renderState, float yRot) {
        super.extractRenderState(boar, renderState, yRot);
        renderState.isBaby = boar.isBaby();
        renderState.isResting = boar.getBoarState()==Boar.BoarState.RESTING;
        renderState.chargeAnimationState.copyFrom(boar.chargeAnimationState);
        renderState.restAnimationState.copyFrom(boar.restAnimationState);
    }

    @Override
    public void submit(BoarRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        this.model = this.models.getModel(renderState.isBaby);
        super.submit(renderState, poseStack, nodeCollector, cameraRenderState);
    }
}
