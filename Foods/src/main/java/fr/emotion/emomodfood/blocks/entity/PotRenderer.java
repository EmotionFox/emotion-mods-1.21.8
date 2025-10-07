package fr.emotion.emomodfood.blocks.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.blocks.PotBlock;
import fr.emotion.emomodfood.models.EmoModelLayers;
import fr.emotion.emomodfood.utils.EmoUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

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
        poseStack.mulPose(Axis.YP.rotationDegrees(-blockEntity.getBlockState().getValueOrElse(PotBlock.FACING, Direction.NORTH).toYRot()));
        poseStack.scale(1.0F, -1.0F, -1.0F);

        VertexConsumer potConsumer = bufferSource.getBuffer(RenderType.entityCutout(potTexture));
        model.pot.render(poseStack, potConsumer, packedLight, packedOverlay);

        int fillLevel = blockEntity.getFillLevel();

        if (fillLevel > 0) {
            ResourceLocation contentTexture = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/pot/pot_" + blockEntity.getContentType().getName() + ".png");
            VertexConsumer contentConsumer = bufferSource.getBuffer(RenderType.itemEntityTranslucentCull(contentTexture));

            model.layer_1.render(poseStack, contentConsumer, packedLight, packedOverlay);

            if (fillLevel > 1) model.layer_2.render(poseStack, contentConsumer, packedLight, packedOverlay);
            if (fillLevel > 2) model.layer_3.render(poseStack, contentConsumer, packedLight, packedOverlay);
            if (fillLevel > 3) model.layer_4.render(poseStack, contentConsumer, packedLight, packedOverlay);
        }

        Font font = Minecraft.getInstance().font;
        Component firstRow = Component.translatable("item." + EmoMain.MODID + ".pot_" + blockEntity.getContentType().getName());
        String secondRow = fillLevel + "/" + PotBlockEntity.maxLevel;
        float scale = 0.010416667F / 2;

        poseStack.translate(0.0F, 1.14F, -0.3125F);
        poseStack.scale(scale, scale, scale);

        Matrix4f matrix4f = poseStack.last().pose();
        float x = -font.width(firstRow) / 2.0F;
        float xB = -font.width(secondRow) / 2.0F;
        int color = 0xFF403c34;

        font.drawInBatch(
                firstRow,
                x,
                0,
                color,
                false,
                matrix4f,
                bufferSource,
                Font.DisplayMode.POLYGON_OFFSET,
                0,
                packedLight
        );

        font.drawInBatch(
                secondRow,
                xB,
                0,
                color,
                false,
                matrix4f.translate(0.0F, font.lineHeight + 1.0F, 0.0F),
                bufferSource,
                Font.DisplayMode.POLYGON_OFFSET,
                0,
                packedLight
        );

        poseStack.popPose();
    }
}
