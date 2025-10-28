package fr.emotion.emomodworld.datagen.setBuilder;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.structures.DreamDungeon;
import fr.emotion.emomodworld.tags.EmoBiomeTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;

public class EmoStructures {
    public static final ResourceKey<Structure> DREAM_DUNGEON = ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_dungeon"));

    public static void init(BootstrapContext<Structure> context) {
        HolderGetter<Biome> holderGetter = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> holderGetter1 = context.lookup(Registries.TEMPLATE_POOL);

        context.register(
                DREAM_DUNGEON,
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(holderGetter.getOrThrow(EmoBiomeTags.HAS_DREAM_DUNGEON))
                                .spawnOverrides(
                                        Map.of(
                                                MobCategory.MONSTER,
                                                new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.PIECE, DreamDungeon.DUNGEON_ENEMIES)
                                        )
                                )
                                .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                                .build(),
                        holderGetter1.getOrThrow(DreamDungeonStructurePieces.START),
                        7,
                        ConstantHeight.of(VerticalAnchor.absolute(0)),
                        true,
                        Heightmap.Types.WORLD_SURFACE_WG
                )
        );
    }
}
