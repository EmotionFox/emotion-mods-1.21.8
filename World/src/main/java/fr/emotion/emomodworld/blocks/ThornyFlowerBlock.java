package fr.emotion.emomodworld.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ThornyFlowerBlock extends FlowerBlock {
    public ThornyFlowerBlock(Holder<MobEffect> effect, float seconds, Properties properties) {
        super(effect, seconds, properties);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier) {
        if (level instanceof ServerLevel serverlevel
                && level.getDifficulty()!=Difficulty.PEACEFUL
                && entity instanceof LivingEntity livingentity
                && !livingentity.isInvulnerableTo(serverlevel, level.damageSources().cactus())) {
            livingentity.addEffect(this.getBeeInteractionEffect());
        }
    }

    @Override
    public @Nullable MobEffectInstance getBeeInteractionEffect() {
        return new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1);
    }
}
