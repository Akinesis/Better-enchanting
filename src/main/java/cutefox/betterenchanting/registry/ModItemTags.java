package cutefox.betterenchanting.registry;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Utils;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModItemTags {

    public static final TagKey<Item> ENCHANTEMNT_INGREDIENT = TagKey.of(RegistryKeys.ITEM, Utils.id("enchantment_ingredients"));

    public static void registerModTags(){
        BetterEnchanting.LOGGER.info("Generating item tags for mod : "+BetterEnchanting.MOD_ID);
    }
}
