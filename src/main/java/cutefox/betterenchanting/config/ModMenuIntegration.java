package cutefox.betterenchanting.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import eu.midnightdust.lib.config.MidnightConfig;

import java.util.Map;

public class ModMenuIntegration implements ModMenuApi {

    /*@Override
    public Map<String, ConfigScreenFactory<?>> getProvidedConfigScreenFactories() {
        return parent -> MidnightConfig.getScreen(parent, "better-enchanting/betterEnchanting");
    }*/

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> GlobalConfig.getScreen(parent, "better-enchanting/betterEnchanting");
    }
}
