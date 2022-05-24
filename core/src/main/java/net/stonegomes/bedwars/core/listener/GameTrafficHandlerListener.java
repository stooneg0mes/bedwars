package net.stonegomes.bedwars.core.listener;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.game.GameStateContext;
import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameStateType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@AllArgsConstructor
public class GameTrafficHandlerListener implements Listener {

    private final GameManager gameManager;

    @EventHandler
    public void handleJoin(PlayerJoinEvent event) {
        GameState gameState = gameManager.getGameState();
        if (gameState == null || gameState.getStateType() != GameStateType.JOIN_SERVER) return;

        GameStateContext gameStateContext = new GameStateContext(gameState, event.getPlayer());
        gameState.onEnter(gameStateContext);
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent event) {
        GameState gameState = gameManager.getGameState();
        if (gameState == null) return;

        GameStateContext gameStateContext = new GameStateContext(gameState, event.getPlayer());
        gameState.onQuit(gameStateContext);
    }

}
