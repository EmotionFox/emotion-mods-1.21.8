package fr.emotion.emomodore.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class EmoComponentCodecs {
    public static final Codec<PhaseRecord> PHASE_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("value").forGetter(PhaseRecord::value)
            ).apply(instance, PhaseRecord::new)
    );

    public static final StreamCodec<ByteBuf, PhaseRecord> PHASE_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, PhaseRecord::value,
            PhaseRecord::new
    );
}
