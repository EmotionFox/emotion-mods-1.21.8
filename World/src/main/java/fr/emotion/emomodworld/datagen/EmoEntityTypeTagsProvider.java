package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoEntityType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class EmoEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public EmoEntityTypeTagsProvider(PackOutput p_256095_, CompletableFuture<HolderLookup.Provider> p_256572_) {
        super(p_256095_, p_256572_, EmoMain.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_255894_) {
        this.tag(EntityTypeTags.BOAT)
                .add(
                        EmoEntityType.PEAR_BOAT.get()
                );
    }
}
