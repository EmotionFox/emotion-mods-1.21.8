package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.world.EmoWorldPresetKeys;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.WorldPresetTagsProvider;
import net.minecraft.tags.WorldPresetTags;

import java.util.concurrent.CompletableFuture;

public class EmoWorldPresetTagsProvider extends WorldPresetTagsProvider {
    public EmoWorldPresetTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, EmoMain.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        this.tag(WorldPresetTags.EXTENDED)
                .add(EmoWorldPresetKeys.PARCEL);
    }
}
