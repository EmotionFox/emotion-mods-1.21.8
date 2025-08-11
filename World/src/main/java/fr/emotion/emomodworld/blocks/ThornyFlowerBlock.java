package fr.emotion.emomodworld.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class ThornyFlowerBlock extends FlowerBlock {
    public ThornyFlowerBlock(Holder<MobEffect> effect, float seconds, Properties properties) {
        super(effect, seconds, properties);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier) {
        if (level instanceof ServerLevel serverlevel && entity instanceof LivingEntity) {
            Vec3 vec3 = entity.isClientAuthoritative() ? entity.getKnownMovement():entity.oldPosition().subtract(entity.position());
            if (vec3.horizontalDistanceSqr() > 0.0) {
                double d0 = Math.abs(vec3.x());
                double d1 = Math.abs(vec3.z());
                if (d0 >= 0.003F || d1 >= 0.003F) {
                    entity.hurtServer(serverlevel, entity.damageSources().generic(), 1.0F);
                }
            }
        }
    }
}
