package cutefox.betterenchanting.datagen;


import com.terraformersmc.modmenu.util.mod.Mod;
import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Util.Utils;
import cutefox.betterenchanting.conditions.BumblezoneCompatCondition;
import cutefox.betterenchanting.conditions.NeoEnchantCompatCondition;
import cutefox.betterenchanting.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends FabricRecipeProvider {

    private static final ResourceCondition NEO_ENCHANT = new NeoEnchantCompatCondition();
    private static final ResourceCondition BUMBLEZONE = new BumblezoneCompatCondition();

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        BetterEnchanting.LOGGER.info("Generating recipes for : "+BetterEnchanting.MOD_ID);

        //region UPGRADE TEMPLATE

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_UPGRADE_SMITHING_TEMPLATE, 1)
                .pattern("IBI")
                .pattern("IBI")
                .pattern("III")
                .input('I', Items.IRON_INGOT)
                .input('B', Items.BRICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.SMITHING_TABLE), conditionsFromItem(Items.SMITHING_TABLE))
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENCHANTMENT_CATALYST, 1)
                .pattern(" D ")
                .pattern("LML")
                .pattern("AEA")
                .input('E', Items.EMERALD)
                .input('D', Items.DIAMOND)
                .input('M', ModItems.MAGIC_SHARD_FULL)
                .input('L', ModItems.INFUSED_LAPIS)
                .input('A', Items.AMETHYST_SHARD)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .criterion(hasItem(ModItems.MAGIC_SHARD_DULL), conditionsFromItem(ModItems.MAGIC_SHARD_DULL))
                .criterion(hasItem(ModItems.INFUSED_LAPIS), conditionsFromItem(ModItems.INFUSED_LAPIS))
                .criterion(hasItem(Items.GRINDSTONE), conditionsFromItem(Items.GRINDSTONE))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.ENCHANTMENT_CATALYST)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, 1)
                .pattern("DID")
                .pattern("DID")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.SMITHING_TABLE), conditionsFromItem(Items.SMITHING_TABLE))
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE)));

        //endregion

        //region SMITHING RECIPE

        //Stone to Iron
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.STONE_AXE),
                Ingredient.ofItems(Items.IRON_INGOT),
                RecipeCategory.TOOLS,
                Items.IRON_AXE)
                .criterion(hasItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("iron_axe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.STONE_PICKAXE),
                Ingredient.ofItems(Items.IRON_INGOT),
                RecipeCategory.TOOLS,
                Items.IRON_PICKAXE)
                .criterion(hasItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("iron_pickaxe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.STONE_HOE),
                Ingredient.ofItems(Items.IRON_INGOT),
                RecipeCategory.TOOLS,
                Items.IRON_HOE)
                .criterion(hasItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("iron_hoe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.STONE_SHOVEL),
                Ingredient.ofItems(Items.IRON_INGOT),
                RecipeCategory.TOOLS,
                Items.IRON_SHOVEL)
                .criterion(hasItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("iron_shovel_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.STONE_SWORD),
                Ingredient.ofItems(Items.IRON_INGOT),
                RecipeCategory.COMBAT,
                Items.IRON_SWORD)
                .criterion(hasItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("iron_sword_smithing"));

        //Gold to Diamond

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_AXE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.TOOLS,
                        Items.DIAMOND_AXE)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_gold_axe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_PICKAXE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.TOOLS,
                        Items.DIAMOND_PICKAXE)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_gold_pickaxe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_HOE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.TOOLS,
                        Items.DIAMOND_HOE)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_gold_hoe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_SHOVEL),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.TOOLS,
                        Items.DIAMOND_SHOVEL)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_gold_shovel_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_SWORD),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_SWORD)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_gold_sword_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_HELMET),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_HELMET)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_gold_helmet_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_CHESTPLATE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_CHESTPLATE)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_gold_chestplate_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_LEGGINGS),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_LEGGINGS)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_gold_leggings_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_BOOTS),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_BOOTS)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_gold_boots_smithing"));

        //Iron to Diamond

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_AXE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.TOOLS,
                        Items.DIAMOND_AXE)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_iron_axe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_PICKAXE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.TOOLS,
                        Items.DIAMOND_PICKAXE)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_iron_pickaxe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_HOE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.TOOLS,
                        Items.DIAMOND_HOE)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_iron_hoe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_SHOVEL),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.TOOLS,
                        Items.DIAMOND_SHOVEL)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_iron_shovel_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_SWORD),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_SWORD)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_iron_sword_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_HELMET),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_HELMET)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_iron_helmet_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_CHESTPLATE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_CHESTPLATE)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_iron_chestplate_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_LEGGINGS),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_LEGGINGS)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_iron_leggings_smithing"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_BOOTS),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_BOOTS)
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Utils.id("diamond_iron_boots_smithing"));

        //endregion

        //region ENCHANTMENT INGREDIENTS

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGIC_SHARD_DULL, 1)
                .pattern("IDI")
                .pattern("GAG")
                .pattern("IDI")
                .input('A', Items.AMETHYST_SHARD)
                .input('D', Items.DIAMOND)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('G', Items.GHAST_TEAR)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.GHAST_TEAR), conditionsFromItem(Items.GHAST_TEAR))
                .criterion(hasItem(ModItems.INFUSED_LAPIS), conditionsFromItem(ModItems.INFUSED_LAPIS))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.MAGIC_SHARD_DULL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGIC_SHARD_FULL, 1)
                .pattern(" B ")
                .pattern("ESE")
                .pattern("LBL")
                .input('S', ModItems.MAGIC_SHARD_DULL)
                .input('B', Items.EXPERIENCE_BOTTLE)
                .input('E', Items.EMERALD)
                .input('L', ModItems.INFUSED_LAPIS)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.EXPERIENCE_BOTTLE), conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                .criterion(hasItem(ModItems.INFUSED_LAPIS), conditionsFromItem(ModItems.INFUSED_LAPIS))
                .criterion(hasItem(ModItems.MAGIC_SHARD_DULL), conditionsFromItem(ModItems.MAGIC_SHARD_DULL))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.MAGIC_SHARD_FULL)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INFUSED_LAPIS, 1)
                .input(Items.LAPIS_LAZULI)
                .input(Items.AMETHYST_SHARD)
                .input(Items.QUARTZ)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.INFUSED_LAPIS)));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOUL_ESSENCE_1, 1)
                .input(ModItems.SOUL_ESSENCE_2)
                .criterion(hasItem(ModItems.SOUL_ESSENCE_2), conditionsFromItem(ModItems.SOUL_ESSENCE_2))
                .criterion(hasItem(ModItems.SOUL_ESSENCE_1), conditionsFromItem(ModItems.SOUL_ESSENCE_1))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.SOUL_ESSENCE_1)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOUL_ESSENCE_2, 1)
                .input(ModItems.SOUL_ESSENCE_3)
                .criterion(hasItem(ModItems.SOUL_ESSENCE_3), conditionsFromItem(ModItems.SOUL_ESSENCE_3))
                .criterion(hasItem(ModItems.SOUL_ESSENCE_2), conditionsFromItem(ModItems.SOUL_ESSENCE_2))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.SOUL_ESSENCE_2)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ESSENCE_OF_SNEAK_1, 1)
                .input(ModItems.ESSENCE_OF_SNEAK_2)
                .criterion(hasItem(ModItems.ESSENCE_OF_SNEAK_2), conditionsFromItem(ModItems.ESSENCE_OF_SNEAK_2))
                .criterion(hasItem(ModItems.ESSENCE_OF_SNEAK_1), conditionsFromItem(ModItems.ESSENCE_OF_SNEAK_1))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.ESSENCE_OF_SNEAK_1)));

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
                .input('C', Items.SHULKER_SHELL)
                .input('N', Items.NETHERITE_SCRAP)
                .input('D', Items.CRYING_OBSIDIAN)
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
                .pattern("WSH")
                .pattern("OCO")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('H', Items.CREEPER_HEAD)
                .input('W', Items.WITHER_SKELETON_SKULL)
                .input('O', Items.OBSIDIAN)
                .input('C', Items.TNT)
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
                .input('A', Items.SHULKER_BOX)
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
                .input('C', Items.HEART_OF_THE_SEA)
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
                .input('C', Items.TNT)
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
                .input('C', Items.EMERALD_BLOCK)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_UNBREAKING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("ASA")
                .pattern("BCB")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('A', Items.IRON_BLOCK)
                .input('B', Items.OBSIDIAN)
                .input('C', Items.NETHERITE_INGOT)
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
                .input('C', Items.NAUTILUS_SHELL)
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

        //region NEO ENCHANT PLUS

        recipeItem = ModItems.ESSENCE_OF_POISON;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.NETHER_WART_BLOCK)
                .input('N', Items.FERMENTED_SPIDER_EYE)
                .input('D', Items.SLIME_BLOCK)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_POISON_PROTECTION;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.NETHER_WART_BLOCK)
                .input('N', Items.FERMENTED_SPIDER_EYE)
                .input('D', Items.CRYING_OBSIDIAN)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_MINING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.IRON_BLOCK)
                .input('N', Items.FLINT)
                .input('D', Items.DIAMOND_PICKAXE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SMELTING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.NETHERRACK)
                .input('N', Items.MAGMA_BLOCK)
                .input('D', Items.LAVA_BUCKET)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SIGHT;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.GLASS)
                .input('N', Items.GOLDEN_CARROT)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_LEVITATION;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.FEATHER)
                .input('N', Items.PHANTOM_MEMBRANE)
                .input('D', Items.END_STONE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_FORAGING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.HAY_BLOCK)
                .input('N', Items.OAK_LEAVES)
                .input('D', Items.ROOTED_DIRT)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_STRIKE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.IRON_BLOCK)
                .input('N', Items.GOLD_INGOT)
                .input('D', Items.COPPER_BLOCK)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_HEALTH;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.OBSIDIAN)
                .input('N', Items.HONEY_BLOCK)
                .input('D', Items.GOLDEN_APPLE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_VAMPIRISM;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.NETHER_WART_BLOCK)
                .input('N', Items.FLINT)
                .input('D', Items.DIAMOND_SWORD)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_AGILITY;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.RABBIT_FOOT)
                .input('N', Items.GOLDEN_CARROT)
                .input('D', Items.WIND_CHARGE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_COMBAT;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.SHIELD)
                .input('N', Items.IRON_SWORD)
                .input('D', Items.DIAMOND_BLOCK)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_BUILDING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.STONECUTTER)
                .input('N', Items.CHISELED_DEEPSLATE)
                .input('D', Items.GRASS_BLOCK)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_FEAR;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.GUNPOWDER)
                .input('N', Items.TROPICAL_FISH_BUCKET)
                .input('D', Items.CREEPER_BANNER_PATTERN)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_REACH;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.PISTON)
                .input('N', Items.LIGHTNING_ROD)
                .input('D', Items.END_ROD)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_PULLING;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.ENDER_PEARL)
                .input('N', Items.EGG)
                .input('D', Items.ZOMBIE_HEAD)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_FOOD;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.HAY_BLOCK)
                .input('N', Items.COOKED_RABBIT)
                .input('D', Items.GOLDEN_APPLE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_PHOTOSYNTHESIS;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.GLOWSTONE)
                .input('N', Items.SMOOTH_QUARTZ)
                .input('D', Items.GOLDEN_APPLE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_WINGS;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.END_ROD)
                .input('N', Items.FEATHER)
                .input('D', Items.WIND_CHARGE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_GRAVITY;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.OBSIDIAN)
                .input('N', Items.RAW_IRON_BLOCK)
                .input('D', Items.LODESTONE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        //endregion

        //region DIVERSITY
        recipeItem = ModItems.ESSENCE_OF_REFILL;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.ENDER_PEARL)
                .input('N', Items.SLIME_BLOCK)
                .input('D', Items.ENDER_EYE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_CAPACITY;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.GOLD_BLOCK)
                .input('N', Items.LEATHER_LEGGINGS)
                .input('D', Items.ENDER_CHEST)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));
        //endregion

        //region TOSS UP
        recipeItem = ModItems.ESSENCE_OF_EXPLOSION;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.TNT)
                .input('N', Items.FIRE_CHARGE)
                .input('D', Items.NETHER_STAR)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));
        //endregion

        //region COMABT ROLL
        recipeItem = ModItems.ESSENCE_OF_MULTI_ROLL;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.PISTON)
                .input('N', ItemTags.BEDS)
                .input('D', Items.WIND_CHARGE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_LONGFOOT;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.END_ROD)
                .input('N', Items.REDSTONE_BLOCK)
                .input('D', Items.DIAMOND_BOOTS)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_CRITICAL_SPELL;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.GLOWSTONE)
                .input('N', Items.REDSTONE_BLOCK)
                .input('D', Items.EMERALD_BLOCK)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_ENERGY;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.COPPER_INGOT)
                .input('N', Items.LIGHTNING_ROD)
                .input('D', Items.TRIDENT)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_HASTE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.SUGAR)
                .input('N', Items.BLAZE_POWDER)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_MAGIC_PROTECTION;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.DIAMOND)
                .input('N', Items.IRON_BARS)
                .input('D', Items.CRYING_OBSIDIAN)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SOULFROST;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.QUARTZ_BLOCK)
                .input('N', Items.SNOW_BLOCK)
                .input('D', Items.BLUE_ICE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SPELL_POWER;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.ENDER_PEARL)
                .input('N', Items.BLAZE_ROD)
                .input('D', Items.DIAMOND_BOOTS)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SUNFIRE;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.BLAZE_ROD)
                .input('N', Items.FIRE_CHARGE)
                .input('D', Items.CAMPFIRE)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_SPELL_INFINITY;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', Items.AMETHYST_BLOCK)
                .input('N', Items.QUARTZ_BLOCK)
                .input('D', Items.NETHER_STAR)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(exporter, Utils.id(getRecipeName(recipeItem)));


        //endregion

        //region THE BUMBLEZONE
        /*recipeItem = ModItems.ESSENCE_OF_NEUROTOXIN;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', BzItems.BEE_STINGER.get())
                .input('N', BzItems.STINGER_SPEAR.get())
                .input('D', BzItems.BEE_SOUP.get())
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(withConditions(exporter,BUMBLEZONE), Utils.id(getRecipeName(recipeItem)));

        recipeItem = ModItems.ESSENCE_OF_COMB_CUTTER;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, recipeItem, 1)
                .pattern(" I ")
                .pattern("NSN")
                .pattern("CDC")
                .input('S', ModItems.MAGIC_SHARD_FULL)
                .input('I', ModItems.INFUSED_LAPIS)
                .input('C', BzItems.POLLEN_PUFF.get())
                .input('N', Items.SHEARS)
                .input('D', Items.HONEYCOMB_BLOCK)
                .criterion(hasItem(ModItems.MAGIC_SHARD_FULL), conditionsFromItem(ModItems.MAGIC_SHARD_FULL))
                .offerTo(withConditions(exporter,BUMBLEZONE), Utils.id(getRecipeName(recipeItem)));*/
        //endregion

    }
}
