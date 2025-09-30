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
                        EmoEntityType.PEAR_BOAT.get(),
                        EmoEntityType.ORANGE_BOAT.get(),
                        EmoEntityType.ATLAS_BOAT.get(),
                        EmoEntityType.PINE_BOAT.get(),
                        EmoEntityType.COCO_BOAT.get(),
                        EmoEntityType.DREAM_BOAT.get()
                );
        this.tag(EntityTypeTags.DISMOUNTS_UNDERWATER)
                .add(
                        EmoEntityType.BOAR.get()
                );
        this.tag(EntityTypeTags.CAN_EQUIP_SADDLE)
                .add(
                        EmoEntityType.BOAR.get()
                );
        this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE)
                .add(
                        EmoEntityType.BUTTERFLY.get()
                );
        this.tag(EntityTypeTags.NO_ANGER_FROM_WIND_CHARGE)
                .add(
                        EmoEntityType.JUMPING_SPIDER.get()
                );
        this.tag(EntityTypeTags.ARTHROPOD)
                .add(
                        EmoEntityType.JUMPING_SPIDER.get()
                );
        this.tag(EntityTypeTags.FOLLOWABLE_FRIENDLY_MOBS)
                .add(
                        EmoEntityType.MOUSE.get()
                );
    }
}
