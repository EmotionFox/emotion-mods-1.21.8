package fr.emotion.emomodcore.utils;

import fr.emotion.emomodcore.EmoMain;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record DreamSyncPayload(long awakening, long period, boolean dreaming) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<DreamSyncPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_sync"));

    public static final StreamCodec<ByteBuf, DreamSyncPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.LONG,
            DreamSyncPayload::awakening,
            ByteBufCodecs.LONG,
            DreamSyncPayload::period,
            ByteBufCodecs.BOOL,
            DreamSyncPayload::dreaming,
            DreamSyncPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
