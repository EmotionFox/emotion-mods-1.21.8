package fr.emotion.emomodworld;

import com.mojang.logging.LogUtils;
import fr.emotion.emomodcore.core.InteractBehavior;
import fr.emotion.emomodcore.core.PlaceBlockBehavior;
import fr.emotion.emomodworld.entities.beetle.Beetle;
import fr.emotion.emomodworld.entities.boar.Boar;
import fr.emotion.emomodworld.entities.butterfly.Butterfly;
import fr.emotion.emomodworld.entities.jumpingSpider.JumpingSpider;
import fr.emotion.emomodworld.entities.mouse.Mouse;
import fr.emotion.emomodworld.init.*;
import fr.emotion.emomodworld.world.biome.ModTerrablender;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import org.slf4j.Logger;

@Mod(EmoMain.MODID)
public class EmoMain {
    public static final String MODID = "emomodworld";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EmoMain(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::onRegisterCapabilities);
        modEventBus.addListener(this::onRegisterSpawnPlacements);

        EmoItems.init(modEventBus);
        EmoBlocks.init(modEventBus);
        EmoMapCodec.init(modEventBus);
        ModTerrablender.registerBiomes();
        EmoEntityType.init(modEventBus);
        EmoBlockType.init(modEventBus);
        EmoTrunkPlacerType.init(modEventBus);
        EmoFoliagePlacerType.init(modEventBus);
        EmoPlacementModifierType.init(modEventBus);
        EmoFeature.init(modEventBus);
        EmoTreeDecoratorType.init(modEventBus);
        EmoDataComponentType.init(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makeRules());

        DispenserBlock.registerBehavior(EmoBlocks.PEAR_SAPLING.get().asItem(), new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(EmoBlocks.ORANGE_SAPLING.get().asItem(), new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(EmoBlocks.ATLAS_SAPLING.get().asItem(), new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(EmoBlocks.PINE_SAPLING.get().asItem(), new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(EmoBlocks.COCO_SAPLING.get().asItem(), new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(EmoBlocks.DREAM_SAPLING.get().asItem(), new PlaceBlockBehavior());

        DispenserBlock.registerBehavior(EmoBlocks.BUSH_BLACKCURRANT.get().asItem(), new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(EmoBlocks.BUSH_BLUEBERRY.get().asItem(), new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(EmoBlocks.BUSH_DREAMCURRANT.get().asItem(), new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(EmoBlocks.BUSH_STRAWBERRY.get().asItem(), new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(EmoBlocks.BUSH_SWEET.get().asItem(), new PlaceBlockBehavior());

        DispenserBlock.registerBehavior(EmoBlocks.BLUE_MUSHROOM.get().asItem(), new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(EmoBlocks.GREEN_MUSHROOM.get().asItem(), new PlaceBlockBehavior());

        DispenserBlock.registerBehavior(EmoItems.PEAR_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.PEAR_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.ORANGE_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.ORANGE_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.ATLAS_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.ATLAS_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.PINE_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.PINE_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.COCO_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.COCO_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.DREAM_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.DREAM_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.PEAR_CHEST_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.PEAR_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.ORANGE_CHEST_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.ORANGE_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.ATLAS_CHEST_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.ATLAS_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.PINE_CHEST_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.PINE_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.COCO_CHEST_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.COCO_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(EmoItems.DREAM_CHEST_BOAT.get(), new BoatDispenseItemBehavior(EmoEntityType.DREAM_CHEST_BOAT.get()));

        DispenseItemBehavior waterBucketBehavior = DispenserBlock.DISPENSER_REGISTRY.get(Items.WATER_BUCKET);
        DispenserBlock.registerBehavior(Items.WATER_BUCKET, new InteractBehavior(waterBucketBehavior));

        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.FLOWER_KITTY.getId(),
                    EmoBlocks.POTTED_FLOWER_KITTY
            );
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.FLOWER_NOX.getId(),
                    EmoBlocks.POTTED_FLOWER_NOX
            );
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.FLOWER_DELY.getId(),
                    EmoBlocks.POTTED_FLOWER_DELY
            );
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.FLOWER_GNON.getId(),
                    EmoBlocks.POTTED_FLOWER_GNON
            );
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.FLOWER_THORNY.getId(),
                    EmoBlocks.POTTED_FLOWER_THORNY
            );
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.FLOWER_CENTUS.getId(),
                    EmoBlocks.POTTED_FLOWER_CENTUS
            );
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.FLOWER_NEBULA.getId(),
                    EmoBlocks.POTTED_FLOWER_NEBULA
            );
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.FLOWER_NARCOTA.getId(),
                    EmoBlocks.POTTED_FLOWER_NARCOTA
            );
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.PEAR_SAPLING.getId(),
                    EmoBlocks.POTTED_PEAR_SAPLING
            );
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.BLUE_MUSHROOM.getId(),
                    EmoBlocks.POTTED_BLUE_MUSHROOM
            );
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    EmoBlocks.GREEN_MUSHROOM.getId(),
                    EmoBlocks.POTTED_GREEN_MUSHROOM
            );

