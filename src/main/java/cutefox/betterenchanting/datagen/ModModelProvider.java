package cutefox.betterenchanting.datagen;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BetterEnchanting.LOGGER.info("Generating block model data for : "+BetterEnchanting.MOD_ID);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        BetterEnchanting.LOGGER.info("Generating item model data for : "+BetterEnchanting.MOD_ID);

        //region MISC
        //itemModelGenerator.register(ModItems.STEEL_BLEND, Models.GENERATED);
        //itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        //endregion

        //region ENCHANTMENT INGREDIENTS
        itemModelGenerator.register(ModItems.INFUSED_LAPIS, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_SHARD_DULL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_SHARD_FULL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_PROTECTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_FIRE_PROTECTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_BLAST_PROTECTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_EXPERIENCE, Models.GENERATED);
        //endregion

    }
}
