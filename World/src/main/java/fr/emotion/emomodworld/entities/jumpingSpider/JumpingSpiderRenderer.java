package fr.emotion.emomodworld.entities.jumpingSpider;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.models.EmoModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class JumpingSpiderRenderer extends SpiderRenderer<JumpingSpider> {
    private static final ResourceLocation JUMPING_SPIDER_LOCATION = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/jumping_spider.png");

    public JumpingSpiderRenderer(EntityRendererProvider.Context context) {
        super(context, EmoModelLayers.JUMPING_SPIDER);
        this.shadowRadius = 0.56F;
    }

    @Override
    public ResourceLocation getTextureLocation(LivingEntityRenderState p_361974_) {
        return JUMPING_SPIDER_LOCATION;
    }

    @Override
    protected void scale(LivingEntityRenderState renderState, PoseStack poseStack) {
        poseStack.scale(0.5F, 0.5F, 0.5F);
    }
}
