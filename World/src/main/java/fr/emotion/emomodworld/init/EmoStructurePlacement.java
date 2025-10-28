package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.structures.placement.DistanceBasedStructurePlacement;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoStructurePlacement {
    private static final DeferredRegister<StructurePlacementType<?>> STRUCTURE_PLACEMENT_TYPE = DeferredRegister.create(Registries.STRUCTURE_PLACEMENT, EmoMain.MODID);

    public static final DeferredHolder<StructurePlacementType<?>, StructurePlacementType<DistanceBasedStructurePlacement>> DISTANCE_BASED = STRUCTURE_PLACEMENT_TYPE.register(
            "distance_based",
            () -> () -> DistanceBasedStructurePlacement.CODEC
    );

    public static void init(IEventBus event){
        STRUCTURE_PLACEMENT_TYPE.register(event);
    }
}
