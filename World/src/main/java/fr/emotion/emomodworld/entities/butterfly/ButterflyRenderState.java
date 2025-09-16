package fr.emotion.emomodworld.entities.butterfly;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class ButterflyRenderState extends LivingEntityRenderState {
    public Butterfly.ButterflyVariant variant;
    public boolean isResting;
    public final AnimationState flyAnimationState = new AnimationState();
    public final AnimationState landAnimationState = new AnimationState();
    public final AnimationState restAnimationState = new AnimationState();
}
