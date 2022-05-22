package net.stonegomes.game.game.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.commons.Module;
import net.stonegomes.commons.ModuleId;
import net.stonegomes.core.game.GameManager;
import net.stonegomes.core.game.GameState;
import net.stonegomes.core.listener.TrafficListener;
import net.stonegomes.core.runnable.GameRunnable;
import net.stonegomes.game.GamePlugin;
import net.stonegomes.game.game.WaitingPlayersStateImpl;
import net.stonegomes.game.game.manager.GameManagerImpl;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

@ModuleId(id = "gameModule")
@RequiredArgsConstructor
public class GameModule extends Module {

    private final GamePlugin gamePlugin;

    @Getter
    private GameManager gameManager;

    @Override
    public void handleEnable() {
        gameManager = new GameManagerImpl();
        gameManager.setGameState(new WaitingPlayersStateImpl());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new TrafficListener(gameManager), gamePlugin);

        new GameRunnable(gameManager).runTaskTimerAsynchronously(gamePlugin, 0L, 20L);
    }

}
