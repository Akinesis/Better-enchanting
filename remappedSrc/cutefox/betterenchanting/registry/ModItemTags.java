package cutefox.betterenchanting.registry;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Util.Utils;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModItemTags {

    public static final TagKey<Item> ENCHANTEMNT_INGREDIENT = TagKey.of(RegistryKeys.ITEM, Utils.id("enchantment_ingredients"));
    public static final TagKey<Item> ENCHANTMENT_ESSENCE = TagKey.of(RegistryKeys.ITEM, Utils.id("enchantment_essence"));
    public static final TagKey<Item> LIBRARIAN_RARE_INGREDIENT = TagKey.of(RegistryKeys.ITEM, Utils.id("librarian_rare_ingredient"));
    public static final TagKey<Item> NEOENCHANT_ESSENCE = TagKey.of(RegistryKeys.ITEM, Utils.id("neoenchant_essence"));
    public static final TagKey<Item> BUMBLEZONE_ESSENCE = TagKey.of(RegistryKeys.ITEM, Utils.id("bumblezone_essence"));

    public static void registerModTags(){
        BetterEnchanting.LOGGER.info("Generating item tags for mod : "+BetterEnchanting.MOD_ID);
    }
}
