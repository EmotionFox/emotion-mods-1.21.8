package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
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

    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> PEAR_CHEST_BOAT = ENTITY_TYPE.register(
            "pear_chest_boat",
            resourceLocation -> EntityType.Builder.of(boatFactory(EmoItems.PEAR_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation))
    );

    public static void init(IEventBus eventBus) {
        ENTITY_TYPE.register(eventBus);
    }

    private static EntityType.EntityFactory<Boat> boatFactory(Supplier<Item> boatItemGetter) {
        return (p_375558_, p_375559_) -> new Boat(p_375558_, p_375559_, boatItemGetter);
    }
}
