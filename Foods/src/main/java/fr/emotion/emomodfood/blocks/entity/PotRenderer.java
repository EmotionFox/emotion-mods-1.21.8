package fr.emotion.emomodfood.blocks.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.models.EmoModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public class PotRenderer implements BlockEntityRenderer<PotBlockEntity> {
    private static final ResourceLocation potTexture = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/pot/pot.png");
    private final PotModel model;

    public PotRenderer(BlockEntityRendererProvider.Context context) {
        this.model = new PotModel(context.bakeLayer(EmoModelLayers.POT));
    }

    @Override
    public void render(PotBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, Vec3 cameraPos) {
        poseStack.pushPose();

        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.scale(1.0F, -1.0F, -1.0F);

        VertexConsumer potConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(potTexture));
        model.pot.render(poseStack, potConsumer, packedLight, packedOverlay);

        int fillLevel = blockEntity.getFillLevel();

        if (fillLevel > 0) {
            ResourceLocation contentTexture = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/pot/pot_" + blockEntity.getContentType().getName() + ".png");
            VertexConsumer contentConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(contentTexture));

            poseStack.pushPose();
            model.layer_1.render(poseStack, contentConsumer, packedLight, packedOverlay);

            if (fillLevel > 1) model.layer_2.render(poseStack, contentConsumer, packedLight, packedOverlay);
            if (fillLevel > 2) model.layer_3.render(poseStack, contentConsumer, packedLight, packedOverlay);
            if (fillLevel > 3) model.layer_4.render(poseStack, contentConsumer, packedLight, packedOverlay);

            poseStack.popPose();
        }

        poseStack.popPose();
    }
}
