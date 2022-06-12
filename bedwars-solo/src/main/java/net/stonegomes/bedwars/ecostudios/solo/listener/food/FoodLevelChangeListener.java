package net.stonegomes.bedwars.ecostudios.solo.listener.food;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.ecostudios.solo.GamePlugin;
import net.stonegomes.bedwars.ecostudios.solo.game.state.WaitingPlayersGameState;
import net.stonegomes.bedwars.ecostudios.solo.game.state.StartingGameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

@AllArgsConstructor
public class FoodLevelChangeListener implements Listener {

    private final GamePlugin gamePlugin;
    
    @EventHandler
    public void handleFoodLevelChange(FoodLevelChangeEvent event) {
        final GameState gameState = gamePlugin.getGameManager().getGameState();
        final boolean isStarterState = (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState);

        event.setCancelled(isStarterState);
    }

}
