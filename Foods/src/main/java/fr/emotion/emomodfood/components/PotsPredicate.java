package fr.emotion.emomodfood.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.emotion.emomodfood.init.EmoComponents;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.predicates.DataComponentPredicate;

public record PotsPredicate(int fillLevel) implements DataComponentPredicate {
    public static final Codec<PotsPredicate> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            Codec.INT.fieldOf("fillLevel").forGetter(PotsPredicate::fillLevel)
                    )
                    .apply(instance, PotsPredicate::new)
    );

    @Override
    public boolean matches(DataComponentGetter componentGetter) {
        PotRecord component = componentGetter.getOrDefault(EmoComponents.POT, new PotRecord("empty", 0));

        if (component.fillLevel() > 0) return true;
        else return false;
    }
}
