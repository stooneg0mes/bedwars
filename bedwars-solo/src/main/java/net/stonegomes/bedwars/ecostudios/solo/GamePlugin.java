package net.stonegomes.bedwars.ecostudios.solo;

import net.stonegomes.bedwars.commons.ModulePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.core.arena.build.GameBuildSet;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.arena.player.GamePlayerMap;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.ecostudios.solo.module.GameModule;
import net.stonegomes.bedwars.ecostudios.solo.module.ListenerModule;
import net.stonegomes.bedwars.ecostudios.solo.module.RunnableModule;
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
            new GameModule(),
            new ListenerModule(this),
            new RunnableModule(this)
        };
    }

    public GameManager getGameManager() {
        return ((GameModule) getModule(GameModule.class)).getGameManager();
    }

    public GameBuildSet getBuildCache() {
        return ((GameModule) getModule(GameModule.class)).getBuildCache();
    }

    public GamePlayerMap getPlayerCache() {
        return ((GameModule) getModule(GameModule.class)).getPlayerCache();
    }

    public GameArenaCache getMapCache() {
        return ((GameModule) getModule(GameModule.class)).getMapCache();
    }

    public GameArenaDao getMapDao() {
        return ((GameModule) getModule(GameModule.class)).getMapDao();
    }

    public static GamePlugin getInstance() {
        return GamePlugin.getPlugin(GamePlugin.class);
    }

}
