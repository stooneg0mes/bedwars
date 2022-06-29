package net.stonegomes.bedwars.listener.traffic;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.scoreboard.fast.FastBoard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

@RequiredArgsConstructor
public class ScoreboardTrafficListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handlePlayerQuit(PlayerQuitEvent event) {
        final UUID playerUuid = event.getPlayer().getUniqueId();
        final FastBoard fastBoard = gamePlugin.getScoreboardCache().getFastBoard(playerUuid);
        if (fastBoard == null) return;

        gamePlugin.getScoreboardCache().removeFastBoard(playerUuid);
    }

}
