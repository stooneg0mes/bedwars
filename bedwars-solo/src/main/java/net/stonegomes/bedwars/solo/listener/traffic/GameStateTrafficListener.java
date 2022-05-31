package net.stonegomes.bedwars.solo.listener.traffic;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameStateContext;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@AllArgsConstructor
public class GameStateTrafficListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handleJoin(PlayerJoinEvent event) {
        final GameState gameState = gamePlugin.getGameManager().getGameState();
        if (gameState == null || !gameState.isFirstState()) return;

        final GameStateContext gameStateContext = gamePlugin.getGameManager().buildContext(event.getPlayer());
        gameState.handleEnter(gameStateContext);
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent event) {
        final GameState gameState = gamePlugin.getGameManager().getGameState();
        if (gameState == null) return;

        final GameStateContext gameStateContext = gamePlugin.getGameManager().buildContext(event.getPlayer());
        gameState.handleQuit(gameStateContext);
    }

}