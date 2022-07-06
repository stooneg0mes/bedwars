package net.stonegomes.bedwars.listener.player;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

@RequiredArgsConstructor
public class PlayerDeathListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handlePlayerDeath(PlayerDeathEvent event) {
        event.deathMessage(null);

        final Player player = event.getPlayer();
        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(player);
        if (gameArena == null) return;

        final GamePlayer gamePlayer = gameArena.getPlayerMap().getGamePlayer(player.getUniqueId());
        if (gamePlayer == null) return;

        GameStateContext gameStateContext = gamePlugin.getGameManager().buildContext(player);
        gameArena.getGameState().onDeath(gameStateContext);
    }

}
