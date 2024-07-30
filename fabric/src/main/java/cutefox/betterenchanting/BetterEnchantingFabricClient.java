package cutefox.betterenchanting;

import java.util.*;

import cutefox.betterenchanting.registry.ModEnchantIngredientMap;
import cutefox.betterenchanting.registry.ModHandledScreens;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class BetterEnchantingFabricClient implements ClientModInitializer {


	@Override
	public void onInitializeClient() {
		ModHandledScreens.registerModScreen();
		ClientPlayNetworking.registerGlobalReceiver(EnchantingIngredientMapPayload.ID, (payload, context) -> {
			context.client().execute(() -> {
				Map<String, List<String>> decodedMap = payload.map();
				ModEnchantIngredientMap.genMapFromJsonStringMap(context.client().world, decodedMap);
			});
		});
	}
}