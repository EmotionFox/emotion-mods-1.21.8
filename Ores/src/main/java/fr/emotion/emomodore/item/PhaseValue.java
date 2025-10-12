package fr.emotion.emomodore.item;

import com.mojang.serialization.MapCodec;
import fr.emotion.emomodore.init.EmoComponents;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class PhaseValue implements RangeSelectItemModelProperty {
    public static final MapCodec<PhaseValue> MAP_CODEC = MapCodec.unit(new PhaseValue());

    @Override
    public float get(ItemStack stack, @Nullable ClientLevel level, @Nullable ItemOwner owner, int seed) {
        if (stack.has(EmoComponents.PHASE.get())) {
            return stack.get(EmoComponents.PHASE.get()).value();
        }
        return 0;
    }

    @Override
    public MapCodec<? extends RangeSelectItemModelProperty> type() {
        return MAP_CODEC;
    }
}
