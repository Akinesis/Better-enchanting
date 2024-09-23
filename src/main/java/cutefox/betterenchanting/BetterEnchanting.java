package cutefox.betterenchanting;

import cutefox.betterenchanting.conditions.ModConfigConditions;
import cutefox.betterenchanting.datagen.ModEnchantIngredientMap;
import cutefox.betterenchanting.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BetterEnchanting implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("better-enchanting");
	public static final String MOD_ID = "BetterEnchanting";
	public static boolean NEO_ENCHANT_PRESENT = true;

	@Override
	public void onInitialize() {


		ModConfigConditions.registerConditions();
		ModItems.registerModItems();
		ModScreenHandlerType.registerModScreenHandlers();
		ModEnchantmentTags.registerModTags();
		ModEnchantIngredientMap.createMap();
		ModTradeOffers.removeEnchantedBooks();
		ModItemTags.registerModTags();
		ModLootTables.registerLootTables();

		Registry.register(Registries.ITEM_GROUP, Utils.id("item_group"), ITEM_GROUP);
		PayloadTypeRegistry.playS2C().register(EnchantingIngredientMapPayload.ID, EnchantingIngredientMapPayload.CODEC);

		ModLootTableModifiers.modifyLootTables();

		addEventListner();
		if(FabricLoader.getInstance().isModLoaded("incantationem")){
			LOGGER.info("Mod incantationem is loded ! ");
		}


	}

	private void addEventListner(){
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
		server.execute(() -> {
			ServerPlayNetworking.send(handler.player,
					new EnchantingIngredientMapPayload(ModEnchantIngredientMap.jsonMap));
			});
		});
		ServerLifecycleEvents.SERVER_STARTED.register(e -> {

			//NEO_ENCHANT_PRESENT = true;
			if(e.getResourceManager().getAllNamespaces().contains("enchantplus")){
				NEO_ENCHANT_PRESENT = true;
				ModEnchantIngredientMap.loadNeoEnchantConfig();
			}

			ModEnchantIngredientMap.genMapFromJson(e.getWorld(ServerWorld.OVERWORLD));
		});

	}

	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ModItems.ESSENCE_OF_PROTECTION))
			.displayName(Text.translatable("itemGroup.betterenchanting.item_group"))
			.entries((context, entries) -> {
				entries.addAll(ModItems.MOD_ITEM_LIST.stream().map(i -> i.getDefaultStack()).toList());
			})
			.build();
}