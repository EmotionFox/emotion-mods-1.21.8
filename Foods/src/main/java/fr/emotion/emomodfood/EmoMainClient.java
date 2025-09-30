package fr.emotion.emomodfood;

import fr.emotion.emomodfood.init.EmoItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

@Mod(value = EmoMain.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = EmoMain.MODID, value = Dist.CLIENT)
public class EmoMainClient {
    public EmoMainClient(ModContainer container) {
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key==CreativeModeTabs.FOOD_AND_DRINKS) {
            for (DeferredHolder<Item, ? extends Item> item : EmoItems.getItems().getEntries()) {
                event.accept(item.get());
            }
        }
    }
}
