package cutefox.betterenchanting.registry;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Utils;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModLootTables {

    public static final RegistryKey<LootTable> ESSENCE_TABLE = register("essence");
    public static final RegistryKey<LootTable> ENCHANTMENT_INGREDIENT_TABLE = register("enchantment_ingredient");
    public static final RegistryKey<LootTable> ENCHANTMENT_LOOT = register("enchantment_loot");

    public static void registerLootTables(){
        BetterEnchanting.LOGGER.info("Registering loot tables for "+ BetterEnchanting.MOD_ID);
    }

    private static RegistryKey<LootTable> register(String id) {
        return RegistryKey.of(RegistryKeys.LOOT_TABLE, Utils.id(id));
    }

}
