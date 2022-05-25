package net.stonegomes.bedwars.solo.runnable;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameStateContext;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@AllArgsConstructor
public class GameUpdateRunnable extends BukkitRunnable {

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
