package fr.emotion.emomodworld.entities.beetle;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class BeetleModel extends EntityModel<BeetleRenderState> {
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightBackLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftBackLeg;
    private final KeyframeAnimation idleAnimation;
    private final KeyframeAnimation walkAnimation;


    public BeetleModel(ModelPart root) {
        super(root, RenderType::entityCutout);
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.rightBackLeg = root.getChild("rightBackLeg");
        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.leftBackLeg = root.getChild("leftBackLeg");
        this.idleAnimation = BeetleAnimations.idle.bake(root);
        this.walkAnimation = BeetleAnimations.walk.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(-0.5F, -1.0F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(6, 5).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 23.5F, -2.0F));

        PartDefinition rightAntenna_r1 = head.addOrReplaceChild("rightAntenna_r1", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -2.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -0.5F, 0.3655F, 0.147F, -0.3655F));

        PartDefinition leftAntenna_r1 = head.addOrReplaceChild("leftAntenna_r1", CubeListBuilder.create().texOffs(2, 8).addBox(0.0F, -2.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, -0.5F, 0.3655F, -0.147F, 0.3655F));

        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(8, 9).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 23.5F, -0.5F, 0.0F, 0.0F, -0.5672F));

        PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(7, 10).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 23.5F, 1.5F, 0.0F, 0.0F, -0.5672F));

        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(4, 9).addBox(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.5F, -0.5F, 0.0F, 0.0F, 0.5672F));

        PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(4, 10).addBox(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.5F, 1.5F, 0.0F, 0.0F, 0.6144F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(BeetleRenderState renderState) {
        super.setupAnim(renderState);
        this.applyHeadRotation(renderState.yRot);
        this.idleAnimation.apply(renderState.idleAnimationState, renderState.ageInTicks);
        this.walkAnimation.apply(renderState.walkAnimationState, renderState.ageInTicks);
    }

    private void applyHeadRotation(float headRotation) {
        this.head.yRot = headRotation * (float) (Math.PI / 180.0);
    }
}
