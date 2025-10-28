package fr.emotion.emomodworld.datagen.setBuilder;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class EmoPools {
    public static void init(BootstrapContext<StructureTemplatePool> context) {
        DreamDungeonStructurePieces.init(context);
    }
}
