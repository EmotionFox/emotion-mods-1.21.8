package fr.emotion.emomodfood.blocks.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.blocks.PotBlock;
import fr.emotion.emomodfood.init.EmoBlocks;
import fr.emotion.emomodfood.models.EmoModelLayers;
import fr.emotion.emomodfood.utils.EmoUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

import java.util.List;

public class PotRenderer implements BlockEntityRenderer<PotBlockEntity, PotRenderState> {
    private final List<PotModel> models;

    public PotRenderer(BlockEntityRendererProvider.Context context) {
        this.models = EmoUtils.getPots(context);
    }

    @Override
    public PotRenderState createRenderState() {
        return new PotRenderState();
    }

    @Override
    public void extractRenderState(PotBlockEntity blockEntity, PotRenderState renderState, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, renderState, partialTick, cameraPosition, breakProgress);
        boolean flag = blockEntity.getLevel()!=null;
        BlockState state = flag ? blockEntity.getBlockState():EmoBlocks.POT.get().defaultBlockState().setValue(PotBlock.FACING, Direction.NORTH);
        renderState.angle = state.getValue(PotBlock.FACING).toYRot();
        renderState.contentType = blockEntity.getContentType().getName();
        renderState.layers = blockEntity.getFillLevel();
    }

    @Override
    public void submit(PotRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();

        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(-renderState.angle));
        poseStack.scale(1.0F, -1.0F, -1.0F);

        PotModel model = models.get(renderState.layers);
        PotModel.State state = new PotModel.State();

        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/pot/pot" + (renderState.layers > 0 ? "_" + renderState.contentType : "") + ".png");
        RenderType renderType = RenderType.itemEntityTranslucentCull(location);

        nodeCollector.submitModel(
                model,
                state,
                poseStack,
                renderType,
                renderState.lightCoords,
                OverlayTexture.NO_OVERLAY,
                0,
                renderState.breakProgress
        );

        Font font = Minecraft.getInstance().font;
        Component firstRow = Component.translatable("item." + EmoMain.MODID + ".pot_" + renderState.contentType);
        String secondRow = renderState.layers + "/" + PotBlockEntity.maxLevel;
        float scale = 0.010416667F / 2;

        poseStack.translate(0.0F, 1.14F, -0.3125F);
        poseStack.scale(scale, scale, scale);

        float x = -font.width(firstRow) / 2.0F;
        float xB = -font.width(secondRow) / 2.0F;
        int color = 0xFF403c34;

        nodeCollector.submitText(
                poseStack,
                x,
                0,
                FormattedCharSequence.forward(firstRow.getString(), Style.EMPTY),
                false,
                Font.DisplayMode.POLYGON_OFFSET,
                renderState.lightCoords,
                color,
                0,
                0
        );

        nodeCollector.submitText(
                poseStack,
                xB,
                font.lineHeight + 1.0F,
                FormattedCharSequence.forward(secondRow, Style.EMPTY),
                false,
                Font.DisplayMode.POLYGON_OFFSET,
                renderState.lightCoords,
                color,
                0,
                0
        );

        poseStack.popPose();
    }
}
