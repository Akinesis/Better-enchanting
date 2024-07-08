package cutefox.betterenchanting.datagen;

import cutefox.betterenchanting.BetterEnchantingFabric;
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
        BetterEnchantingFabric.LOGGER.info("Generating block model data for : "+ BetterEnchantingFabric.MOD_ID);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        BetterEnchantingFabric.LOGGER.info("Generating item model data for : "+ BetterEnchantingFabric.MOD_ID);

        //region MISC
        //itemModelGenerator.register(ModItems.STEEL_BLEND, Models.GENERATED);
        //itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        //endregion

        //region ENCHANTMENT INGREDIENTS
        ModItems.MOD_ITEM_LIST.stream().forEach(item -> {
            itemModelGenerator.register(item, Models.GENERATED);
        });
        /*
        itemModelGenerator.register(ModItems.INFUSED_LAPIS, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_SHARD_DULL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_SHARD_FULL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_PROTECTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_FIRE_PROTECTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_BLAST_PROTECTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_PROJECTILE_PROTECTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_EXPERIENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_ESSENCE_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_ESSENCE_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_ESSENCE_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_SNEAK_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_SNEAK_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_SNEAK_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_SWEEPING, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_ARROWS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_ICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_ARROWS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_OF_ARROWS, Models.GENERATED);*/
        //endregion

    }
}
