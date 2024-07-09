package cutefox.betterenchanting.datagen;

import cutefox.betterenchanting.BetterEnchantingFabric;
import cutefox.betterenchanting.Utils;
import cutefox.betterenchanting.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        BetterEnchantingFabric.LOGGER.info("Generating recipes for : "+ BetterEnchantingFabric.MOD_ID);

        //region ENCHANTMENT INGREDIENTS

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGIC_SHARD_DULL.value(), 1)
                .pattern("IDI")
                .pattern("GAG")
                .pattern("IDI")
                .input('A', Items.AMETHYST_SHARD)
                .input('D', Items.DIAMOND)
                .input('I', ModItems.INFUSED_LAPIS.value())
                .input('G', Items.GHAST_TEAR)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.GHAST_TEAR), conditionsFromItem(Items.GHAST_TEAR))
                .criterion(hasItem(ModItems.INFUSED_LAPIS.value()), conditionsFromItem(ModItems.INFUSED_LAPIS.value()))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.MAGIC_SHARD_DULL.value())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGIC_SHARD_FULL.value(), 1)
                .pattern(" B ")
                .pattern("ESE")
                .pattern("LBL")
                .input('S', ModItems.MAGIC_SHARD_DULL.value())
                .input('B', Items.EXPERIENCE_BOTTLE)
                .input('E', Items.EMERALD)
                .input('L', ModItems.INFUSED_LAPIS.value())
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.EXPERIENCE_BOTTLE), conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                .criterion(hasItem(ModItems.INFUSED_LAPIS.value()), conditionsFromItem(ModItems.INFUSED_LAPIS.value()))
                .criterion(hasItem(ModItems.MAGIC_SHARD_DULL.value()), conditionsFromItem(ModItems.MAGIC_SHARD_DULL.value()))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.MAGIC_SHARD_FULL.value())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INFUSED_LAPIS.value(), 1)
                .input(Items.LAPIS_LAZULI)
                .input(Items.AMETHYST_SHARD)
                .input(Items.QUARTZ)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.INFUSED_LAPIS.value())));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOUL_ESSENCE_1.value(), 1)
                .input(ModItems.SOUL_ESSENCE_2.value())
                .criterion(hasItem(ModItems.SOUL_ESSENCE_2.value()), conditionsFromItem(ModItems.SOUL_ESSENCE_2.value()))
                .criterion(hasItem(ModItems.SOUL_ESSENCE_1.value()), conditionsFromItem(ModItems.SOUL_ESSENCE_1.value()))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.SOUL_ESSENCE_1.value())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOUL_ESSENCE_2.value(), 1)
                .input(ModItems.SOUL_ESSENCE_3.value())
                .criterion(hasItem(ModItems.SOUL_ESSENCE_3.value()), conditionsFromItem(ModItems.SOUL_ESSENCE_3.value()))
                .criterion(hasItem(ModItems.SOUL_ESSENCE_2.value()), conditionsFromItem(ModItems.SOUL_ESSENCE_2.value()))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.SOUL_ESSENCE_2.value())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ESSENCE_OF_SNEAK_1.value(), 1)
                .input(ModItems.ESSENCE_OF_SNEAK_2.value())
                .criterion(hasItem(ModItems.ESSENCE_OF_SNEAK_2.value()), conditionsFromItem(ModItems.ESSENCE_OF_SNEAK_2.value()))
                .criterion(hasItem(ModItems.ESSENCE_OF_SNEAK_1.value()), conditionsFromItem(ModItems.ESSENCE_OF_SNEAK_1.value()))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.ESSENCE_OF_SNEAK_1.value())));
