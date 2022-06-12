package net.stonegomes.bedwars.listener.food;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.state.GameState;
import net.stonegomes.bedwars.game.state.WaitingPlayersGameState;
import net.stonegomes.bedwars.game.state.StartingGameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

@AllArgsConstructor
public class FoodLevelChangeListener implements Listener {

    private final GamePlugin gamePlugin;
    
    @EventHandler
    public void handleFoodLevelChange(FoodLevelChangeEvent event) {
        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(event.getEntity());
        if (gameArena == null) return;

        final GameState gameState = gameArena.getGameState();
        final boolean isStarterState = (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState);

        event.setCancelled(isStarterState);
    }

}
