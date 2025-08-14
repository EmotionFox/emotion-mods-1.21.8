package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.world.InGridPlacement;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoPlacementModifierType {
    private static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER_TYPE = DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, EmoMain.MODID);

    public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<InGridPlacement>> IN_GRID = PLACEMENT_MODIFIER_TYPE.register("in_grid", () -> () -> InGridPlacement.CODEC);

    public static void init(IEventBus eventBus) {
        PLACEMENT_MODIFIER_TYPE.register(eventBus);
    }
}
