package fr.emotion.emomodcore;


import com.mojang.logging.LogUtils;
import fr.emotion.emomodcore.core.PlaceBlockBehavior;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(EmoMain.MODID)
public class EmoMain {
    public static final String MODID = "emomodcore";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EmoMain(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        //SEED
        DispenserBlock.registerBehavior(Items.WHEAT_SEEDS, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.PUMPKIN_SEEDS, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.MELON_SEEDS, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.BEETROOT_SEEDS, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.CARROT, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.POTATO, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.SWEET_BERRIES, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.TORCHFLOWER_SEEDS, new PlaceBlockBehavior());

        //SAPLING
        DispenserBlock.registerBehavior(Items.OAK_SAPLING, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.SPRUCE_SAPLING, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.BIRCH_SAPLING, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.JUNGLE_SAPLING, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.ACACIA_SAPLING, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.CHERRY_SAPLING, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.DARK_OAK_SAPLING, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.PALE_OAK_SAPLING, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.MANGROVE_PROPAGULE, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.BAMBOO, new PlaceBlockBehavior());

        //CLASSIC
        DispenserBlock.registerBehavior(Items.SUGAR_CANE, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.CACTUS, new PlaceBlockBehavior());

        //AQUATIC
        DispenserBlock.registerBehavior(Items.SEA_PICKLE, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.KELP, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.SEAGRASS, new PlaceBlockBehavior());

        //MUSHROOM
        DispenserBlock.registerBehavior(Items.BROWN_MUSHROOM, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.RED_MUSHROOM, new PlaceBlockBehavior());

        //NETHER
        DispenserBlock.registerBehavior(Items.NETHER_WART, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.CRIMSON_FUNGUS, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.WARPED_FUNGUS, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.CRIMSON_ROOTS, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.WARPED_ROOTS, new PlaceBlockBehavior());

        //MISCELLANEOUS
        DispenserBlock.registerBehavior(Items.CHORUS_FLOWER, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.SMALL_DRIPLEAF, new PlaceBlockBehavior());
        DispenserBlock.registerBehavior(Items.BIG_DRIPLEAF, new PlaceBlockBehavior());
    }
}
