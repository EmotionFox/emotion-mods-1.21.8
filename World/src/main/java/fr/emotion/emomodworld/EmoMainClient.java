package fr.emotion.emomodworld;

import fr.emotion.emomodworld.blocks.properties.EmoWoodType;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoEntityType;
import fr.emotion.emomodworld.init.EmoItems;
import fr.emotion.emomodworld.models.EmoBoatRenderer;
import fr.emotion.emomodworld.models.EmoModelLayers;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.special.HangingSignSpecialRenderer;
import net.minecraft.client.renderer.special.StandingSignSpecialRenderer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.GrassColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterSpecialBlockModelRendererEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(value = EmoMain.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = EmoMain.MODID, value = Dist.CLIENT)
public class EmoMainClient {
    public EmoMainClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_KITTY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_NOX.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_DELY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_GNON.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_THORNY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_CENTUS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_NEBULA.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_NARCOTA.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.DREAM_SHORT_GRASS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.DREAM_TALL_GRASS.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_KITTY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_NOX.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_DELY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_GNON.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_THORNY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_CENTUS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_NEBULA.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_NARCOTA.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PEAR_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_PEAR_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PEAR_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PEAR_DOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BUSH_BLACKCURRANT.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BUSH_BLUEBERRY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BUSH_DREAMCURRANT.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BUSH_STRAWBERRY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BUSH_SWEET.get(), ChunkSectionLayer.CUTOUT);

        event.enqueueWork(() -> {
            Sheets.addWoodType(EmoWoodType.PEAR);
        });
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EmoEntityType.PEAR_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.PEAR_BOAT));
        event.registerEntityRenderer(EmoEntityType.PEAR_CHEST_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.PEAR_CHEST_BOAT));
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(EmoModelLayers.PEAR_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(EmoModelLayers.PEAR_CHEST_BOAT, BoatModel::createChestBoatModel);
    }

    @SubscribeEvent
    public static void BuildContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key==CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(EmoBlocks.FLOWER_KITTY);
            event.accept(EmoBlocks.FLOWER_NOX);
            event.accept(EmoBlocks.FLOWER_DELY);
            event.accept(EmoBlocks.FLOWER_GNON);
            event.accept(EmoBlocks.FLOWER_THORNY);
            event.accept(EmoBlocks.FLOWER_CENTUS);
            event.accept(EmoBlocks.FLOWER_NEBULA);
            event.accept(EmoBlocks.FLOWER_NARCOTA);
            event.accept(EmoBlocks.DREAM_SHORT_GRASS);
            event.accept(EmoBlocks.DREAM_TALL_GRASS);
            event.accept(EmoBlocks.PEAR_LOG);
            event.accept(EmoBlocks.PEAR_LEAVES);
            event.accept(EmoBlocks.PEAR_SAPLING);
            event.accept(EmoBlocks.BUSH_BLACKCURRANT);
            event.accept(EmoBlocks.BUSH_BLUEBERRY);
            event.accept(EmoBlocks.BUSH_DREAMCURRANT);
            event.accept(EmoBlocks.BUSH_STRAWBERRY);
            event.accept(EmoBlocks.BUSH_SWEET);
        } else if (key==CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(EmoBlocks.PEAR_LOG);
            event.accept(EmoBlocks.PEAR_WOOD);
            event.accept(EmoBlocks.STRIPPED_PEAR_LOG);
            event.accept(EmoBlocks.STRIPPED_PEAR_WOOD);
            event.accept(EmoBlocks.PEAR_PLANKS);
            event.accept(EmoBlocks.PEAR_STAIRS);
            event.accept(EmoBlocks.PEAR_SLAB);
            event.accept(EmoBlocks.PEAR_FENCE);
            event.accept(EmoBlocks.PEAR_FENCE_GATE);
            event.accept(EmoBlocks.PEAR_DOOR);
            event.accept(EmoBlocks.PEAR_TRAPDOOR);
            event.accept(EmoBlocks.PEAR_PRESSURE_PLATE);
            event.accept(EmoBlocks.PEAR_BUTTON);
        } else if (key==CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(EmoBlocks.PEAR_SIGN);
            event.accept(EmoBlocks.PEAR_HANGING_SIGN);
        } else if (key==CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(EmoItems.PEAR_BOAT);
            event.accept(EmoItems.PEAR_CHEST_BOAT);
        }
    }

    @SubscribeEvent
    public static void onRegisterSpecialBlockModelRenderer(RegisterSpecialBlockModelRendererEvent event) {
        event.register(
                EmoBlocks.PEAR_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.PEAR)
        );
        event.register(
                EmoBlocks.PEAR_WALL_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.PEAR)
        );
        event.register(
                EmoBlocks.PEAR_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.PEAR)
        );
        event.register(
                EmoBlocks.PEAR_WALL_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.PEAR)
        );
    }

    @SubscribeEvent
    public static void onRegisterColorHandlersEvent(RegisterColorHandlersEvent.Block event) {
        int baseColor = 0x6A9E3F;

        BlockColor foliageColor = (state, world, pos, tintIndex) -> {
            if (world!=null && pos!=null) {
                int biomeColor = BiomeColors.getAverageFoliageColor(world, pos);
                return blendColors(baseColor, biomeColor, 0.75F);
            }

            return baseColor;
        };

        BlockColor grassColor = (state, world, pos, tintIndex) -> (world!=null && pos!=null) ? BiomeColors.getAverageGrassColor(world, pos):GrassColor.getDefaultColor();

        event.register(foliageColor, EmoBlocks.PEAR_LEAVES.get(), EmoBlocks.PEAR_SAPLING.get());
        event.register(grassColor, EmoBlocks.DREAM_SHORT_GRASS.get(), EmoBlocks.DREAM_TALL_GRASS.get());
    }

    public static int blendColors(int color1, int color2, float ratio) {
        float inverseRatio = 1.0F - ratio;
        int r = (int) (((color1 >> 16 & 0xFF) * ratio) + ((color2 >> 16 & 0xFF) * inverseRatio));
        int g = (int) (((color1 >> 8 & 0xFF) * ratio) + ((color2 >> 8 & 0xFF) * inverseRatio));
        int b = (int) (((color1 & 0xFF) * ratio) + ((color2 & 0xFF) * inverseRatio));

        return (r << 16) | (g << 8) | b;
    }
}
