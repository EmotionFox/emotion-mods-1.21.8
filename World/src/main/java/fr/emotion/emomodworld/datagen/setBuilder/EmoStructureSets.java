package fr.emotion.emomodworld.datagen.setBuilder;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

import java.util.List;
import java.util.Optional;

public class EmoStructureSets {
    public static final ResourceKey<StructureSet> DREAM_DUNGEON = ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_dungeon"));

    public static void init(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> holdergetter = context.lookup(Registries.STRUCTURE);
        HolderGetter<Biome> holdergetter1 = context.lookup(Registries.BIOME);

        context.register(
                DREAM_DUNGEON,
                new StructureSet(
                        List.of(
                                StructureSet.entry(holdergetter.getOrThrow(EmoStructures.DREAM_DUNGEON))
                        ),
                        new RandomSpreadStructurePlacement(
                                Vec3i.ZERO,
                                StructurePlacement.FrequencyReductionMethod.LEGACY_TYPE_3,
                                0.004F,
                                1224466880,
                                Optional.empty(),
                                1,
                                0,
                                RandomSpreadType.LINEAR
                        )
                )
        );
    }
}
