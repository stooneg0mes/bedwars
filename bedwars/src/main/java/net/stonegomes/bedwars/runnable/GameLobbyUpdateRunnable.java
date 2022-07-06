package net.stonegomes.bedwars.runnable;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.scoreboard.lib.FastBoard;
import net.stonegomes.bedwars.lobby.GameLobbyScoreboardFactory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class GameLobbyUpdateRunnable extends BukkitRunnable {

    private final GamePlugin gamePlugin;

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(player);
            if (gameArena != null) continue;

            FastBoard fastBoard = gamePlugin.getScoreboardCache().createOrGetFastBoard(player);
            GameLobbyScoreboardFactory.updateLobbyScoreboard(fastBoard);
        }
    }

}
