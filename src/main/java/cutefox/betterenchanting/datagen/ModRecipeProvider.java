package cutefox.betterenchanting.datagen;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Utils;
import cutefox.betterenchanting.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
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
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_BLEND, 1)
                .input(Items.RAW_IRON)
                .input(Ingredient.ofItems(Items.COAL, Items.CHARCOAL))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.RAW_IRON))
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .criterion(hasItem(Items.CHARCOAL), conditionsFromItem(Items.CHARCOAL))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.STEEL_BLEND)));
        //endregion

        //region SMELTING
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.STEEL_BLEND), RecipeCategory.MISC, ModItems.STEEL_INGOT, 1,200)
                .criterion(hasItem(ModItems.STEEL_BLEND), conditionsFromItem(ModItems.STEEL_BLEND))
                .offerTo(exporter, Utils.id(getRecipeName(ModItems.STEEL_INGOT)));
        //endregion

    }
}
