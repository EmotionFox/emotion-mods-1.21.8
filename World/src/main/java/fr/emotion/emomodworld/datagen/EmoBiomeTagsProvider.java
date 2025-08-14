package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.world.biome.EmoBiomeKeys;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;

import java.util.concurrent.CompletableFuture;

public class EmoBiomeTagsProvider extends BiomeTagsProvider {
    public EmoBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, EmoMain.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        this.tag(BiomeTags.HAS_MINESHAFT)
                .add(EmoBiomeKeys.ORCHARD);
        this.tag(BiomeTags.HAS_RUINED_PORTAL_STANDARD)
                .add(EmoBiomeKeys.ORCHARD);
        this.tag(BiomeTags.STRONGHOLD_BIASED_TO)
                .add(EmoBiomeKeys.ORCHARD);
        this.tag(BiomeTags.IS_OVERWORLD)
                .add(EmoBiomeKeys.ORCHARD);
    }
}
