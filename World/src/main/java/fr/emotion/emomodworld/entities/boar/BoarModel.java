package fr.emotion.emomodworld.entities.boar;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class BoarModel extends QuadrupedModel<BoarRenderState> {
    private final ModelPart head;
    private final KeyframeAnimation chargeAnimation;
    private final KeyframeAnimation restAnimation;

    protected BoarModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.chargeAnimation = BoarAnimations.charge.bake(root);
        this.restAnimation = BoarAnimations.rest.bake(root);
    }

    public static LayerDefinition createBodyLayer(boolean isBaby) {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        if (!isBaby) {
            PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(27, 27).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                    .texOffs(26, 42).addBox(-1.5F, 1.0F, -9.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                    .texOffs(16, 27).addBox(3.0F, 0.0F, -4.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 27).addBox(-4.0F, 0.0F, -4.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                    .texOffs(39, 42).addBox(2.0F, -6.0F, -5.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(37, 10).addBox(-4.0F, -6.0F, -5.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -8.0F));

            PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, 7.0F));

            tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 48).addBox(-1.0F, -4.5355F, 8.4645F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.4645F, -3.5355F, -0.7854F, 0.0F, 0.0F));

            tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(37, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

            partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -8.0F, 10.0F, 10.0F, 16.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 27).addBox(-1.0F, -6.0F, -8.0F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

            partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(13, 40).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 20.0F, -6.5F));

            partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 40).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 20.0F, -6.5F));

            partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 20.0F, 6.5F));

            partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 20.0F, 6.5F));
        } else {
            PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(15, 14).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                    .texOffs(9, 19).addBox(-0.5F, 0.5F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.5F, -4.0F));

            head.addOrReplaceChild("rEar_r1", CubeListBuilder.create().texOffs(1, 18).addBox(-1.5F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.0F, -1.5F, 0.1745F, 0.2618F, 0.0F));

            head.addOrReplaceChild("lEar_r1", CubeListBuilder.create().texOffs(1, 14).addBox(-0.5F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, -1.5F, 0.1745F, -0.2618F, 0.0F));

            partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(6, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 22.0F, 3.5F));

            partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(1, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 22.0F, 3.5F));

            partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(1, 23).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 24.0F, -3.0F));

            partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(6, 23).addBox(0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 22.0F, -3.0F));

            PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -4.0F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.5F, 0.0F));

            body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(27, 8).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 4.0F, 0.2618F, 0.0F, 0.0F));
        }

        return LayerDefinition.create(meshdefinition, isBaby ? 32 : 64, isBaby ? 32 : 64);
    }

    @Override
    public void setupAnim(BoarRenderState renderState) {
        super.setupAnim(renderState);

        if (renderState.isResting) {
            this.applyHeadRotation(renderState.yRot);
        }

        this.chargeAnimation.apply(renderState.chargeAnimationState, renderState.ageInTicks);
        this.restAnimation.apply(renderState.restAnimationState, renderState.ageInTicks);
    }

    private void applyHeadRotation(float headRotation) {
        this.head.yRot = headRotation * (float) (Math.PI / 180.0);
    }
}