            // PEAR
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PEAR_PLANKS.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PEAR_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_PEAR_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PEAR_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_PEAR_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PEAR_SLAB.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PEAR_FENCE_GATE.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PEAR_FENCE.get(), 5, 20);

            DispenserBlock.registerBehavior(EmoItems.PEAR_BOAT, new BoatDispenseItemBehavior(EmoEntityType.PEAR_BOAT.get()));
            DispenserBlock.registerBehavior(EmoItems.PEAR_CHEST_BOAT, new BoatDispenseItemBehavior(EmoEntityType.PEAR_CHEST_BOAT.get()));

            // ORANGE
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ORANGE_PLANKS.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ORANGE_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_ORANGE_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ORANGE_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_ORANGE_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ORANGE_SLAB.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ORANGE_FENCE_GATE.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ORANGE_FENCE.get(), 5, 20);

            DispenserBlock.registerBehavior(EmoItems.ORANGE_BOAT, new BoatDispenseItemBehavior(EmoEntityType.ORANGE_BOAT.get()));
            DispenserBlock.registerBehavior(EmoItems.ORANGE_CHEST_BOAT, new BoatDispenseItemBehavior(EmoEntityType.ORANGE_CHEST_BOAT.get()));

            // ATLAS
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ATLAS_PLANKS.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ATLAS_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_ATLAS_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ATLAS_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_ATLAS_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ATLAS_SLAB.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ATLAS_FENCE_GATE.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.ATLAS_FENCE.get(), 5, 20);

            DispenserBlock.registerBehavior(EmoItems.ATLAS_BOAT, new BoatDispenseItemBehavior(EmoEntityType.ATLAS_BOAT.get()));
            DispenserBlock.registerBehavior(EmoItems.ATLAS_CHEST_BOAT, new BoatDispenseItemBehavior(EmoEntityType.ATLAS_CHEST_BOAT.get()));

            // PINE
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PINE_PLANKS.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PINE_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_PINE_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PINE_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_PINE_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PINE_SLAB.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PINE_FENCE_GATE.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.PINE_FENCE.get(), 5, 20);

            DispenserBlock.registerBehavior(EmoItems.PINE_BOAT, new BoatDispenseItemBehavior(EmoEntityType.PINE_BOAT.get()));
            DispenserBlock.registerBehavior(EmoItems.PINE_CHEST_BOAT, new BoatDispenseItemBehavior(EmoEntityType.PINE_CHEST_BOAT.get()));

            // COCO
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.COCO_PLANKS.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.COCO_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_COCO_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.COCO_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_COCO_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.COCO_SLAB.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.COCO_FENCE_GATE.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.COCO_FENCE.get(), 5, 20);

            DispenserBlock.registerBehavior(EmoItems.COCO_BOAT, new BoatDispenseItemBehavior(EmoEntityType.COCO_BOAT.get()));
            DispenserBlock.registerBehavior(EmoItems.COCO_CHEST_BOAT, new BoatDispenseItemBehavior(EmoEntityType.COCO_CHEST_BOAT.get()));

            // DREAM
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.DREAM_PLANKS.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.DREAM_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_DREAM_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.DREAM_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.STRIPPED_DREAM_WOOD.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.DREAM_SLAB.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.DREAM_FENCE_GATE.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.DREAM_FENCE.get(), 5, 20);

            DispenserBlock.registerBehavior(EmoItems.DREAM_BOAT, new BoatDispenseItemBehavior(EmoEntityType.DREAM_BOAT.get()));
            DispenserBlock.registerBehavior(EmoItems.DREAM_CHEST_BOAT, new BoatDispenseItemBehavior(EmoEntityType.DREAM_CHEST_BOAT.get()));
        });
    }

    private void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        // PEAR
        event.registerEntity(Capabilities.ItemHandler.ENTITY, EmoEntityType.PEAR_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));
        event.registerEntity(Capabilities.ItemHandler.ENTITY_AUTOMATION, EmoEntityType.PEAR_CHEST_BOAT.get(), ((entity, ctx) -> new InvWrapper(entity)));

        // ORANGE
        event.registerEntity(Capabilities.ItemHandler.ENTITY, EmoEntityType.ORANGE_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));
        event.registerEntity(Capabilities.ItemHandler.ENTITY_AUTOMATION, EmoEntityType.ORANGE_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));

        // ATLAS
        event.registerEntity(Capabilities.ItemHandler.ENTITY, EmoEntityType.ATLAS_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));
        event.registerEntity(Capabilities.ItemHandler.ENTITY_AUTOMATION, EmoEntityType.ATLAS_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));

        // PINE
        event.registerEntity(Capabilities.ItemHandler.ENTITY, EmoEntityType.PINE_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));
        event.registerEntity(Capabilities.ItemHandler.ENTITY_AUTOMATION, EmoEntityType.PINE_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));

        // COCO
        event.registerEntity(Capabilities.ItemHandler.ENTITY, EmoEntityType.COCO_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));
        event.registerEntity(Capabilities.ItemHandler.ENTITY_AUTOMATION, EmoEntityType.COCO_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));

        // DREAM
        event.registerEntity(Capabilities.ItemHandler.ENTITY, EmoEntityType.DREAM_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));
        event.registerEntity(Capabilities.ItemHandler.ENTITY_AUTOMATION, EmoEntityType.DREAM_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));
    }

    private void onRegisterSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(EmoEntityType.BUTTERFLY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Butterfly::checkButterflySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(EmoEntityType.BEETLE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Beetle::checkBeetleSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(EmoEntityType.BOAR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Boar::checkBoarSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(EmoEntityType.MOUSE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mouse::checkMouseSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(EmoEntityType.JUMPING_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JumpingSpider::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}
