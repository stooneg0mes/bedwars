package net.stonegomes.bedwars.solo.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.listener.GameTrafficHandlerListener;
import net.stonegomes.bedwars.core.runnable.GameRunnable;
import net.stonegomes.bedwars.solo.game.manager.GameManagerImpl;
import net.stonegomes.bedwars.solo.game.state.WaitingPlayersState;
import org.bukkit.Bukkit;

@ModuleId(id = "gameModule")
@RequiredArgsConstructor
public class GameModule extends Module {

    private final GamePlugin gamePlugin;

    @Getter
    private GameManager gameManager;

    @Override
    public void handleEnable() {
        gameManager = new GameManagerImpl();
        gameManager.setGameState(new WaitingPlayersState());

        Bukkit.getPluginManager().registerEvents(new GameTrafficHandlerListener(gameManager), gamePlugin);

        new GameRunnable(gameManager).runTaskTimerAsynchronously(gamePlugin, 0L, 20L);
    }

}
