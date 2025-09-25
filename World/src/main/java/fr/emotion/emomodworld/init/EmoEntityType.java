package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.entities.beetle.Beetle;
import fr.emotion.emomodworld.entities.boar.Boar;
import fr.emotion.emomodworld.entities.butterfly.Butterfly;
import fr.emotion.emomodworld.entities.mouse.Mouse;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EmoEntityType {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, EmoMain.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> PEAR_BOAT = ENTITY_TYPE.register(
            "pear_boat",
            resourceLocation -> EntityType.Builder.of(boatFactory(EmoItems.PEAR_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> ORANGE_BOAT = ENTITY_TYPE.register(
            "orange_boat",
            resourceLocation -> EntityType.Builder.of(boatFactory(EmoItems.ORANGE_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> ATLAS_BOAT = ENTITY_TYPE.register(
            "atlas_boat",
            resourceLocation -> EntityType.Builder.of(boatFactory(EmoItems.ATLAS_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> PINE_BOAT = ENTITY_TYPE.register(
            "pine_boat",
            resourceLocation -> EntityType.Builder.of(boatFactory(EmoItems.PINE_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> COCO_BOAT = ENTITY_TYPE.register(
            "coco_boat",
            resourceLocation -> EntityType.Builder.of(boatFactory(EmoItems.COCO_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> DREAM_BOAT = ENTITY_TYPE.register(
            "dream_boat",
            resourceLocation -> EntityType.Builder.of(boatFactory(EmoItems.DREAM_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> PEAR_CHEST_BOAT = ENTITY_TYPE.register(
            "pear_chest_boat",
            resourceLocation -> EntityType.Builder.of(chestBoatFactory(EmoItems.PEAR_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> ORANGE_CHEST_BOAT = ENTITY_TYPE.register(
            "orange_chest_boat",
            resourceLocation -> EntityType.Builder.of(chestBoatFactory(EmoItems.ORANGE_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> ATLAS_CHEST_BOAT = ENTITY_TYPE.register(
            "atlas_chest_boat",
            resourceLocation -> EntityType.Builder.of(chestBoatFactory(EmoItems.ATLAS_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> PINE_CHEST_BOAT = ENTITY_TYPE.register(
            "pine_chest_boat",
            resourceLocation -> EntityType.Builder.of(chestBoatFactory(EmoItems.PINE_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> COCO_CHEST_BOAT = ENTITY_TYPE.register(
            "coco_chest_boat",
            resourceLocation -> EntityType.Builder.of(chestBoatFactory(EmoItems.COCO_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> DREAM_CHEST_BOAT = ENTITY_TYPE.register(
            "dream_chest_boat",
            resourceLocation -> EntityType.Builder.of(chestBoatFactory(EmoItems.DREAM_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<Beetle>> BEETLE = ENTITY_TYPE.register(
            "beetle",
            resourceLocation -> EntityType.Builder.of(Beetle::new, MobCategory.CREATURE)
                    .noLootTable()
                    .sized(0.15F, 0.1F)
                    .eyeHeight(0.01F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<Butterfly>> BUTTERFLY = ENTITY_TYPE.register(
            "butterfly",
            resourceLocation -> EntityType.Builder.of(Butterfly::new, MobCategory.AMBIENT)
                    .noLootTable()
                    .sized(0.3F, 0.1F)
                    .eyeHeight(0.025F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<Boar>> BOAR = ENTITY_TYPE.register(
            "boar",
            resourceLocation -> EntityType.Builder.of(Boar::new, MobCategory.MISC)
                    .sized(0.9F, 0.9F)
                    .eyeHeight(0.8F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<Mouse>> MOUSE = ENTITY_TYPE.register(
            "mouse",
            resourceLocation -> EntityType.Builder.of(Mouse::new, MobCategory.AMBIENT)
                    .noLootTable()
                    .sized(0.15F, 0.15F)
                    .eyeHeight(0.01F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static void init(IEventBus eventBus) {
        ENTITY_TYPE.register(eventBus);
    }

    private static EntityType.EntityFactory<Boat> boatFactory(Supplier<Item> boatItemGetter) {
        return (p_375558_, p_375559_) -> new Boat(p_375558_, p_375559_, boatItemGetter);
    }

    private static EntityType.EntityFactory<ChestBoat> chestBoatFactory(Supplier<Item> boatItemGetter) {
        return (p_375555_, p_375556_) -> new ChestBoat(p_375555_, p_375556_, boatItemGetter);
    }
}
