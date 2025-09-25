package fr.emotion.emomodworld.entities.mouse;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class MouseModel extends EntityModel<MouseRenderState> {
    private final ModelPart head;
    private final ModelPart tail;

    protected MouseModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        root.getChild("body");
        this.tail = root.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild(
                "head",
                CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(11, 2).addBox(0.5F, -2.0F, -0.5F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                        .texOffs(11, 2).addBox(-2.5F, -2.0F, -0.5F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                        .texOffs(11, 5).addBox(-0.5F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 23.0F, -2.0F)
        );
        partdefinition.addOrReplaceChild(
                "body",
                CubeListBuilder.create().texOffs(0, 4).addBox(-1.5F, -3.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F)
        );
        partdefinition.addOrReplaceChild(
                "tail",
                CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 23.5F, 2.0F)
        );
        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(MouseRenderState renderState) {
        super.setupAnim(renderState);
        float f1 = renderState.walkAnimationSpeed;
        float f2 = renderState.walkAnimationPos;

        this.head.yRot = renderState.yRot * (float) (Math.PI / 180.0);
        this.tail.yRot = 0.5F * Mth.triangleWave(f2, 13.0F) * f1;
    }
}
