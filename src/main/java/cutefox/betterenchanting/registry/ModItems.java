package cutefox.betterenchanting.registry;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Utils;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {

    private static Item.Settings foodItem(FoodComponent component){
        return new Item.Settings().food(component);
    }

    public static void registerModItems(){
        BetterEnchanting.LOGGER.info("Registering mod iems for : "+ BetterEnchanting.MOD_ID);
    }


    //region MATERIALS
    public static final Item STEEL_BLEND = registerItem("steel_blend", new Item(new Item.Settings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    //endregion

    //region ENCHANTMENT INGREDIENTS

    public static final Item ESSENCE_OF_PROTECTION = registerItem("essence_of_protection", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item ESSENCE_OF_FIRE_PROTECTION = registerItem("essence_of_fire_protection", new Item(new Item.Settings().maxCount(1).fireproof().component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //endregion

    public static Item CUSTOM_ENCHANTING_TABLE;


    private static Item registerItem(String id, Item item){
        return Registry.register(Registries.ITEM, Utils.id(id), item);
    }



}