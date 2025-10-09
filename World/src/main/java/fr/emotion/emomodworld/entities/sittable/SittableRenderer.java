package fr.emotion.emomodworld.entities.sittable;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SittableRenderer extends EntityRenderer<Sittable, SittableRenderState> {
    public SittableRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public SittableRenderState createRenderState() {
        return new SittableRenderState();
    }

    @Override
    public boolean shouldRender(Sittable livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}
