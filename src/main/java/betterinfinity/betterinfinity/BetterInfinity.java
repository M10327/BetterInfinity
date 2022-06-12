package betterinfinity.betterinfinity;

import betterinfinity.betterinfinity.Handlers.BowFireHandler;
import betterinfinity.betterinfinity.Handlers.CrossbowReloadHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterInfinity extends JavaPlugin {

    @Override
    public void onEnable() {
        new BowFireHandler(this);
        new CrossbowReloadHandler(this);
    }

    @Override
    public void onDisable() {
    }
}
