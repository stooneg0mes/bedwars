package net.stonegomes.bedwars.listener.player;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.state.GameState;
import net.stonegomes.bedwars.game.arena.state.WaitingPlayersGameState;
import net.stonegomes.bedwars.game.arena.state.StartingGameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

@AllArgsConstructor
public class PlayerDropPickupItemListener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handlePlayerDrop(PlayerDropItemEvent event) {
        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(event.getPlayer());
        if (gameArena == null) return;

        final GameState gameState = gameArena.getGameState();
        final boolean isStarterState = (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState);

        event.setCancelled(isStarterState);
    }

    @EventHandler
    public void handlePlayerPickup(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;

        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(player);
        if (gameArena == null) return;

        final GameState gameState = gameArena.getGameState();
        final boolean isStarterState = (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState);

        event.setCancelled(isStarterState);
    }

}