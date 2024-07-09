package cutefox.betterenchanting;

import cutefox.betterenchanting.registry.ModItems;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BetterEnchanting {
    public static final Logger LOGGER = LoggerFactory.getLogger("better-enchanting");
    public static final String MOD_ID = "betterenchanting";

    //public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, RegistryKeys.ITEM);

    public static void init() {
        // Write common init code here.

        ModItems.registerModItems();
        /*ModScreenHandlerType.registerModScreenHandlers();
        ModEnchantmentTags.registerModTags();
        ModEnchantIngredientMap.createMap();

        ModItemTags.registerModTags();
        ModLootTables.registerLootTables();*/


    }
}
