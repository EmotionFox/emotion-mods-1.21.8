package fr.emotion.emomodworld.entities.beetle;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.models.EmoModelLayers;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class BeetleRenderer extends MobRenderer<Beetle, BeetleRenderState, BeetleModel> {
    private final Map<Beetle.BeetleVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(Beetle.BeetleVariant.class), map -> {
                map.put(Beetle.BeetleVariant.BLUE, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/beetle/beetle_blue.png"));
                map.put(Beetle.BeetleVariant.BROWN, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/beetle/beetle_brown.png"));
                map.put(Beetle.BeetleVariant.GREEN, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/beetle/beetle_green.png"));
            });

    public BeetleRenderer(EntityRendererProvider.Context context) {
        super(context, new BeetleModel(context.bakeLayer(EmoModelLayers.BEETLE)), 0.1F);
    }

    @Override
    public ResourceLocation getTextureLocation(BeetleRenderState renderState) {
        return LOCATION_BY_VARIANT.get(renderState.variant);
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
    public void render(BeetleRenderState renderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        super.render(renderState, poseStack, multiBufferSource, packedLight);
    }
}
