package net.stonegomes.bedwars;

import net.stonegomes.bedwars.commons.ModulePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.scoreboard.ScoreboardCache;
import net.stonegomes.bedwars.module.GameArenaModule;
import net.stonegomes.bedwars.module.ListenerModule;
import net.stonegomes.bedwars.module.RunnableModule;
import net.stonegomes.bedwars.module.ScoreboardModule;
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
            new GameArenaModule(),
            new ScoreboardModule(),
            new ListenerModule(this),
            new RunnableModule(this)
        };
    }

    public GameArenaCache getArenaCache() {
        return ((GameArenaModule) getModule(GameArenaModule.class)).getArenaCache();
    }

    public GameArenaDao getArenaDao() {
        return ((GameArenaModule) getModule(GameArenaModule.class)).getArenaDao();
    }

    public ScoreboardCache getScoreboardCache() {
        return ((ScoreboardModule) getModule(ScoreboardModule.class)).getScoreboardCache();
    }

    public static GamePlugin getInstance() {
        return GamePlugin.getPlugin(GamePlugin.class);
    }

}
