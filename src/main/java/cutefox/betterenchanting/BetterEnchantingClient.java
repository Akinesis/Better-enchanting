package cutefox.betterenchanting;

import cutefox.betterenchanting.registry.ModHandledScreens;
import net.fabricmc.api.ClientModInitializer;

public class BetterEnchantingClient implements ClientModInitializer {


	@Override
	public void onInitializeClient() {
		ModHandledScreens.registerModScreen();
	}
}