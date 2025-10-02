package fr.emotion.emomodfood.blocks.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import fr.emotion.emomodfood.models.EmoModelLayers;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Set;

public record PotSpecialRenderer(Model model, Material material) implements NoDataSpecialModelRenderer {
    @Override
    public void render(ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, boolean hasFoilType) {
        this.model.renderToBuffer(poseStack, this.material.buffer(bufferSource, RenderType::entityCutout), packedLight, packedOverlay);
    }

    @Override
    public void getExtents(Set<Vector3f> output) {
        PoseStack poseStack = new PoseStack();
        this.model.root().getExtentsForGui(poseStack, output);
    }

    public record Unbaked(ResourceLocation texture) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<PotSpecialRenderer.Unbaked> MAP_CODEC = ResourceLocation.CODEC.fieldOf("texture")
                .xmap(PotSpecialRenderer.Unbaked::new, PotSpecialRenderer.Unbaked::texture);

        @Override
        public @Nullable SpecialModelRenderer<?> bake(EntityModelSet modelSet) {
            PotModel model = new PotModel(modelSet.bakeLayer(EmoModelLayers.POT));
            ResourceLocation texture = this.texture.withPath(path -> "textures/entity/" + path + ".png");
            return new PotSpecialRenderer(model, new Material(ResourceLocation.withDefaultNamespace("textures/atlas/entity.png"), texture));
        }

        @Override
        public MapCodec<? extends SpecialModelRenderer.Unbaked> type() {
            return MAP_CODEC;
        }
    }
}
