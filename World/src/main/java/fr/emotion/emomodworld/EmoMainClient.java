package fr.emotion.emomodworld;

import fr.emotion.emomodworld.blocks.properties.EmoWoodType;
import fr.emotion.emomodworld.entities.beetle.Beetle;
import fr.emotion.emomodworld.entities.beetle.BeetleModel;
import fr.emotion.emomodworld.entities.beetle.BeetleRenderer;
import fr.emotion.emomodworld.entities.boar.Boar;
import fr.emotion.emomodworld.entities.boar.BoarModel;
import fr.emotion.emomodworld.entities.boar.BoarRenderer;
import fr.emotion.emomodworld.entities.butterfly.Butterfly;
import fr.emotion.emomodworld.entities.butterfly.ButterflyModel;
import fr.emotion.emomodworld.entities.butterfly.ButterflyRenderer;
import fr.emotion.emomodworld.entities.mouse.Mouse;
import fr.emotion.emomodworld.entities.mouse.MouseModel;
import fr.emotion.emomodworld.entities.mouse.MouseRenderer;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoEntityType;
import fr.emotion.emomodworld.init.EmoItems;
import fr.emotion.emomodworld.models.EmoBoatRenderer;
import fr.emotion.emomodworld.models.EmoModelLayers;
import fr.emotion.emomodworld.utils.EmoColor;
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
import net.minecraft.world.level.block.Blocks;
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
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import static fr.emotion.emomodworld.utils.EmoColor.blendColors;

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

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_KITTY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_NOX.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_DELY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_GNON.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_THORNY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_CENTUS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_NEBULA.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_NARCOTA.get(), ChunkSectionLayer.CUTOUT);

        // PEAR
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PEAR_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_PEAR_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PEAR_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PEAR_DOOR.get(), ChunkSectionLayer.CUTOUT);

        // ORANGE
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.ORANGE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_ORANGE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.ORANGE_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.ORANGE_DOOR.get(), ChunkSectionLayer.CUTOUT);

        // ATLAS
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.ATLAS_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_ATLAS_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.ATLAS_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.ATLAS_DOOR.get(), ChunkSectionLayer.CUTOUT);

        // PINE
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PINE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_PINE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PINE_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PINE_DOOR.get(), ChunkSectionLayer.CUTOUT);

        // COCO
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.COCO_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_COCO_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.COCO_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.COCO_DOOR.get(), ChunkSectionLayer.CUTOUT);

        // DREAM
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.DREAM_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_DREAM_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.DREAM_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.DREAM_DOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BUSH_BLACKCURRANT.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BUSH_BLUEBERRY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BUSH_DREAMCURRANT.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BUSH_STRAWBERRY.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BUSH_SWEET.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.BLUE_MUSHROOM.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.GREEN_MUSHROOM.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_BLUE_MUSHROOM.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_GREEN_MUSHROOM.get(), ChunkSectionLayer.CUTOUT);

        event.enqueueWork(() -> {
            Sheets.addWoodType(EmoWoodType.PEAR);
            Sheets.addWoodType(EmoWoodType.ORANGE);
            Sheets.addWoodType(EmoWoodType.ATLAS);
            Sheets.addWoodType(EmoWoodType.PINE);
            Sheets.addWoodType(EmoWoodType.COCO);
            Sheets.addWoodType(EmoWoodType.DREAM);
        });
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // PEAR
        event.registerEntityRenderer(EmoEntityType.PEAR_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.PEAR_BOAT));
        event.registerEntityRenderer(EmoEntityType.PEAR_CHEST_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.PEAR_CHEST_BOAT));

        // ORANGE
        event.registerEntityRenderer(EmoEntityType.ORANGE_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.ORANGE_BOAT));
        event.registerEntityRenderer(EmoEntityType.ORANGE_CHEST_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.ORANGE_CHEST_BOAT));

        // ATLAS
        event.registerEntityRenderer(EmoEntityType.ATLAS_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.ATLAS_BOAT));
        event.registerEntityRenderer(EmoEntityType.ATLAS_CHEST_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.ATLAS_CHEST_BOAT));

        // PINE
        event.registerEntityRenderer(EmoEntityType.PINE_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.PINE_BOAT));
        event.registerEntityRenderer(EmoEntityType.PINE_CHEST_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.PINE_CHEST_BOAT));

        // COCO
        event.registerEntityRenderer(EmoEntityType.COCO_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.COCO_BOAT));
        event.registerEntityRenderer(EmoEntityType.COCO_CHEST_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.COCO_CHEST_BOAT));

        // DREAM
        event.registerEntityRenderer(EmoEntityType.DREAM_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.DREAM_BOAT));
        event.registerEntityRenderer(EmoEntityType.DREAM_CHEST_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.DREAM_CHEST_BOAT));

        event.registerEntityRenderer(EmoEntityType.BEETLE.get(), BeetleRenderer::new);
        event.registerEntityRenderer(EmoEntityType.BUTTERFLY.get(), ButterflyRenderer::new);
        event.registerEntityRenderer(EmoEntityType.BOAR.get(), BoarRenderer::new);
        event.registerEntityRenderer(EmoEntityType.MOUSE.get(), MouseRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // PEAR
        event.registerLayerDefinition(EmoModelLayers.PEAR_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(EmoModelLayers.PEAR_CHEST_BOAT, BoatModel::createChestBoatModel);

        // ORANGE
        event.registerLayerDefinition(EmoModelLayers.ORANGE_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(EmoModelLayers.ORANGE_CHEST_BOAT, BoatModel::createChestBoatModel);

        // ATLAS
        event.registerLayerDefinition(EmoModelLayers.ATLAS_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(EmoModelLayers.ATLAS_CHEST_BOAT, BoatModel::createChestBoatModel);

        // PINE
        event.registerLayerDefinition(EmoModelLayers.PINE_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(EmoModelLayers.PINE_CHEST_BOAT, BoatModel::createChestBoatModel);

        // COCO
        event.registerLayerDefinition(EmoModelLayers.COCO_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(EmoModelLayers.COCO_CHEST_BOAT, BoatModel::createChestBoatModel);

        // DREAM
        event.registerLayerDefinition(EmoModelLayers.DREAM_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(EmoModelLayers.DREAM_CHEST_BOAT, BoatModel::createChestBoatModel);

        event.registerLayerDefinition(EmoModelLayers.BEETLE, BeetleModel::createBodyLayer);
        event.registerLayerDefinition(EmoModelLayers.BUTTERFLY, ButterflyModel::createBodyLayer);

        event.registerLayerDefinition(EmoModelLayers.BOAR, () -> BoarModel.createBodyLayer(false));
        event.registerLayerDefinition(EmoModelLayers.BOARLET, () -> BoarModel.createBodyLayer(true));

        event.registerLayerDefinition(EmoModelLayers.MOUSE, MouseModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(EmoEntityType.BEETLE.get(), Beetle.createAttributes().build());
        event.put(EmoEntityType.BUTTERFLY.get(), Butterfly.createAttributes().build());
        event.put(EmoEntityType.BOAR.get(), Boar.createAttributes().build());
        event.put(EmoEntityType.MOUSE.get(), Mouse.createAttributes().build());
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

            event.accept(EmoBlocks.PEAR_LOG);
            event.accept(EmoBlocks.PEAR_LEAVES);
            event.accept(EmoBlocks.PEAR_SAPLING);

            event.accept(EmoBlocks.ORANGE_LOG);
            event.accept(EmoBlocks.ORANGE_LEAVES);
            event.accept(EmoBlocks.ORANGE_SAPLING);

            event.accept(EmoBlocks.ATLAS_LOG);
            event.accept(EmoBlocks.ATLAS_LEAVES);
            event.accept(EmoBlocks.ATLAS_SAPLING);

            event.accept(EmoBlocks.PINE_LOG);
            event.accept(EmoBlocks.PINE_LEAVES);
            event.accept(EmoBlocks.PINE_SAPLING);

            event.accept(EmoBlocks.COCO_LOG);
            event.accept(EmoBlocks.COCO_LEAVES);
            event.accept(EmoBlocks.COCO_SAPLING);

            event.accept(EmoBlocks.DREAM_LOG);
            event.accept(EmoBlocks.DREAM_LEAVES);
            event.accept(EmoBlocks.DREAM_SAPLING);

            event.accept(EmoBlocks.BUSH_BLACKCURRANT);
            event.accept(EmoBlocks.BUSH_BLUEBERRY);
            event.accept(EmoBlocks.BUSH_DREAMCURRANT);
            event.accept(EmoBlocks.BUSH_STRAWBERRY);
            event.accept(EmoBlocks.BUSH_SWEET);

            event.accept(EmoBlocks.BLUE_MUSHROOM);
            event.accept(EmoBlocks.GREEN_MUSHROOM);

            event.accept(EmoBlocks.BLUE_MUSHROOM_BLOCK);
            event.accept(EmoBlocks.GREEN_MUSHROOM_BLOCK);
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

            event.accept(EmoBlocks.ORANGE_LOG);
            event.accept(EmoBlocks.ORANGE_WOOD);
            event.accept(EmoBlocks.STRIPPED_ORANGE_LOG);
            event.accept(EmoBlocks.STRIPPED_ORANGE_WOOD);
            event.accept(EmoBlocks.ORANGE_PLANKS);
            event.accept(EmoBlocks.ORANGE_STAIRS);
            event.accept(EmoBlocks.ORANGE_SLAB);
            event.accept(EmoBlocks.ORANGE_FENCE);
            event.accept(EmoBlocks.ORANGE_FENCE_GATE);
            event.accept(EmoBlocks.ORANGE_DOOR);
            event.accept(EmoBlocks.ORANGE_TRAPDOOR);
            event.accept(EmoBlocks.ORANGE_PRESSURE_PLATE);
            event.accept(EmoBlocks.ORANGE_BUTTON);

            event.accept(EmoBlocks.ATLAS_LOG);
            event.accept(EmoBlocks.ATLAS_WOOD);
            event.accept(EmoBlocks.STRIPPED_ATLAS_LOG);
            event.accept(EmoBlocks.STRIPPED_ATLAS_WOOD);
            event.accept(EmoBlocks.ATLAS_PLANKS);
            event.accept(EmoBlocks.ATLAS_STAIRS);
            event.accept(EmoBlocks.ATLAS_SLAB);
            event.accept(EmoBlocks.ATLAS_FENCE);
            event.accept(EmoBlocks.ATLAS_FENCE_GATE);
            event.accept(EmoBlocks.ATLAS_DOOR);
            event.accept(EmoBlocks.ATLAS_TRAPDOOR);
            event.accept(EmoBlocks.ATLAS_PRESSURE_PLATE);
            event.accept(EmoBlocks.ATLAS_BUTTON);

            event.accept(EmoBlocks.PINE_LOG);
            event.accept(EmoBlocks.PINE_WOOD);
            event.accept(EmoBlocks.STRIPPED_PINE_LOG);
            event.accept(EmoBlocks.STRIPPED_PINE_WOOD);
            event.accept(EmoBlocks.PINE_PLANKS);
            event.accept(EmoBlocks.PINE_STAIRS);
            event.accept(EmoBlocks.PINE_SLAB);
            event.accept(EmoBlocks.PINE_FENCE);
            event.accept(EmoBlocks.PINE_FENCE_GATE);
            event.accept(EmoBlocks.PINE_DOOR);
            event.accept(EmoBlocks.PINE_TRAPDOOR);
            event.accept(EmoBlocks.PINE_PRESSURE_PLATE);
            event.accept(EmoBlocks.PINE_BUTTON);

            event.accept(EmoBlocks.COCO_LOG);
            event.accept(EmoBlocks.COCO_WOOD);
            event.accept(EmoBlocks.STRIPPED_COCO_LOG);
            event.accept(EmoBlocks.STRIPPED_COCO_WOOD);
            event.accept(EmoBlocks.COCO_PLANKS);
            event.accept(EmoBlocks.COCO_STAIRS);
            event.accept(EmoBlocks.COCO_SLAB);
            event.accept(EmoBlocks.COCO_FENCE);
            event.accept(EmoBlocks.COCO_FENCE_GATE);
            event.accept(EmoBlocks.COCO_DOOR);
            event.accept(EmoBlocks.COCO_TRAPDOOR);
            event.accept(EmoBlocks.COCO_PRESSURE_PLATE);
            event.accept(EmoBlocks.COCO_BUTTON);

            event.accept(EmoBlocks.DREAM_LOG);
            event.accept(EmoBlocks.DREAM_WOOD);
            event.accept(EmoBlocks.STRIPPED_DREAM_LOG);
            event.accept(EmoBlocks.STRIPPED_DREAM_WOOD);
            event.accept(EmoBlocks.DREAM_PLANKS);
            event.accept(EmoBlocks.DREAM_STAIRS);
            event.accept(EmoBlocks.DREAM_SLAB);
            event.accept(EmoBlocks.DREAM_FENCE);
            event.accept(EmoBlocks.DREAM_FENCE_GATE);
            event.accept(EmoBlocks.DREAM_DOOR);
            event.accept(EmoBlocks.DREAM_TRAPDOOR);
            event.accept(EmoBlocks.DREAM_PRESSURE_PLATE);
            event.accept(EmoBlocks.DREAM_BUTTON);

            event.accept(EmoBlocks.VERTICAL_PEAR_PLANKS);
            event.accept(EmoBlocks.VERTICAL_ORANGE_PLANKS);
            event.accept(EmoBlocks.VERTICAL_ATLAS_PLANKS);
            event.accept(EmoBlocks.VERTICAL_PINE_PLANKS);
            event.accept(EmoBlocks.VERTICAL_COCO_PLANKS);
            event.accept(EmoBlocks.VERTICAL_DREAM_PLANKS);

            event.accept(EmoBlocks.VERTICAL_OAK_PLANKS);
            event.accept(EmoBlocks.VERTICAL_SPRUCE_PLANKS);
            event.accept(EmoBlocks.VERTICAL_BIRCH_PLANKS);
            event.accept(EmoBlocks.VERTICAL_JUNGLE_PLANKS);
            event.accept(EmoBlocks.VERTICAL_ACACIA_PLANKS);
            event.accept(EmoBlocks.VERTICAL_CHERRY_PLANKS);
            event.accept(EmoBlocks.VERTICAL_DARK_OAK_PLANKS);
            event.accept(EmoBlocks.VERTICAL_PALE_OAK_PLANKS);
            event.accept(EmoBlocks.VERTICAL_MANGROVE_PLANKS);
            event.accept(EmoBlocks.VERTICAL_BAMBOO_PLANKS);
            event.accept(EmoBlocks.VERTICAL_CRIMSON_PLANKS);
            event.accept(EmoBlocks.VERTICAL_WARPED_PLANKS);
        } else if (key==CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(EmoBlocks.PEAR_SIGN);
            event.accept(EmoBlocks.PEAR_HANGING_SIGN);

            event.accept(EmoBlocks.ORANGE_SIGN);
            event.accept(EmoBlocks.ORANGE_HANGING_SIGN);

            event.accept(EmoBlocks.ATLAS_SIGN);
            event.accept(EmoBlocks.ATLAS_HANGING_SIGN);

            event.accept(EmoBlocks.PINE_SIGN);
            event.accept(EmoBlocks.PINE_HANGING_SIGN);

            event.accept(EmoBlocks.COCO_SIGN);
            event.accept(EmoBlocks.COCO_HANGING_SIGN);

            event.accept(EmoBlocks.DREAM_SIGN);
            event.accept(EmoBlocks.DREAM_HANGING_SIGN);
        } else if (key==CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(EmoItems.PEAR_BOAT);
            event.accept(EmoItems.PEAR_CHEST_BOAT);

            event.accept(EmoItems.ORANGE_BOAT);
            event.accept(EmoItems.ORANGE_CHEST_BOAT);

            event.accept(EmoItems.ATLAS_BOAT);
            event.accept(EmoItems.ATLAS_CHEST_BOAT);

            event.accept(EmoItems.PINE_BOAT);
            event.accept(EmoItems.PINE_CHEST_BOAT);

            event.accept(EmoItems.COCO_BOAT);
            event.accept(EmoItems.COCO_CHEST_BOAT);

            event.accept(EmoItems.DREAM_BOAT);
            event.accept(EmoItems.DREAM_CHEST_BOAT);

            event.accept(EmoItems.BUTTERFLY_NET_WHITE);
            event.accept(EmoItems.BUTTERFLY_NET_ORANGE);
            event.accept(EmoItems.BUTTERFLY_NET_MAGENTA);
            event.accept(EmoItems.BUTTERFLY_NET_LIGHT_BLUE);
            event.accept(EmoItems.BUTTERFLY_NET_YELLOW);
            event.accept(EmoItems.BUTTERFLY_NET_LIME);
            event.accept(EmoItems.BUTTERFLY_NET_PINK);
            event.accept(EmoItems.BUTTERFLY_NET_GRAY);
            event.accept(EmoItems.BUTTERFLY_NET_LIGHT_GRAY);
            event.accept(EmoItems.BUTTERFLY_NET_CYAN);
            event.accept(EmoItems.BUTTERFLY_NET_PURPLE);
            event.accept(EmoItems.BUTTERFLY_NET_BLUE);
            event.accept(EmoItems.BUTTERFLY_NET_BROWN);
            event.accept(EmoItems.BUTTERFLY_NET_GREEN);
            event.accept(EmoItems.BUTTERFLY_NET_RED);
            event.accept(EmoItems.BUTTERFLY_NET_BLACK);
        } else if (key==CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(EmoItems.BLACKCURRANT);
            event.accept(EmoItems.BLUEBERRY);
            event.accept(EmoItems.DREAMCURRANT);
            event.accept(EmoItems.STRAWBERRY);
            event.accept(EmoItems.PEAR);
            event.accept(EmoItems.CHERRY);
            event.accept(EmoItems.ORANGE);
            event.accept(EmoItems.HALF_HAM);
            event.accept(EmoItems.HAM);
            event.accept(EmoItems.COOKED_HALF_HAM);
            event.accept(EmoItems.COOKED_HAM);
        } else if (key==CreativeModeTabs.SPAWN_EGGS) {
            event.accept(EmoItems.BUTTERFLY_BLUE);
            event.accept(EmoItems.BUTTERFLY_BROWN);
            event.accept(EmoItems.BUTTERFLY_GREEN);
            event.accept(EmoItems.BUTTERFLY_PINK);
            event.accept(EmoItems.BUTTERFLY_RED);
            event.accept(EmoItems.BUTTERFLY_YELLOW);
        }
    }

    @SubscribeEvent
    public static void onRegisterSpecialBlockModelRenderer(RegisterSpecialBlockModelRendererEvent event) {
        // PEAR
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

        // ORANGE
        event.register(
                EmoBlocks.ORANGE_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.ORANGE)
        );
        event.register(
                EmoBlocks.ORANGE_WALL_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.ORANGE)
        );
        event.register(
                EmoBlocks.ORANGE_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.ORANGE)
        );
        event.register(
                EmoBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.ORANGE)
        );

        // ATLAS
        event.register(
                EmoBlocks.ATLAS_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.ATLAS)
        );
        event.register(
                EmoBlocks.ATLAS_WALL_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.ATLAS)
        );
        event.register(
                EmoBlocks.ATLAS_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.ATLAS)
        );
        event.register(
                EmoBlocks.ATLAS_WALL_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.ATLAS)
        );

        // PINE
        event.register(
                EmoBlocks.PINE_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.PINE)
        );
        event.register(
                EmoBlocks.PINE_WALL_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.PINE)
        );
        event.register(
                EmoBlocks.PINE_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.PINE)
        );
        event.register(
                EmoBlocks.PINE_WALL_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.PINE)
        );

        // COCO
        event.register(
                EmoBlocks.COCO_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.COCO)
        );
        event.register(
                EmoBlocks.COCO_WALL_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.COCO)
        );
        event.register(
                EmoBlocks.COCO_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.COCO)
        );
        event.register(
                EmoBlocks.COCO_WALL_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.COCO)
        );

        // DREAM
        event.register(
                EmoBlocks.DREAM_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.DREAM)
        );
        event.register(
                EmoBlocks.DREAM_WALL_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.DREAM)
        );
        event.register(
                EmoBlocks.DREAM_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.DREAM)
        );
        event.register(
                EmoBlocks.DREAM_WALL_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.DREAM)
        );
    }

    @SubscribeEvent
    public static void onRegisterColorResolver(RegisterColorHandlersEvent.ColorResolvers event) {
        event.register(EmoColor.EMO_GRASS_COLOR_RESOLVER);
    }

    @SubscribeEvent
    public static void onRegisterColorHandlersEvent(RegisterColorHandlersEvent.Block event) {
        event.register(getColor(0x6A9E3F, 0.75F), EmoBlocks.PEAR_LEAVES.get(), EmoBlocks.PEAR_SAPLING.get());
        event.register(getColor(0x45a14a, 0.75F), EmoBlocks.ORANGE_LEAVES.get(), EmoBlocks.ORANGE_SAPLING.get());
        event.register(getColor(0x4496c4, 0.75F), EmoBlocks.ATLAS_LEAVES.get(), EmoBlocks.ATLAS_SAPLING.get());
        event.register(getColor(0x2E5B2C, 0.75F), EmoBlocks.PINE_LEAVES.get(), EmoBlocks.PINE_SAPLING.get());
        event.register(getColor(0x6DB67E, 0.75F), EmoBlocks.COCO_LEAVES.get(), EmoBlocks.COCO_SAPLING.get());
        event.register(((state, level, pos, tintIndex) -> {
            return 0x42ab71;
        }), EmoBlocks.DREAM_LEAVES.get(), EmoBlocks.DREAM_SAPLING.get());

        BlockColor emoGrass = ((state, world, pos, tintIndex) -> {
            if (world!=null && pos!=null) {
                return EmoColor.getHeightGrassColor(world, pos);
            }

            return GrassColor.getDefaultColor();
        });

        event.register(emoGrass, Blocks.GRASS_BLOCK, Blocks.TALL_GRASS, Blocks.SHORT_GRASS);
    }

    protected static BlockColor getColor(int base, float ratio) {
        return (state, world, pos, tintIndex) -> {
            if (world!=null && pos!=null) {
                int biomeColor = BiomeColors.getAverageFoliageColor(world, pos);
                return blendColors(base, biomeColor, ratio);
            }

            return base;
        };
    }
}
