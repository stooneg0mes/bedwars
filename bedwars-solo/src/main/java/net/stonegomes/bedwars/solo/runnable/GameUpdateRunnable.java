package net.stonegomes.bedwars.solo.runnable;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@AllArgsConstructor
public class GameUpdateRunnable extends BukkitRunnable {

    private final GamePlugin gamePlugin;

    @Override
    public void run() {
        GameState gameState = gamePlugin.getGameManager().getGameState();
        if (gameState == null) return;

        for (Player player : Bukkit.getOnlinePlayers()) {
            GameStateContext gameStateContext = gamePlugin.getGameManager().buildContext(player);
            gameState.handleUpdate(gameStateContext);
        }
    }

}
