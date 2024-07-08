package cutefox.betterenchanting.registry;

import cutefox.betterenchanting.BetterEnchantingFabric;
import cutefox.betterenchanting.screen.CustomEnchantmentScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class ModHandledScreens {

    public static void registerModScreen(){
        BetterEnchantingFabric.LOGGER.info("Registering mod screens for : "+ BetterEnchantingFabric.MOD_ID);
        HandledScreens.register(ModScreenHandlerType.CUSTOM_ENCHANTMENT_SCREEN_HANDLER, CustomEnchantmentScreen::new);
    }

}
