package fr.emotion.emomodworld.datagen.setBuilder;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class EmoBiomeModifier {
    public static final ResourceKey<BiomeModifier> ADD_BUSH_EMOSWEET = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "add_bush_emosweet")
    );

    public static void init(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(ADD_BUSH_EMOSWEET,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
                        HolderSet.direct(placedFeatures.getOrThrow(EmoPlacedFeature.PATCH_BUSH_EMOSWEET)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
    }
}
