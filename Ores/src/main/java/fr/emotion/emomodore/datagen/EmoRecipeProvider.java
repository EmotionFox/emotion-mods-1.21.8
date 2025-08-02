package fr.emotion.emomodore.datagen;

import fr.emotion.emomodore.MainRegistry;
import fr.emotion.emomodore.init.BlockRegistry;
import fr.emotion.emomodore.init.ItemRegistry;
import fr.emotion.emomodore.recipes.LumeBlockRecipe;
import fr.emotion.emomodore.recipes.LumeRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EmoRecipeProvider extends RecipeProvider {
    protected EmoRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    @Override
    protected void buildRecipes() {
        buildTools();
        buildArmors();

        oreBlasting(List.of(BlockRegistry.FOSSIL_ORE.get()), RecipeCategory.MISC, ItemRegistry.FOSSIL, 0.7F, 100, "fossil");
        oreSmelting(List.of(BlockRegistry.FOSSIL_ORE.get()), RecipeCategory.MISC, ItemRegistry.FOSSIL, 0.7F, 200, "fossil");

        oreBlasting(List.of(BlockRegistry.PURPURA_ORE.get(), BlockRegistry.DEEPSLATE_PURPURA_ORE.get()), RecipeCategory.MISC, ItemRegistry.PURPURA_SHARD, 1.0F, 100, "purpura");
        oreSmelting(List.of(BlockRegistry.PURPURA_ORE.get(), BlockRegistry.DEEPSLATE_PURPURA_ORE.get()), RecipeCategory.MISC, ItemRegistry.PURPURA_SHARD, 1.0F, 200, "purpura");

        oreBlasting(List.of(BlockRegistry.VIRIDIS_ORE.get()), RecipeCategory.MISC, BlockRegistry.VIRIDIS_CRYSTAL, 1.0F, 100, "viridis");
        oreSmelting(List.of(BlockRegistry.VIRIDIS_ORE.get()), RecipeCategory.MISC, BlockRegistry.VIRIDIS_CRYSTAL, 1.0F, 200, "viridis");

        oreBlasting(List.of(BlockRegistry.NETHER_LUME_ORE.get()), RecipeCategory.MISC, ItemRegistry.LUME_STONE, 1.0F, 100, "lume");
        oreSmelting(List.of(BlockRegistry.NETHER_LUME_ORE.get()), RecipeCategory.MISC, ItemRegistry.LUME_STONE, 1.0F, 200, "lume");

        shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.FOSSIL_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ItemRegistry.FOSSIL)
                .unlockedBy("has_fossil", has(ItemRegistry.FOSSIL)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.FOSSIL, 9)
                .requires(BlockRegistry.FOSSIL_BLOCK)
                .unlockedBy("has_fossil", has(ItemRegistry.FOSSIL)).save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.PURPURA_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ItemRegistry.PURPURA_SHARD)
                .unlockedBy("has_purpura", has(ItemRegistry.PURPURA_SHARD)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.PURPURA_SHARD, 9)
                .requires(BlockRegistry.PURPURA_BLOCK)
                .unlockedBy("has_purpura", has(ItemRegistry.PURPURA_SHARD)).save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.VIRIDIS_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', BlockRegistry.VIRIDIS_CRYSTAL)
                .unlockedBy("has_viridis", has(BlockRegistry.VIRIDIS_CRYSTAL)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.VIRIDIS_CRYSTAL, 9)
                .requires(BlockRegistry.VIRIDIS_BLOCK)
                .unlockedBy("has_viridis", has(BlockRegistry.VIRIDIS_CRYSTAL)).save(output);

        shaped(RecipeCategory.MISC, Items.TORCH, 8)
                .pattern("#")
                .pattern("X")
                .define('#', ItemRegistry.LUME_STONE)
                .define('X', Items.STICK)
                .unlockedBy("has_lume", has(ItemRegistry.LUME_STONE)).save(output, "lume_torch");

        SpecialRecipeBuilder.special(LumeRecipe::new).save(this.output, "lume_block");
        SpecialRecipeBuilder.special(LumeBlockRecipe::new).save(this.output, "lume_stone");
    }

    protected void buildTools() {
        // Purpura
        shaped(RecipeCategory.COMBAT, ItemRegistry.PURPURA_SWORD.get())
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .define('X', ItemRegistry.PURPURA_SHARD)
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_purpura", has(ItemRegistry.PURPURA_SHARD)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.PURPURA_SHOVEL.get())
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .define('X', ItemRegistry.PURPURA_SHARD)
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_purpura", has(ItemRegistry.PURPURA_SHARD)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.PURPURA_PICKAXE.get())
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .define('X', ItemRegistry.PURPURA_SHARD)
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_purpura", has(ItemRegistry.PURPURA_SHARD)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.PURPURA_AXE.get())
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .define('X', ItemRegistry.PURPURA_SHARD)
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_purpura", has(ItemRegistry.PURPURA_SHARD)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.PURPURA_HOE.get())
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .define('X', ItemRegistry.PURPURA_SHARD)
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_purpura", has(ItemRegistry.PURPURA_SHARD)).save(output);

        // Fossil
        shaped(RecipeCategory.COMBAT, ItemRegistry.FOSSIL_SWORD.get())
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .define('X', ItemRegistry.FOSSIL)
                .define('#', Items.STICK)
                .unlockedBy("has_fossil", has(ItemRegistry.FOSSIL)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.FOSSIL_SHOVEL.get())
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .define('X', ItemRegistry.FOSSIL)
                .define('#', Items.STICK)
                .unlockedBy("has_fossil", has(ItemRegistry.FOSSIL)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.FOSSIL_PICKAXE.get())
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .define('X', ItemRegistry.FOSSIL)
                .define('#', Items.STICK)
                .unlockedBy("has_fossil", has(ItemRegistry.FOSSIL)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.FOSSIL_AXE.get())
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .define('X', ItemRegistry.FOSSIL)
                .define('#', Items.STICK)
                .unlockedBy("has_fossil", has(ItemRegistry.FOSSIL)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.FOSSIL_HOE.get())
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .define('X', ItemRegistry.FOSSIL)
                .define('#', Items.STICK)
                .unlockedBy("has_fossil", has(ItemRegistry.FOSSIL)).save(output);
    }

    protected void buildArmors() {
        shaped(RecipeCategory.TOOLS, ItemRegistry.VIRIDIS_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', BlockRegistry.VIRIDIS_CRYSTAL)
                .unlockedBy("has_viridis", has(BlockRegistry.VIRIDIS_BLOCK)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.VIRIDIS_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', BlockRegistry.VIRIDIS_CRYSTAL)
                .unlockedBy("has_viridis", has(BlockRegistry.VIRIDIS_BLOCK)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.VIRIDIS_LEGGINGS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', BlockRegistry.VIRIDIS_CRYSTAL)
                .unlockedBy("has_viridis", has(BlockRegistry.VIRIDIS_BLOCK)).save(output);

        shaped(RecipeCategory.TOOLS, ItemRegistry.VIRIDIS_BOOTS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', BlockRegistry.VIRIDIS_CRYSTAL)
                .unlockedBy("has_viridis", has(BlockRegistry.VIRIDIS_BLOCK)).save(output);
    }

    public static class Runner extends RecipeProvider.Runner {
        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new EmoRecipeProvider(provider, output);
        }

        @Override
        public String getName() {
            return MainRegistry.MODID + " recipes";
        }
    }
}
