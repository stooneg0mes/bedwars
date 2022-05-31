package net.stonegomes.bedwars.solo.listener.traffic;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@AllArgsConstructor
public class GamePlayerTrafficListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handleJoin(PlayerJoinEvent event) {
        final GamePlayer gamePlayer = GamePlayer.builder()
            .uniqueId(event.getPlayer().getUniqueId())
            .gameIsland(null)
            .build();

        gamePlugin.getPlayerCache().putGamePlayer(gamePlayer.getUniqueId(), gamePlayer);
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent event) {
        gamePlugin.getPlayerCache().removeGamePlayer(event.getPlayer().getUniqueId());
    }

}