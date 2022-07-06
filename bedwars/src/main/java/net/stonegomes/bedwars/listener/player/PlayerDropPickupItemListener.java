package net.stonegomes.bedwars.listener.player;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

@RequiredArgsConstructor
public class PlayerDropPickupItemListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handlePlayerDrop(PlayerDropItemEvent event) {
        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(event.getPlayer());
        if (gameArena == null) return;

        event.setCancelled(gameArena.getGameState().isStarterState());
    }

    @EventHandler
    public void handlePlayerPickup(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;

        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(player);
        if (gameArena == null) return;

        event.setCancelled(gameArena.getGameState().isStarterState());
    }

}
