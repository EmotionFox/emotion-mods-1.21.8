package fr.emotion.emomodworld;

import com.mojang.logging.LogUtils;
import fr.emotion.emomodworld.init.*;
import fr.emotion.emomodworld.world.biome.ModTerrablender;
import fr.emotion.emomodworld.world.biome.surface.ModSurfaceRules;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

@Mod(EmoMain.MODID)
public class EmoMain {
    public static final String MODID = "emomodworld";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EmoMain(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::onRegisterCapabilities);

        EmoItems.init(modEventBus);
        EmoBlocks.init(modEventBus);
        EmoBiomeModifier.init(modEventBus);
        ModTerrablender.registerBiomes();
        EmoEntityType.init(modEventBus);
        EmoBlockType.init(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makeRules());

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

            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.DREAM_SHORT_GRASS.get(), 60, 100);
            ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.DREAM_TALL_GRASS.get(), 60, 100);

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
        });
    }

    private void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.registerEntity(Capabilities.ItemHandler.ENTITY, EmoEntityType.PEAR_CHEST_BOAT.get(), (entity, ctx) -> new InvWrapper(entity));
        event.registerEntity(Capabilities.ItemHandler.ENTITY_AUTOMATION, EmoEntityType.PEAR_CHEST_BOAT.get(), ((entity, ctx) -> new InvWrapper(entity)));
    }
}
