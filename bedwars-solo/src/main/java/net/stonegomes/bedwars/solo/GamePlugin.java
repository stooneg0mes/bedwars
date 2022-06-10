package net.stonegomes.bedwars.solo;

import net.stonegomes.bedwars.commons.ModulePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.core.state.GameManager;
import net.stonegomes.bedwars.solo.module.GameModule;
import net.stonegomes.bedwars.solo.module.ListenerModule;
import net.stonegomes.bedwars.solo.module.RunnableModule;
import org.bukkit.Bukkit;

public class GamePlugin extends ModulePlugin {

    @Override
    public void handleLoad() {
        Bukkit.getLogger().info("Plugin loading.");
    }

    @Override
    public void handleEnable() {
        Bukkit.getLogger().info("Plugin enabling.");
    }

    @Override
    public void handleDisable() {
        Bukkit.getLogger().info("Plugin disabling.");
    }

    @Override
    public Module[] getModules() {
        return new Module[] {
            new GameModule(this),
            new ListenerModule(this),
            new RunnableModule(this)
        };
    }

    public GameManager getGameManager() {
        return ((GameModule) getModule(GameModule.class)).getGameManager();
    }

    public GameBuildCache getBuildCache() {
        return ((GameModule) getModule(GameModule.class)).getBuildCache();
    }

    public GamePlayerCache getPlayerCache() {
        return ((GameModule) getModule(GameModule.class)).getPlayerCache();
    }

    public static GamePlugin getInstance() {
        return GamePlugin.getPlugin(GamePlugin.class);
    }

}
