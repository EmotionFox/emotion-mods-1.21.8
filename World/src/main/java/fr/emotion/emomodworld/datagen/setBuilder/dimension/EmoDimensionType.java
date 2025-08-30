package fr.emotion.emomodworld.datagen.setBuilder.dimension;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.Optional;
import java.util.OptionalLong;

public class EmoDimensionType {
    public static final ResourceKey<DimensionType> DREAM = ResourceKey.create(
            Registries.DIMENSION_TYPE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream")
    );

    public static final ResourceLocation DREAM_EFFECTS = ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream");

    public static void init(BootstrapContext<DimensionType> context) {
        context.register(
                DREAM,
                new DimensionType(
                        OptionalLong.of(6000L),
                        true,
                        false,
                        false,
                        true,
                        1.0,
                        true,
                        false,
                        0,
                        256,
                        0,
                        BlockTags.INFINIBURN_OVERWORLD,
                        EmoDimensionType.DREAM_EFFECTS,
                        0.1F,
                        Optional.of(0),
                        new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)
                )
        );
    }
}
