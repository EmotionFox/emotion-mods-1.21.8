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
}
