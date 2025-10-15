package fr.emotion.emomodcore.utils;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;

public class DreamDataSyncer {
    public static void sync(ServerPlayer player, long awakening, long period, boolean dreaming) {
        PacketDistributor.sendToPlayer(player, new DreamSyncPayload(awakening, period, dreaming));
    }

    public static void reset(ServerPlayer player) {
        PacketDistributor.sendToPlayer(player, new DreamSyncPayload(0, 0, false));
    }
}
