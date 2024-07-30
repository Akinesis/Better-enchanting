package cutefox.betterenchanting;

import cutefox.betterenchanting.registry.ModItems;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BetterEnchanting {
    public static final Logger LOGGER = LoggerFactory.getLogger("better-enchanting");
    public static final String MOD_ID = "betterenchanting";
    public static final DeferredRegister<ItemGroup> CREATIVE_TAB = DeferredRegister.create(BetterEnchanting.MOD_ID, RegistryKeys.ITEM_GROUP);

    public static final ItemGroup itemGroup = CreativeTabRegistry.create(a -> {
        a.displayName(Text.translatable("itemGroup.better-enchanting.item_group"));
        a.icon(() -> new ItemStack(ModItems.ESSENCE_OF_PROTECTION.get()));
        a.entries((context, entries)->{
            entries.addAll(ModItems.MOD_ITEM_LIST.stream().map(i -> i.getDefaultStack()).toList());
        });
    });

    public static void init() {
        // Write common init code here.

        ModItems.registerModItems();
        //loadCreativeTab();
        /*ModScreenHandlerType.registerModScreenHandlers();
        ModEnchantmentTags.registerModTags();
        ModEnchantIngredientMap.createMap();

        ModItemTags.registerModTags();
        ModLootTables.registerLootTables();*/


    }

    public static void loadCreativeTab(){

        CREATIVE_TAB.register(Utils.id("creative_tab"),() -> itemGroup);

        CREATIVE_TAB.register();

    }
}
