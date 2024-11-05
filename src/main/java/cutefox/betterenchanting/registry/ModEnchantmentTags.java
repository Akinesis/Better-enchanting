package cutefox.betterenchanting.registry;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Util.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModEnchantmentTags {
    public static final TagKey<Enchantment> BENEFICIAL_TREASURE = TagKey.of(RegistryKeys.ENCHANTMENT, Utils.id("beneficial_treasure"));

    public static void registerModTags(){
        BetterEnchanting.LOGGER.info("Registering mod enchantment tags for : "+ BetterEnchanting.MOD_ID);
    }
}
