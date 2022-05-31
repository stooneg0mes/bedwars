package net.stonegomes.bedwars.solo.listener.entity;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameTeamColor;
import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.game.state.StartingGameState;
import net.stonegomes.bedwars.solo.game.state.WaitingPlayersGameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

@AllArgsConstructor
public class EntityDamageByEntityListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handleEntityDamage(EntityDamageByEntityEvent event) {
        final GameState gameState = gamePlugin.getGameManager().getGameState();
        if (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState) {
            event.setCancelled(true);
            return;
        }

        final GamePlayer gamePlayer = gamePlugin.getPlayerCache().getGamePlayer(event.getEntity().getUniqueId());
        if (gamePlayer == null) return;

        final GamePlayer gameAttacker = gamePlugin.getPlayerCache().getGamePlayer(event.getDamager().getUniqueId());
        if (gameAttacker == null) return;

        final GameTeamColor playerTeamColor = gamePlayer.getGameIsland().getTeamColor();
        final GameTeamColor attackerTeamColor = gameAttacker.getGameIsland().getTeamColor();;
        event.setCancelled(playerTeamColor == attackerTeamColor);


    }

}
