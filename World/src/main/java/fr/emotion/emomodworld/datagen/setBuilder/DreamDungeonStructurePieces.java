package fr.emotion.emomodworld.datagen.setBuilder;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class DreamDungeonStructurePieces {
    public static final ResourceKey<StructureTemplatePool> START = Pools.createKey(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_dungeon"));

    public static void init(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureProcessorList> holdergetter = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureProcessorList> holder = holdergetter.getOrThrow(ProcessorLists.MOSSIFY_20_PERCENT);
        HolderGetter<StructureTemplatePool> holdergetter1 = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> holder1 = holdergetter1.getOrThrow(Pools.EMPTY);
        context.register(
                START,
                new StructureTemplatePool(
                        holder1,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single(EmoMain.MODID + ":dream_dungeon/atlas_corner", holder), 1),
                                Pair.of(StructurePoolElement.single(EmoMain.MODID + ":dream_dungeon/atlas_hallway", holder), 1),
                                Pair.of(StructurePoolElement.single(EmoMain.MODID + ":dream_dungeon/atlas_stairs", holder), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
