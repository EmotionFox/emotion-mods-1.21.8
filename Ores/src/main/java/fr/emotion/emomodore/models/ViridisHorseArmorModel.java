package fr.emotion.emomodore.models;

import net.minecraft.client.model.AbstractEquineModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.EquineRenderState;

public class ViridisHorseArmorModel<T extends EquineRenderState> extends AbstractEquineModel<T> {
    public ViridisHorseArmorModel(ModelPart root) { super(root); }

    public static LayerDefinition createLayer(CubeDeformation cubeDeformation) {
        MeshDefinition mesh = HumanoidModel.createMesh(cubeDeformation, 0F);
        PartDefinition part = mesh.getRoot();

        return LayerDefinition.create(mesh, 64, 64);
    }
}
