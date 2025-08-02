package fr.emotion.emomodore.item;

import com.mojang.serialization.MapCodec;
import fr.emotion.emomodore.MainRegistry;
import fr.emotion.emomodore.init.ComponentRegistry;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

@Mod(value = MainRegistry.MODID, dist = Dist.CLIENT)
public class PhaseValue implements RangeSelectItemModelProperty {
    public static final MapCodec<PhaseValue> MAP_CODEC = MapCodec.unit(new PhaseValue());

    @Override
    public float get(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed) {
        if (stack.has(ComponentRegistry.PHASE.get())) {
            return stack.get(ComponentRegistry.PHASE.get()).value();
        }
        return 0;
    }

    @Override
    public MapCodec<? extends RangeSelectItemModelProperty> type() {
        return MAP_CODEC;
    }
}
