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
    private final PotModel model;

    public PotRenderer(BlockEntityRendererProvider.Context context) {
        this.model = new PotModel(context.bakeLayer(EmoModelLayers.POT));
    }

    @Override
    public void render(PotBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, Vec3 cameraPos) {
        poseStack.pushPose();
        poseStack.translate(0.5, 1.5, 0.5);
        poseStack.scale(1.0F, -1.0F, -1.0F);
        ResourceLocation potTexture = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/pot/pot.png");
        VertexConsumer potConsumer = bufferSource.getBuffer(RenderType.entityCutout(potTexture));
        model.pot.render(poseStack, potConsumer, packedLight, packedOverlay);

        //EmoMain.LOGGER.info("Content: " + blockEntity.getContentType().getName() + " | FillLevel: " + blockEntity.getFillLevel());

        if(blockEntity.getFillLevel() > 0 && blockEntity.getContentType() != PotBlockEntity.PotContentType.EMPTY){
            ResourceLocation contentTexture = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/pot/pot_" + blockEntity.getContentType().getName() + ".png");
            VertexConsumer contentConsumer = bufferSource.getBuffer(RenderType.entityCutout(contentTexture));

            float scaleY = ((float) blockEntity.getFillLevel() / PotBlockEntity.maxLevel);

            poseStack.pushPose();
            poseStack.translate(0.0, (1.0 - scaleY), 0.0);
            poseStack.scale(1.0F, scaleY, 1.0F);
            model.content.render(poseStack, contentConsumer, packedLight, packedOverlay);

            poseStack.popPose();
        }

        poseStack.popPose();
    }
}
