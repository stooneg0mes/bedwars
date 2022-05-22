package net.stonegomes.core.runnable;

import lombok.AllArgsConstructor;
import net.stonegomes.core.game.GameManager;
import net.stonegomes.core.game.GameState;
import net.stonegomes.core.game.GameStateContext;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@AllArgsConstructor
public class GameRunnable extends BukkitRunnable {

    private final GameManager gameManager;

    @Override
    public void run() {
        GameState gameState = gameManager.getGameState();
        if (gameState == null) return;

        for (Player player : Bukkit.getOnlinePlayers()) {
            GameStateContext gameStateContext = new GameStateContext(gameState, player);
            gameState.onUpdate(gameStateContext);
        }
    }

}
