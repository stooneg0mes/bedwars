package net.stonegomes.bedwars;

import lombok.experimental.Delegate;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleBootstrap;
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
import net.stonegomes.bedwars.module.ViewModule;
import org.bukkit.Bukkit;

public class GamePlugin extends ModulePlugin {

    @Delegate(excludes = ModuleBootstrap.class)
    private GameModule gameModule;

    @Delegate(excludes = ModuleBootstrap.class)
    private ViewModule viewModule;

    @Override
    public Module[] getModules() {
        return new Module[]{
            new GameModule(),
            new ViewModule(this),
            new ListenerModule(this),
            new RunnableModule(this)
        };
    }

    public static GamePlugin getInstance() {
        return GamePlugin.getPlugin(GamePlugin.class);
    }

}
