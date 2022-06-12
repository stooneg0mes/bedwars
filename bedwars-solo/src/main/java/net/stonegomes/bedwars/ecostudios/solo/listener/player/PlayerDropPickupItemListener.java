package net.stonegomes.bedwars.ecostudios.solo.listener.player;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.ecostudios.solo.GamePlugin;
import net.stonegomes.bedwars.ecostudios.solo.game.state.WaitingPlayersGameState;
import net.stonegomes.bedwars.ecostudios.solo.game.state.StartingGameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

@AllArgsConstructor
public class PlayerDropPickupItemListener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handlePlayerDrop(PlayerDropItemEvent event) {
        final GameState gameState = gamePlugin.getGameManager().getGameState();
        final boolean isStarterState = (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState);

        event.setCancelled(isStarterState);
    }

    @EventHandler
    public void handlePlayerPickup(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        final GameState gameState = gamePlugin.getGameManager().getGameState();
        final boolean isStarterState = (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState);

        event.setCancelled(isStarterState);
    }

}
