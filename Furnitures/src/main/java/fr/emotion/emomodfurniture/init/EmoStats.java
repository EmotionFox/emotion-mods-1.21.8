package fr.emotion.emomodfurniture.init;

import fr.emotion.emomodfurniture.EmoMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoStats {
    private static final DeferredRegister<ResourceLocation> STATS = DeferredRegister.create(Registries.CUSTOM_STAT, EmoMain.MODID);

    public static final DeferredHolder<ResourceLocation, ResourceLocation> OPEN_NIGHTSTAND = STATS.register(
            "open_nightstand",
            () -> ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "open_nightstand")
    );

    public static final DeferredHolder<ResourceLocation, ResourceLocation> STOOL_SIT = STATS.register(
            "stool_sit",
            () -> ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stool_sit")
    );

    public static void init(IEventBus event){
        STATS.register(event);
    }
}
