package fr.emotion.emomodore.init;

import fr.emotion.emomodore.EmoMain;
import fr.emotion.emomodore.block.FadingBlock;
import fr.emotion.emomodore.block.LumeOreFadingBlock;
import fr.emotion.emomodore.block.ViridisCrystalFadingBlock;
import fr.emotion.emomodore.item.FadedBlockItem;
import fr.emotion.emomodore.item.LumeBlockItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.Constructor;
import java.util.function.Function;

public class EmoBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmoMain.MODID);

    public static final DeferredBlock<Block> FOSSIL_ORE = addBlock("fossil_ore", (props) -> new DropExperienceBlock(UniformInt.of(0, 2), props.mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FOSSIL_BLOCK = addBlock("fossil_block", (props) -> new Block(props.mapColor(MapColor.STONE).strength(7.0F, 14.0F).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PURPURA_ORE = addBlock("purpura_ore", (props) -> new DropExperienceBlock(UniformInt.of(3, 7), props.mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(9.0F, 10F)));
    public static final DeferredBlock<Block> DEEPSLATE_PURPURA_ORE = addBlock("deepslate_purpura_ore", (props) -> new DropExperienceBlock(UniformInt.of(3, 7), props.mapColor(MapColor.DEEPSLATE).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> PURPURA_BLOCK = addBlock("purpura_block", (props) -> new Block(props.mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(7.0F, 14.0F).sound(SoundType.METAL)));

    public static final DeferredBlock<Block> VIRIDIS_ORE = addBlock("viridis_ore", (props) -> new DropExperienceBlock(UniformInt.of(3, 7), props.mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(5F, 6F)) {
        @Override
        public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, ItemStack toolStack, boolean willHarvest, FluidState fluid) {
            if (level.isClientSide()) {
                return level.setBlock(pos, fluid.createLegacyBlock(), 11);
            } else {
                return level.setBlockAndUpdate(pos, VIRIDIS_CRYSTAL.get().defaultBlockState());
            }
        }
    });

    public static final DeferredBlock<Block> VIRIDIS_CRYSTAL = addBlock("viridis_crystal", (props) -> new ViridisCrystalFadingBlock(props.mapColor(MapColor.STONE).forceSolidOn().noOcclusion().requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER).strength(7F, 14.0F).lightLevel(state -> 5)), FadedBlockItem.class);
    public static final DeferredBlock<Block> VIRIDIS_BLOCK = addBlock("viridis_block", (props) -> new FadingBlock(props.mapColor(MapColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(7.0F, 14.0F).sound(SoundType.METAL)), LumeBlockItem.class);

    public static final DeferredBlock<Block> NETHER_LUME_ORE = addBlock("nether_lume_ore", (props) -> new LumeOreFadingBlock(props.mapColor(MapColor.NETHER).requiresCorrectToolForDrops().strength(4.0F, 4.0F).sound(SoundType.NETHER_ORE).lightLevel(state -> 8)), FadedBlockItem.class);
    public static final DeferredBlock<Block> LUME_BLOCK = addBlock("lume_block", (props) -> new FadingBlock(props.mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(7.0F, 14.0F).sound(SoundType.METAL).lightLevel(state -> 8)), LumeBlockItem.class);

    private static <T extends Block> DeferredBlock<T> addBlock(String name, Function<BlockBehaviour.Properties, T> func) {
        DeferredBlock<T> returnBlock = BLOCKS.registerBlock(name, func);
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    private static <T extends Block, I extends BlockItem> DeferredBlock<T> addBlock(String name, Function<BlockBehaviour.Properties, T> func, Class<I> blockItemClass) {
        DeferredBlock<T> returnBlock = BLOCKS.registerBlock(name, func);
        registerBlockItem(name, returnBlock, blockItemClass);
        return returnBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        EmoItems.ITEMS.registerSimpleBlockItem(name, block);
    }

    public static void init(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block, I extends BlockItem> void registerBlockItem(String name, DeferredBlock<T> block, Class<I> blockItemClass) {
        EmoItems.ITEMS.register(name, key -> {
            Item.Properties properties = new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, key))
                    .useBlockDescriptionPrefix();

            try {
                Constructor<I> constructor = blockItemClass.getConstructor(Block.class, Item.Properties.class);
                return constructor.newInstance(block.get(), properties);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Could not instanciate BlockItem class: " + blockItemClass.getName(), e);
            }
        });
    }
}
