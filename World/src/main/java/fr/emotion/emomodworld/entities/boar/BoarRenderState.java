package fr.emotion.emomodworld.entities.boar;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.WalkAnimationState;

public class BoarRenderState extends LivingEntityRenderState {
    public boolean isBaby;
    public boolean isResting;
    public final AnimationState chargeAnimationState = new AnimationState();
    public final AnimationState restAnimationState = new AnimationState();
}
