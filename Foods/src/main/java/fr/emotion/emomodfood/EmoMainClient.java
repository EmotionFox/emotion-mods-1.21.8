package fr.emotion.emomodfood;

import fr.emotion.emomodfood.blocks.entity.PotModel;
import fr.emotion.emomodfood.blocks.entity.PotRenderer;
import fr.emotion.emomodfood.blocks.entity.PotSpecialRenderer;
import fr.emotion.emomodfood.init.EmoBlockEntityTypes;
import fr.emotion.emomodfood.init.EmoBlocks;
import fr.emotion.emomodfood.init.EmoItems;
import fr.emotion.emomodfood.models.EmoModelLayers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterSpecialModelRendererEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

@Mod(value = EmoMain.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = EmoMain.MODID, value = Dist.CLIENT)
public class EmoMainClient {
    public EmoMainClient(ModContainer container) {
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.TOMATOES.get(), ChunkSectionLayer.CUTOUT);
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

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(EmoModelLayers.POT, PotModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterSpecialRenderers(RegisterSpecialModelRendererEvent event) {
        event.register(
                ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pot_special"),
                PotSpecialRenderer.Unbaked.MAP_CODEC
        );
    }

    @SubscribeEvent
    public static void onRegisterEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(
                EmoBlockEntityTypes.POT.get(),
                PotRenderer::new
        );
    }
}
