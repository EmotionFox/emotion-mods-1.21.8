package fr.emotion.emomodore.datagen;

import fr.emotion.emomodore.EmoMain;
import fr.emotion.emomodore.init.EmoBlocks;
import fr.emotion.emomodore.init.EmoItems;
import fr.emotion.emomodore.recipes.FadingBlockItemRecipe;
import fr.emotion.emomodore.recipes.FadingBlockRecipe;
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

        oreBlasting(List.of(EmoBlocks.FOSSIL_ORE.get()), RecipeCategory.MISC, EmoItems.FOSSIL, 0.7F, 100, "fossil");
        oreSmelting(List.of(EmoBlocks.FOSSIL_ORE.get()), RecipeCategory.MISC, EmoItems.FOSSIL, 0.7F, 200, "fossil");

        oreBlasting(List.of(EmoBlocks.PURPURA_ORE.get(), EmoBlocks.DEEPSLATE_PURPURA_ORE.get()), RecipeCategory.MISC, EmoItems.PURPURA_SHARD, 1.0F, 100, "purpura");
        oreSmelting(List.of(EmoBlocks.PURPURA_ORE.get(), EmoBlocks.DEEPSLATE_PURPURA_ORE.get()), RecipeCategory.MISC, EmoItems.PURPURA_SHARD, 1.0F, 200, "purpura");

        oreBlasting(List.of(EmoBlocks.VIRIDIS_ORE.get()), RecipeCategory.MISC, EmoBlocks.VIRIDIS_CRYSTAL, 1.0F, 100, "viridis");
        oreSmelting(List.of(EmoBlocks.VIRIDIS_ORE.get()), RecipeCategory.MISC, EmoBlocks.VIRIDIS_CRYSTAL, 1.0F, 200, "viridis");

        oreBlasting(List.of(EmoBlocks.NETHER_LUME_ORE.get()), RecipeCategory.MISC, EmoItems.LUME_STONE, 1.0F, 100, "lume");
        oreSmelting(List.of(EmoBlocks.NETHER_LUME_ORE.get()), RecipeCategory.MISC, EmoItems.LUME_STONE, 1.0F, 200, "lume");

        shaped(RecipeCategory.BUILDING_BLOCKS, EmoBlocks.FOSSIL_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', EmoItems.FOSSIL)
                .unlockedBy("has_fossil", has(EmoItems.FOSSIL)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, EmoItems.FOSSIL, 9)
                .requires(EmoBlocks.FOSSIL_BLOCK)
                .unlockedBy("has_fossil", has(EmoItems.FOSSIL)).save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, EmoBlocks.PURPURA_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', EmoItems.PURPURA_SHARD)
                .unlockedBy("has_purpura", has(EmoItems.PURPURA_SHARD)).save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, EmoItems.PURPURA_SHARD, 9)
                .requires(EmoBlocks.PURPURA_BLOCK)
                .unlockedBy("has_purpura", has(EmoItems.PURPURA_SHARD)).save(output);

        shaped(RecipeCategory.MISC, Items.TORCH, 8)
                .pattern("#")
                .pattern("X")
                .define('#', EmoItems.LUME_STONE)
                .define('X', Items.STICK)
                .unlockedBy("has_lume", has(EmoItems.LUME_STONE)).save(output, "lume_torch");

        SpecialRecipeBuilder.special(FadingBlockRecipe::new).save(this.output, "fading_block");
        SpecialRecipeBuilder.special(FadingBlockItemRecipe::new).save(this.output, "fading_block_item");
    }

    protected void buildTools() {
        // Purpura
        shaped(RecipeCategory.COMBAT, EmoItems.PURPURA_SWORD.get())
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .define('X', EmoItems.PURPURA_SHARD)
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_purpura", has(EmoItems.PURPURA_SHARD)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.PURPURA_SHOVEL.get())
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .define('X', EmoItems.PURPURA_SHARD)
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_purpura", has(EmoItems.PURPURA_SHARD)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.PURPURA_PICKAXE.get())
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .define('X', EmoItems.PURPURA_SHARD)
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_purpura", has(EmoItems.PURPURA_SHARD)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.PURPURA_AXE.get())
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .define('X', EmoItems.PURPURA_SHARD)
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_purpura", has(EmoItems.PURPURA_SHARD)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.PURPURA_HOE.get())
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .define('X', EmoItems.PURPURA_SHARD)
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_purpura", has(EmoItems.PURPURA_SHARD)).save(output);

        // Fossil
        shaped(RecipeCategory.COMBAT, EmoItems.FOSSIL_SWORD.get())
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .define('X', EmoItems.FOSSIL)
                .define('#', Items.STICK)
                .unlockedBy("has_fossil", has(EmoItems.FOSSIL)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.FOSSIL_SHOVEL.get())
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .define('X', EmoItems.FOSSIL)
                .define('#', Items.STICK)
                .unlockedBy("has_fossil", has(EmoItems.FOSSIL)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.FOSSIL_PICKAXE.get())
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .define('X', EmoItems.FOSSIL)
                .define('#', Items.STICK)
                .unlockedBy("has_fossil", has(EmoItems.FOSSIL)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.FOSSIL_AXE.get())
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .define('X', EmoItems.FOSSIL)
                .define('#', Items.STICK)
                .unlockedBy("has_fossil", has(EmoItems.FOSSIL)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.FOSSIL_HOE.get())
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .define('X', EmoItems.FOSSIL)
                .define('#', Items.STICK)
                .unlockedBy("has_fossil", has(EmoItems.FOSSIL)).save(output);
    }

    protected void buildArmors() {
        shaped(RecipeCategory.TOOLS, EmoItems.VIRIDIS_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', EmoBlocks.VIRIDIS_CRYSTAL)
                .unlockedBy("has_viridis", has(EmoBlocks.VIRIDIS_BLOCK)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.VIRIDIS_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', EmoBlocks.VIRIDIS_CRYSTAL)
                .unlockedBy("has_viridis", has(EmoBlocks.VIRIDIS_BLOCK)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.VIRIDIS_LEGGINGS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', EmoBlocks.VIRIDIS_CRYSTAL)
                .unlockedBy("has_viridis", has(EmoBlocks.VIRIDIS_BLOCK)).save(output);

        shaped(RecipeCategory.TOOLS, EmoItems.VIRIDIS_BOOTS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', EmoBlocks.VIRIDIS_CRYSTAL)
                .unlockedBy("has_viridis", has(EmoBlocks.VIRIDIS_BLOCK)).save(output);
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
            return EmoMain.MODID + " recipes";
        }
    }
}
