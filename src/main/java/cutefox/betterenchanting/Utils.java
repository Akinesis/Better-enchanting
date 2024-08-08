package cutefox.betterenchanting;

import net.minecraft.util.Identifier;

public class Utils {

    public static Identifier id(String path) {
        return Identifier.of("betterenchanting", path);
    }

    public static Identifier id() {
        return Identifier.of("betterenchanting");
    }
}
