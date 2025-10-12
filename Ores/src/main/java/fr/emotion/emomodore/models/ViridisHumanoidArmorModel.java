package fr.emotion.emomodore.models;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

public class ViridisHumanoidArmorModel<S extends HumanoidRenderState> extends HumanoidModel<S> {
    public ViridisHumanoidArmorModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(CubeDeformation cubeDeformation) {
        MeshDefinition mesh = HumanoidModel.createMesh(cubeDeformation, 0F);
        PartDefinition part = mesh.getRoot();

        part.getChild("body").addOrReplaceChild(
                "chest",
                CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 4.0F, 4.0F, cubeDeformation.extend(0.5F)),
                PartPose.ZERO
        );
        part.getChild("left_arm").addOrReplaceChild(
                "left_shoulder",
                CubeListBuilder.create().texOffs(64, 0).addBox(-2F, -2.0F, -2F, 4F, 2.0F, 4F, cubeDeformation),
                PartPose.offset(1.0F, -3F, 0F)
        );
        part.getChild("right_arm").addOrReplaceChild(
                "right_shoulder",
                CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-2F, -2.0F, -2F, 4F, 2.0F, 4F, cubeDeformation),
                PartPose.offset(-1.0F, -3F, 0F)
        );
        part.addOrReplaceChild(
                "right_leg",
                CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubeDeformation.extend(-0.1F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F)
        );
        part.addOrReplaceChild(
                "left_leg",
                CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubeDeformation.extend(-0.1F)),
                PartPose.offset(1.9F, 12.0F, 0.0F)
        );

        return LayerDefinition.create(mesh, 80, 32);
    }
}
