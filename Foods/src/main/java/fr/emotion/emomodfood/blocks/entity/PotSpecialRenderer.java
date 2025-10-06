package fr.emotion.emomodfood.blocks.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.MapCodec;
import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.components.PotRecord;
import fr.emotion.emomodfood.init.EmoComponents;
import fr.emotion.emomodfood.models.EmoModelLayers;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Set;

public record PotSpecialRenderer(PotModel model,
                                 ResourceLocation texture) implements SpecialModelRenderer<DataComponentMap> {
    @Override
    public void render(@Nullable DataComponentMap patterns, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, boolean hasFoilType) {
        assert patterns!=null;
        PotRecord potRecord = patterns.getOrDefault(EmoComponents.POT.get(), new PotRecord("empty", 0));

        poseStack.pushPose();

        if (displayContext.equals(ItemDisplayContext.GROUND)) poseStack.translate(0.5F, 2.5F, 0.5F);
        else poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.scale(1.0F, -1.0F, -1.0F);

        VertexConsumer potConsumer = bufferSource.getBuffer(RenderType.entityCutout(texture));
        this.model.pot.render(poseStack, potConsumer, packedLight, packedOverlay);

        int fillLevel = potRecord.fillLevel();

        if (fillLevel > 0) {
            ResourceLocation contentTexture = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/pot/pot_" + potRecord.contentType() + ".png");
            VertexConsumer contentConsumer = bufferSource.getBuffer(RenderType.entityCutout(contentTexture));

            poseStack.pushPose();
            this.model.layer_1.render(poseStack, contentConsumer, packedLight, packedOverlay);

            if (fillLevel > 1) model.layer_2.render(poseStack, contentConsumer, packedLight, packedOverlay);
            if (fillLevel > 2) model.layer_3.render(poseStack, contentConsumer, packedLight, packedOverlay);
            if (fillLevel > 3) model.layer_4.render(poseStack, contentConsumer, packedLight, packedOverlay);

            poseStack.popPose();
        }

        poseStack.popPose();
    }

    @Override
    public void getExtents(Set<Vector3f> output) {
        PoseStack poseStack = new PoseStack();
        this.model.root().getExtentsForGui(poseStack, output);
    }

    @Override
    public DataComponentMap extractArgument(ItemStack stack) {
        return stack.immutableComponents();
    }

    public record Unbaked(ResourceLocation texture) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<PotSpecialRenderer.Unbaked> MAP_CODEC = ResourceLocation.CODEC.fieldOf("texture")
                .xmap(PotSpecialRenderer.Unbaked::new, PotSpecialRenderer.Unbaked::texture);

        @Override
        public SpecialModelRenderer<?> bake(EntityModelSet modelSet) {
            PotModel model = new PotModel(modelSet.bakeLayer(EmoModelLayers.POT));
            ResourceLocation texture = this.texture.withPath(path -> "textures/entity/" + path + ".png");
            return new PotSpecialRenderer(model, texture);
        }

        @Override
        public MapCodec<? extends SpecialModelRenderer.Unbaked> type() {
            return MAP_CODEC;
        }
    }
}
