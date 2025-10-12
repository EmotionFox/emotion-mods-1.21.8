package fr.emotion.emomodfood.blocks.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.components.PotRecord;
import fr.emotion.emomodfood.init.EmoComponents;
import fr.emotion.emomodfood.models.EmoModelLayers;
import fr.emotion.emomodfood.utils.EmoUtils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;
import java.util.Set;

public class PotSpecialRenderer implements SpecialModelRenderer<DataComponentMap> {
    private final List<PotModel> models;

    public PotSpecialRenderer(List<PotModel> models) {
        this.models = models;
    }

    @Override
    public void submit(@Nullable DataComponentMap argument, ItemDisplayContext displayContext, PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, int packedOverlay, boolean hasFoil, int outlineColor) {
        assert argument!=null;
        PotRecord potRecord = argument.getOrDefault(EmoComponents.POT.get(), new PotRecord("empty", 0));

        poseStack.pushPose();

        if (displayContext.equals(ItemDisplayContext.GROUND)) poseStack.translate(0.5F, 2.5F, 0.5F);
        else poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.scale(1.0F, -1.0F, -1.0F);

        PotModel model = models.get(potRecord.fillLevel());
        PotModel.State state = new PotModel.State();

        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "textures/entity/pot/pot" + (potRecord.fillLevel() > 0 ? "_" + potRecord.contentType():"") + ".png");

        RenderType renderType = RenderType.entityCutout(location);

        nodeCollector.submitModel(
                model,
                state,
                poseStack,
                renderType,
                packedLight,
                packedOverlay,
                outlineColor,
                null
        );

        poseStack.popPose();
    }

    @Override
    public void getExtents(Set<Vector3f> output) {
        PoseStack poseStack = new PoseStack();
        this.models.getFirst().root().getExtentsForGui(poseStack, output);
    }

    @Override
    public DataComponentMap extractArgument(ItemStack stack) {
        return stack.immutableComponents();
    }

    public record Unbaked() implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<PotSpecialRenderer.Unbaked> MAP_CODEC = MapCodec.unit(new PotSpecialRenderer.Unbaked());

        @Override
        public MapCodec<? extends SpecialModelRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public @Nullable SpecialModelRenderer<?> bake(BakingContext context) {
            return new PotSpecialRenderer(EmoUtils.getPots(context));
        }
    }
}
