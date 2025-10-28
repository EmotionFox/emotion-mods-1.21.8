package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.structures.DreamDungeon;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoStructureType {
    private static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE = DeferredRegister.create(Registries.STRUCTURE_TYPE, EmoMain.MODID);

    public static final DeferredHolder<StructureType<?>, StructureType<DreamDungeon>> DREAM_DUNGEON = STRUCTURE_TYPE.register(
            "dream_dungeon",
            () -> () -> DreamDungeon.CODEC
    );

    public static void init(IEventBus event){
        STRUCTURE_TYPE.register(event);
    }
}
