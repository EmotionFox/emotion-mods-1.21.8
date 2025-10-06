package fr.emotion.emomodfood.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class EmoComponentCodecs {
    public static final Codec<PotRecord> POT_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("contentType").forGetter(PotRecord::contentType),
                    Codec.INT.fieldOf("fillLevel").forGetter(PotRecord::fillLevel)
            ).apply(instance, PotRecord::new)
    );

    public static final StreamCodec<ByteBuf, PotRecord> POT_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, PotRecord::contentType,
            ByteBufCodecs.INT, PotRecord::fillLevel,
            PotRecord::new
    );
}
