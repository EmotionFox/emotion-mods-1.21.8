package fr.emotion.emomodworld.world.tree;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.datagen.setBuilder.EmoConfiguredFeature;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class EmoTreeGrower {
    public static final TreeGrower PEAR = new TreeGrower(
            EmoMain.MODID + "pear",
            Optional.empty(),
            Optional.of(EmoConfiguredFeature.PEAR),
            Optional.empty()
    );
    public static final TreeGrower ORANGE = new TreeGrower(
            EmoMain.MODID + "orange",
            Optional.empty(),
            Optional.of(EmoConfiguredFeature.ORANGE),
            Optional.empty()
    );
    public static final TreeGrower ATLAS = new TreeGrower(
            EmoMain.MODID + "atlas",
            Optional.empty(),
            Optional.of(EmoConfiguredFeature.ATLAS),
            Optional.empty()
    );
    public static final TreeGrower PINE = new TreeGrower(
            EmoMain.MODID + "pine",
            Optional.empty(),
            Optional.of(EmoConfiguredFeature.PINE),
            Optional.empty()
    );
    public static final TreeGrower COCO = new TreeGrower(
            EmoMain.MODID + "coco",
            Optional.empty(),
            Optional.of(EmoConfiguredFeature.COCO),
            Optional.empty()
    );
    public static final TreeGrower DREAM = new TreeGrower(
            EmoMain.MODID + "dream",
            Optional.empty(),
            Optional.of(EmoConfiguredFeature.DREAM),
            Optional.empty()
    );
}
