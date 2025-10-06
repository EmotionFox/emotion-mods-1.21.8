package fr.emotion.emomodfood.blocks.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class PotModel extends Model {
    public final ModelPart pot;
    public final ModelPart layer_1;
    public final ModelPart layer_2;
    public final ModelPart layer_3;
    public final ModelPart layer_4;

    public PotModel(ModelPart root) {
        super(root, RenderType::entityCutout);
        this.pot = root.getChild("pot");
        this.layer_1 = root.getChild("layer_1");
        this.layer_2 = root.getChild("layer_2");
        this.layer_3 = root.getChild("layer_3");
        this.layer_4 = root.getChild("layer_4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition pot = partdefinition.addOrReplaceChild("pot", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(40, 4).addBox(-3.0F, -11.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        partdefinition.addOrReplaceChild("layer_1", CubeListBuilder.create().texOffs(0, 54).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        partdefinition.addOrReplaceChild("layer_2", CubeListBuilder.create().texOffs(0, 43).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        partdefinition.addOrReplaceChild("layer_3", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        partdefinition.addOrReplaceChild("layer_4", CubeListBuilder.create().texOffs(0, 21).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}
