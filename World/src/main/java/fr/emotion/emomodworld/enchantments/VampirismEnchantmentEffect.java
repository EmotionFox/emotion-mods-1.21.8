package fr.emotion.emomodworld.enchantments;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record VampirismEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<VampirismEnchantmentEffect> CODEC = MapCodec.unit(fr.emotion.emomodworld.enchantments.VampirismEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        if (item.owner()!=null && entity instanceof LivingEntity livingEntity) {
            if (!item.owner().swinging) {
                double damage = item.itemStack().get(DataComponents.WEAPON).itemDamagePerAttack();

                for (ItemAttributeModifiers.Entry modifiers : item.itemStack().getAttributeModifiers().modifiers()) {
                    if (modifiers.attribute().is(ResourceLocation.withDefaultNamespace("attack_damage"))) {
                        damage += modifiers.modifier().amount();
                    }
                }

                float heal = (float) (damage * enchantmentLevel / 4.0);

                item.owner().heal((float) Math.min(heal, livingEntity.getHealth() <= 0F ? enchantmentLevel:livingEntity.getHealth() + damage));
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
