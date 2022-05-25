package net.stonegomes.bedwars.solo.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.game.listener.GameTrafficHandlerListener;
import net.stonegomes.bedwars.core.game.runnable.GameUpdateRunnable;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.game.GameManagerImpl;
import net.stonegomes.bedwars.solo.game.build.GameBuildCacheImpl;
import net.stonegomes.bedwars.solo.game.player.GamePlayerCacheImpl;
import net.stonegomes.bedwars.solo.game.state.WaitingGameState;
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
        gameManager.setGameState(new WaitingGameState());

        // Listener

        final PluginManager pluginManager = gamePlugin.getServer().getPluginManager();
        pluginManager.registerEvents(new GameTrafficHandlerListener(gameManager), gamePlugin);

        // Runnable

        new GameUpdateRunnable(gameManager).runTaskTimerAsynchronously(gamePlugin, 0L, 20L);
    }

}
