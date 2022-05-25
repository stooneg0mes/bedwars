package net.stonegomes.bedwars.solo.module;

import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.listener.GameBuildListener;
import net.stonegomes.bedwars.solo.listener.traffic.GameStateTrafficListener;
import net.stonegomes.bedwars.solo.listener.traffic.MessageTrafficListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

@ModuleId(id = "listenerModule")
public class ListenerModule extends Module {

    private final GamePlugin gamePlugin;

    private final GameManager gameManager;
    private final GameBuildCache gameBuildCache;
    private final GamePlayerCache gamePlayerCache;

    public ListenerModule(GamePlugin gamePlugin) {
        this.gamePlugin = gamePlugin;

        this.gameManager = gamePlugin.getGameManager();
        this.gamePlayerCache = gamePlugin.getPlayerCache();
        this.gameBuildCache = gamePlugin.getBuildCache();
    }

    @Override
    public void handleEnable() {
        final PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new MessageTrafficListener(), gamePlugin);
        pluginManager.registerEvents(new GameStateTrafficListener(gameManager), gamePlugin);
        pluginManager.registerEvents(new GameBuildListener(gameBuildCache), gamePlugin);
    }

}
