package fr.emotion.emomodworld.init;

import com.mojang.serialization.MapCodec;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.enchantments.VampirismEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EmoEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS = DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, EmoMain.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> VAMPIRISM = ENTITY_ENCHANTMENT_EFFECTS.register(
            "vampirism",
            () -> VampirismEnchantmentEffect.CODEC
    );

    public static void init(IEventBus event) {
        ENTITY_ENCHANTMENT_EFFECTS.register(event);
    }
}
