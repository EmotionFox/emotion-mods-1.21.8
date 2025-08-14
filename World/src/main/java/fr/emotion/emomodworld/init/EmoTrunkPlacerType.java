package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.world.tree.CrossTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoTrunkPlacerType {
    private static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPE = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, EmoMain.MODID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<CrossTrunkPlacer>> CROSS_TRUNK_PLACER = TRUNK_PLACER_TYPE.register("cross_trunk_placer", () -> new TrunkPlacerType<>(CrossTrunkPlacer.CODEC));

    public static void init(IEventBus eventBus) {
        TRUNK_PLACER_TYPE.register(eventBus);
    }
}
