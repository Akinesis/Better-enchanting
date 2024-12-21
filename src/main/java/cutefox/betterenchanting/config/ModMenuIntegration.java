package cutefox.betterenchanting.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import eu.midnightdust.lib.config.MidnightConfig;

public class ModMenuIntegration{

    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> MidnightConfig.getScreen(parent, "better-enchanting/BetterEnchanting");
    }

}
