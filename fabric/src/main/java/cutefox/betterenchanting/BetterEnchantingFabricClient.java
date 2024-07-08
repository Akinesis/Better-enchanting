package cutefox.betterenchanting;

import cutefox.betterenchanting.registry.ModHandledScreens;
import net.fabricmc.api.ClientModInitializer;

public class BetterEnchantingFabricClient implements ClientModInitializer {


	@Override
	public void onInitializeClient() {
		ModHandledScreens.registerModScreen();
	}
}