package cutefox.betterenchanting.registry;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Utils;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    private static Item.Settings foodItem(FoodComponent component){
        return new Item.Settings().food(component);
    }
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BetterEnchanting.MOD_ID, RegistryKeys.ITEM);

    public static void registerModItems(){
        BetterEnchanting.LOGGER.info("Registering mod iems for : "+ BetterEnchanting.MOD_ID);
        ITEMS.register();
    }

    public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Settings()));
    public static final List<Item> MOD_ITEM_LIST = new ArrayList<>();
    public static final RegistrySupplier<Item> INFUSED_LAPIS = ITEMS.register("infused_lapis", () -> new Item(new Item.Settings()));
    public static final RegistrySupplier<Item> MAGIC_SHARD_DULL = ITEMS.register("magic_shard_dull", () -> new Item(new Item.Settings()));
    public static final RegistrySupplier<Item> MAGIC_SHARD_FULL = ITEMS.register("magic_shard_full", () -> new Item(new Item.Settings().maxCount(16).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Armors
    public static final RegistrySupplier<Item> ESSENCE_OF_PROTECTION = ITEMS.register("essence_of_protection", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_FIRE_PROTECTION = ITEMS.register("essence_of_fire_protection", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_BLAST_PROTECTION = ITEMS.register("essence_of_blast_protection", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_PROJECTILE_PROTECTION = ITEMS.register("essence_of_projectile_protection", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> SOUL_ESSENCE_1 = ITEMS.register("soul_essence_1", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> SOUL_ESSENCE_2 = ITEMS.register("soul_essence_2", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).recipeRemainder(ModItems.SOUL_ESSENCE_1.get())));
    public static final RegistrySupplier<Item> SOUL_ESSENCE_3 = ITEMS.register("soul_essence_3", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).recipeRemainder(ModItems.SOUL_ESSENCE_2.get())));
    public static final RegistrySupplier<Item> ESSENCE_OF_SNEAK_1 = ITEMS.register("essence_of_sneak_1", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_SNEAK_2 = ITEMS.register("essence_of_sneak_2", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).recipeRemainder(ModItems.ESSENCE_OF_SNEAK_1.get())));
    public static final RegistrySupplier<Item> ESSENCE_OF_SNEAK_3 = ITEMS.register("essence_of_sneak_3", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).recipeRemainder(ModItems.ESSENCE_OF_SNEAK_2.get())));
    public static final RegistrySupplier<Item> ESSENCE_OF_FEATHER = ITEMS.register("essence_of_feather", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_RESPIRATION = ITEMS.register("essence_of_respiration", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_SEA = ITEMS.register("essence_of_sea", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_THORN = ITEMS.register("essence_of_thorn", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_ICE = ITEMS.register("essence_of_ice", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Swords
    public static final RegistrySupplier<Item> ESSENCE_OF_SWEEPING = ITEMS.register("essence_of_sweeping", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_SHARPNESS = ITEMS.register("essence_of_sharpness", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_SMITE = ITEMS.register("essence_of_smite", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_ARTHROPODS = ITEMS.register("essence_of_arthropods", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_KNOCKBACK = ITEMS.register("essence_of_knockback", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_FIRE = ITEMS.register("essence_of_fire", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_LOOTING = ITEMS.register("essence_of_looting", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Bows
    public static final RegistrySupplier<Item> ESSENCE_OF_ARROWS = ITEMS.register("essence_of_arrows", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_POWER = ITEMS.register("essence_of_power", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_PUNCH = ITEMS.register("essence_of_punch", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Tools
    public static final RegistrySupplier<Item> ESSENCE_OF_EFFICIENCY = ITEMS.register("essence_of_efficiency", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_SILK_TOUCH = ITEMS.register("essence_of_silk_touch", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_FORTUNE = ITEMS.register("essence_of_fortune", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Fishing tool
    public static final RegistrySupplier<Item> ESSENCE_OF_SEA_LUCK = ITEMS.register("essence_of_sea_luck", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_LURE = ITEMS.register("essence_of_lure", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Anything
    public static final RegistrySupplier<Item> ESSENCE_OF_EXPERIENCE = ITEMS.register("essence_of_experience", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_MENDING = ITEMS.register("essence_of_mending", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_UNBREAKING = ITEMS.register("essence_of_unbreaking", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Trident
    public static final RegistrySupplier<Item> ESSENCE_OF_CHANNELING = ITEMS.register("essence_of_channeling", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_IMPALING = ITEMS.register("essence_of_impaling", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_LOYALTY = ITEMS.register("essence_of_loyalty", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_RIPTIDE = ITEMS.register("essence_of_riptide", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Crossbow
    public static final RegistrySupplier<Item> ESSENCE_OF_MULTISHOT = ITEMS.register("essence_of_multishot", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_PIERCING = ITEMS.register("essence_of_piercing", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_QUICK_CHARGE = ITEMS.register("essence_of_quick_charge", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Mace
    public static final RegistrySupplier<Item> ESSENCE_OF_DENSITY = ITEMS.register("essence_of_density", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_BREACH = ITEMS.register("essence_of_breach", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistrySupplier<Item> ESSENCE_OF_WIND = ITEMS.register("essence_of_wind", () -> new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //region MATERIALS
    //public static final Item STEEL_BLEND = registerItem("steel_blend", new Item(new Item.Settings()));
    //public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    //endregion
/*
    //region ENCHANTMENT INGREDIENTS
    public static final List<Item> MOD_ITEM_LIST = new ArrayList<>();
    public static final Item INFUSED_LAPIS = registerItem("infused_lapis", new Item(new Item.Settings()));
    public static final Item MAGIC_SHARD_DULL = registerItem("magic_shard_dull", new Item(new Item.Settings()));
    public static final Item MAGIC_SHARD_FULL = registerItem("magic_shard_full", new Item(new Item.Settings().maxCount(16).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Armors
    public static final Item ESSENCE_OF_PROTECTION = registerItem("essence_of_protection", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_FIRE_PROTECTION = registerItem("essence_of_fire_protection", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_BLAST_PROTECTION = registerItem("essence_of_blast_protection", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_PROJECTILE_PROTECTION = registerItem("essence_of_projectile_protection", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item SOUL_ESSENCE_1 = registerItem("soul_essence_1", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item SOUL_ESSENCE_2 = registerItem("soul_essence_2", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).recipeRemainder(ModItems.SOUL_ESSENCE_1)));
    public static final Item SOUL_ESSENCE_3 = registerItem("soul_essence_3", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).recipeRemainder(ModItems.SOUL_ESSENCE_2)));
    public static final Item ESSENCE_OF_SNEAK_1 = registerItem("essence_of_sneak_1", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_SNEAK_2 = registerItem("essence_of_sneak_2", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).recipeRemainder(ModItems.ESSENCE_OF_SNEAK_1)));
    public static final Item ESSENCE_OF_SNEAK_3 = registerItem("essence_of_sneak_3", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).recipeRemainder(ModItems.ESSENCE_OF_SNEAK_2)));
    public static final Item ESSENCE_OF_FEATHER = registerItem("essence_of_feather", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_RESPIRATION = registerItem("essence_of_respiration", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_SEA = registerItem("essence_of_sea", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_THORN = registerItem("essence_of_thorn", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_ICE = registerItem("essence_of_ice", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Swords
    public static final Item ESSENCE_OF_SWEEPING = registerItem("essence_of_sweeping", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_SHARPNESS = registerItem("essence_of_sharpness", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_SMITE = registerItem("essence_of_smite", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_ARTHROPODS = registerItem("essence_of_arthropods", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_KNOCKBACK = registerItem("essence_of_knockback", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_FIRE = registerItem("essence_of_fire", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_LOOTING = registerItem("essence_of_looting", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Bows
    public static final Item ESSENCE_OF_ARROWS = registerItem("essence_of_arrows", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_POWER = registerItem("essence_of_power", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_PUNCH = registerItem("essence_of_punch", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Tools
    public static final Item ESSENCE_OF_EFFICIENCY = registerItem("essence_of_efficiency", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_SILK_TOUCH = registerItem("essence_of_silk_touch", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_FORTUNE = registerItem("essence_of_fortune", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Fishing tool
    public static final Item ESSENCE_OF_SEA_LUCK = registerItem("essence_of_sea_luck", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_LURE = registerItem("essence_of_lure", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Anything
    public static final Item ESSENCE_OF_EXPERIENCE = registerItem("essence_of_experience", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_MENDING = registerItem("essence_of_mending", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_UNBREAKING = registerItem("essence_of_unbreaking", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Trident
    public static final Item ESSENCE_OF_CHANNELING = registerItem("essence_of_channeling", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_IMPALING = registerItem("essence_of_impaling", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_LOYALTY = registerItem("essence_of_loyalty", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_RIPTIDE = registerItem("essence_of_riptide", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Crossbow
    public static final Item ESSENCE_OF_MULTISHOT = registerItem("essence_of_multishot", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_PIERCING = registerItem("essence_of_piercing", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_QUICK_CHARGE = registerItem("essence_of_quick_charge", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //Mace
    public static final Item ESSENCE_OF_DENSITY = registerItem("essence_of_density", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_BREACH = registerItem("essence_of_breach", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_WIND = registerItem("essence_of_wind", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //endregion

    private static Item registerItem(String id, Item item){
        Item i = Registry.register(Registries.ITEM, Utils.id(id), item);
        MOD_ITEM_LIST.add(i);
        return i;
    }*/



}