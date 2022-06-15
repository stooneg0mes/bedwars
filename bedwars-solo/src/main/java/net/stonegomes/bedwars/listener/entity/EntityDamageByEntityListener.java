package net.stonegomes.bedwars.listener.entity;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.island.team.GameTeamColor;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import net.stonegomes.bedwars.core.arena.state.GameState;
import net.stonegomes.bedwars.game.arena.state.StartingGameState;
import net.stonegomes.bedwars.game.arena.state.WaitingPlayersGameState;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

@AllArgsConstructor
public class EntityDamageByEntityListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handleEntityDamage(EntityDamageByEntityEvent event) {
        final Entity entity = event.getEntity();
        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(entity.getWorld());
        if (gameArena == null) return;

        final GameState gameState = gameArena.getGameState();
        if (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState) {
            event.setCancelled(true);
            return;
        }

        final GamePlayer gamePlayer = gameArena.getPlayerMap().getGamePlayer(entity.getUniqueId());
        if (gamePlayer == null) return;

        final GamePlayer gameAttacker = gameArena.getPlayerMap().getGamePlayer(event.getDamager().getUniqueId());
        if (gameAttacker == null) return;

        final GameTeamColor playerTeamColor = gamePlayer.getIsland().getTeamColor();
        final GameTeamColor attackerTeamColor = gameAttacker.getIsland().getTeamColor();
        event.setCancelled(playerTeamColor == attackerTeamColor);
    }

}
