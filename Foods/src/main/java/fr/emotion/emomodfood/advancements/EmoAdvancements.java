package fr.emotion.emomodfood.advancements;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

public class EmoAdvancements implements AdvancementSubProvider {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> writer) {
        HolderLookup<Item> itemRegistry = registries.lookupOrThrow(Registries.ITEM);
        
    }
}
