package cutefox.betterenchanting.registry;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Utils;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    private static Item.Settings foodItem(FoodComponent component){
        return new Item.Settings().food(component);
    }

    public static void registerModItems(){
        BetterEnchanting.LOGGER.info("Registering mod iems for : "+ BetterEnchanting.MOD_ID);
    }


    //region MATERIALS
    //public static final Item STEEL_BLEND = registerItem("steel_blend", new Item(new Item.Settings()));
    //public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    //endregion

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
    public static final Item ESSENCE_OF_EXPERIENCE = registerItem("essence_of_experience", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
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

    //bows
    public static final Item ESSENCE_OF_ARROWS = registerItem("essence_of_arrows", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_POWER = registerItem("essence_of_power", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_PUNCH = registerItem("essence_of_punch", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //endregion

    private static Item registerItem(String id, Item item){
        Item i = Registry.register(Registries.ITEM, Utils.id(id), item);
        MOD_ITEM_LIST.add(i);
        return i;
    }



}