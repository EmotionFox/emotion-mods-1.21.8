package fr.emotion.emomodworld.entities.butterfly;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class ButterflyModel extends EntityModel<ButterflyRenderState> {
    private final ModelPart head;
    private final KeyframeAnimation flyAnimation;
    private final KeyframeAnimation landAnimation;
    private final KeyframeAnimation restAnimation;

    protected ButterflyModel(ModelPart root) {
        super(root, RenderType::entityCutout);
        root.getChild("body");
        root.getChild("lWing");
        root.getChild("rWing");
        this.head = root.getChild("head");
        this.flyAnimation = ButterflyAnimations.fly.bake(root);
        this.landAnimation = ButterflyAnimations.land.bake(root);
        this.restAnimation = ButterflyAnimations.rest.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -0.5F));

        PartDefinition lWing = partdefinition.addOrReplaceChild("lWing", CubeListBuilder.create(), PartPose.offset(0.5F, 23.0F, -4.0F));

        lWing.addOrReplaceChild("lWing_r1", CubeListBuilder.create().texOffs(-8, 8).mirror().addBox(0.0F, 0.0F, 0.0F, 7.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));

        partdefinition.addOrReplaceChild("rWing", CubeListBuilder.create().texOffs(-8, 8).addBox(-7.0F, 0.0F, 0.0F, 7.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 23.0F, -4.0F, 0.0F, 0.0436F, 0.0F));

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(8, 1).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -3.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(ButterflyRenderState renderState) {
        super.setupAnim(renderState);

        if(renderState.isResting){
            this.applyHeadRotation(renderState.yRot);
        }

        this.flyAnimation.apply(renderState.flyAnimationState, renderState.ageInTicks);
        this.landAnimation.apply(renderState.landAnimationState, renderState.ageInTicks);
        this.restAnimation.apply(renderState.restAnimationState, renderState.ageInTicks);
    }

    private void applyHeadRotation(float headRotation) {
        this.head.yRot = headRotation * (float) (Math.PI / 180.0);
    }
}
