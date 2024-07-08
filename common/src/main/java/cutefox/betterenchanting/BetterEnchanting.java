package cutefox.betterenchanting;

import cutefox.betterenchanting.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BetterEnchanting {
    public static final Logger LOGGER = LoggerFactory.getLogger("better-enchanting");
    public static final String MOD_ID = "BetterEnchanting";

    public static void init() {
        // Write common init code here.

        ModItems.registerModItems();
        ModScreenHandlerType.registerModScreenHandlers();
        ModEnchantmentTags.registerModTags();
        ModEnchantIngredientMap.createMap();

        ModItemTags.registerModTags();
        ModLootTables.registerLootTables();


    }
}
