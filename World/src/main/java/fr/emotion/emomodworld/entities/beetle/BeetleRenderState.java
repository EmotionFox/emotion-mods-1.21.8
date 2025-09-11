package fr.emotion.emomodworld.entities.beetle;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

import javax.annotation.Nullable;

public class BeetleRenderState extends LivingEntityRenderState {
    @Nullable
    public Beetle.BeetleVariant variant;
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
}
