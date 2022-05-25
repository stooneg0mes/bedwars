package net.stonegomes.bedwars.solo.listener.traffic;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.game.GameStateContext;
import net.stonegomes.bedwars.core.game.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@AllArgsConstructor
public class GameStateTrafficListener implements Listener {

    private final GameManager gameManager;

    @EventHandler
    public void handleJoin(PlayerJoinEvent event) {
        GameState gameState = gameManager.getGameState();
        if (gameState == null || !gameState.isFirstState()) return;

        GameStateContext gameStateContext = gameManager.buildContext(event.getPlayer());
        gameState.onEnter(gameStateContext);
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent event) {
        GameState gameState = gameManager.getGameState();
        if (gameState == null) return;

        GameStateContext gameStateContext = gameManager.buildContext(event.getPlayer());
        gameState.onQuit(gameStateContext);
    }

}