/*
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ESSENCE_OF_SNEAK_2, 1)
                .input(ModItems.ESSENCE_OF_SNEAK_3)
                .criterion(hasItem(ModItems.ESSENCE_OF_SNEAK_3), conditionsFromItem(ModItems.ESSENCE_OF_SNEAK_3))
                .criterion(hasItem(ModItems.ESSENCE_OF_SNEAK_2), conditionsFromItem(ModItems.ESSENCE_OF_SNEAK_2))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.ESSENCE_OF_SNEAK_2)));

        //Essences
        Item recipeItem = ModItems.ESSENCE_OF_PROTECTION;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.CRYING_OBSIDIAN)
                .input('N', Items.NETHERITE_INGOT)
                .input('D', Items.DRAGON_BREATH)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_FIRE_PROTECTION;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ESE")
                .pattern("MDM")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('M', Items.MAGMA_BLOCK)
                .input('E', Items.END_STONE)
                .input('D', Items.DRAGON_BREATH)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_BLAST_PROTECTION;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("WSW")
                .pattern("OCO")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('W', Items.NETHER_STAR)
                .input('O', Items.OBSIDIAN)
                .input('C', Items.CREEPER_HEAD)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_PROJECTILE_PROTECTION;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("DSD")
                .pattern("HBH")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('D', Items.DIAMOND)
                .input('H', Items.SKELETON_SKULL)
                .input('B', Items.ARMADILLO_SCUTE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_FEATHER;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("MSM")
                .pattern("AGA")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('M', Items.PHANTOM_MEMBRANE)
                .input('G', Items.GLOWSTONE)
                .input('A', Items.SHULKER_SHELL)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_RESPIRATION;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("PSP")
                .pattern("RCR")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('P', Items.PUFFERFISH_BUCKET)
                .input('C', Items.CONDUIT)
                .input('R', Items.DARK_PRISMARINE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SEA;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("KSK")
                .pattern("LCL")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('K', Items.DRIED_KELP_BLOCK)
                .input('C', Items.CONDUIT)
                .input('L', Items.PRISMARINE_CRYSTALS)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_THORN;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("RSR")
                .pattern("BDB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('R', Items.ROSE_BUSH)
                .input('D', Items.DRAGON_BREATH)
                .input('B', Items.BLAZE_ROD)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_ICE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.BLUE_ICE)
                .input('B', Items.SNOW_BLOCK)
                .input('C', Items.ECHO_SHARD)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SHARPNESS;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.IRON_SWORD)
                .input('B', Items.GRINDSTONE)
                .input('C', Items.NETHERITE_INGOT)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SMITE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.GLISTERING_MELON_SLICE)
                .input('B', Items.SMOOTH_QUARTZ)
                .input('C', Items.END_CRYSTAL)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_ARTHROPODS;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.COBWEB)
                .input('B', Items.DEEPSLATE)
                .input('C', Items.CHORUS_FRUIT)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_KNOCKBACK;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.PISTON)
                .input('B', Items.IRON_BLOCK)
                .input('C', Items.LODESTONE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_FIRE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.MAGMA_BLOCK)
                .input('B', Items.LAVA_BUCKET)
                .input('C', Items.DRAGON_BREATH)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_LOOTING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.GHAST_TEAR)
                .input('B', Items.RABBIT_FOOT)
                .input('C', Items.TORCHFLOWER)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SWEEPING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.GOLDEN_SWORD)
                .input('B', Items.EMERALD_BLOCK)
                .input('C', Items.NETHERITE_SCRAP)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_POWER;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.CROSSBOW)
                .input('B', Items.DIAMOND)
                .input('C', Items.SKELETON_SKULL)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_PUNCH;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.SPECTRAL_ARROW)
                .input('B', Items.OBSIDIAN)
                .input('C', Items.LODESTONE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_ARROWS;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.SKELETON_SKULL)
                .input('B', Items.EMERALD_BLOCK)
                .input('C', Items.NETHER_STAR)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_EFFICIENCY;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.GOLD_BLOCK)
                .input('B', Items.DIAMOND)
                .input('C', Items.BEACON)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SILK_TOUCH;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern("DIE")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.LAPIS_BLOCK)
                .input('B', Items.EMERALD_BLOCK)
                .input('C', Items.GOLDEN_APPLE)
                .input('D', Items.IRON_BLOCK)
                .input('E', Items.GOLD_BLOCK)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_FORTUNE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.RABBIT_FOOT)
                .input('B', Items.EMERALD)
                .input('C', Items.SHULKER_SHELL)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SEA_LUCK;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.RABBIT_FOOT)
                .input('B', Items.GLISTERING_MELON_SLICE)
                .input('C', Items.NAUTILUS_SHELL)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_LURE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.GOLDEN_CARROT)
                .input('B', Items.PRISMARINE_CRYSTALS)
                .input('C', Items.HEART_OF_THE_SEA)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_UNBREAKING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.GOLDEN_CARROT)
                .input('B', Items.PRISMARINE_CRYSTALS)
                .input('C', Items.HEART_OF_THE_SEA)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_MENDING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.BOOK)
                .input('B', Items.ANVIL)
                .input('C', ModItems.ESSENCE_OF_EXPERIENCE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .criterion(hasItem(ModItems.ESSENCE_OF_EXPERIENCE), conditionsFromItem(ModItems.ESSENCE_OF_EXPERIENCE))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_EXPERIENCE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.DIAMOND)
                .input('B', Items.EMERALD)
                .input('C', Items.EXPERIENCE_BOTTLE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_CHANNELING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.LIGHTNING_ROD)
                .input('B', Items.COPPER_BLOCK)
                .input('C', Items.IRON_BLOCK)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_IMPALING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.GOAT_HORN)
                .input('B', Items.END_ROD)
                .input('C', Items.IRON_SWORD)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_LOYALTY;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.ENDER_PEARL)
                .input('B', Items.GHAST_TEAR)
                .input('C', Items.LEAD)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_RIPTIDE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.WATER_BUCKET)
                .input('B', Items.TNT)
                .input('C', Items.CONDUIT)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_MULTISHOT;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.ARROW)
                .input('B', Items.BOW)
                .input('C', Items.DRAGON_BREATH)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_PIERCING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.SPECTRAL_ARROW)
                .input('B', Items.END_ROD)
                .input('C', Items.TRIDENT)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_QUICK_CHARGE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.STRING)
                .input('B', Items.PISTON)
                .input('C', Items.WIND_CHARGE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_DENSITY;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.IRON_BLOCK)
                .input('B', Items.OBSIDIAN)
                .input('C', Items.LODESTONE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_BREACH;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.NETHERITE_INGOT)
                .input('B', Items.MAGMA_CREAM)
                .input('C', Items.WIND_CHARGE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_WIND;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.GLASS_BOTTLE)
                .input('B', Items.WIND_CHARGE)
                .input('C', Items.ENDER_PEARL)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        //endregion
        */
        //region COMPATIBLE MODS
        //Add call to individual class for compatible mods
        //endregion

    }
}
