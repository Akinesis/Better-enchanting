package cutefox.betterenchanting.datagen;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Utils;
import cutefox.betterenchanting.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        BetterEnchanting.LOGGER.info("Generating recipes for : "+BetterEnchanting.MOD_ID);

        //region CRAFTING COMPONENTS
        /*ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_BLEND, 1)
                .input(Items.RAW_IRON)
                .input(Ingredient.ofItems(Items.COAL, Items.CHARCOAL))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.RAW_IRON))
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .criterion(hasItem(Items.CHARCOAL), conditionsFromItem(Items.CHARCOAL))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.STEEL_BLEND)));*/
        //endregion

        //region SMELTING
        /*CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.STEEL_BLEND), RecipeCategory.MISC, ModItems.STEEL_INGOT, 1,200)
                .criterion(hasItem(ModItems.STEEL_BLEND), conditionsFromItem(ModItems.STEEL_BLEND))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.STEEL_INGOT)));*/
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


        //endregion

    }
}
