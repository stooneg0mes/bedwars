package net.stonegomes.bedwars;

import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModulePlugin;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import net.stonegomes.bedwars.core.process.ProcessCache;
import net.stonegomes.bedwars.core.scoreboard.ScoreboardCache;
import net.stonegomes.bedwars.module.GameModule;
import net.stonegomes.bedwars.module.ListenerModule;
import net.stonegomes.bedwars.module.RunnableModule;
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
        return new Module[]{
            new GameModule(),
            new ListenerModule(this),
            new RunnableModule(this)
        };
    }

    public GameManager getGameManager() {
        return ((GameModule) getModule(GameModule.class)).getGameManager();
    }

    public GameArenaCache getArenaCache() {
        return ((GameModule) getModule(GameModule.class)).getArenaCache();
    }

    public GameArenaDao getArenaDao() {
        return ((GameModule) getModule(GameModule.class)).getArenaDao();
    }

    public ScoreboardCache getScoreboardCache() {
        return ((GameModule) getModule(GameModule.class)).getScoreboardCache();
    }

    public ProcessCache getProcessCache() {
        return ((GameModule) getModule(GameModule.class)).getProcessCache();
    }

    public GameLobby getLobby() {
        return ((GameModule) getModule(GameModule.class)).getLobby();
    }

    public static GamePlugin getInstance() {
        return GamePlugin.getPlugin(GamePlugin.class);
    }

}
