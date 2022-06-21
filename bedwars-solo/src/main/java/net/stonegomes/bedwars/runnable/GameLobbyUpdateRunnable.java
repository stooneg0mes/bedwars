package net.stonegomes.bedwars.runnable;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.scoreboard.fast.FastBoard;
import net.stonegomes.bedwars.game.scoreboard.ScoreboardFactory;
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
            if (gameArena == null) return;

            FastBoard fastBoard = gamePlugin.getScoreboardCache().createOrGetFastBoard(player);
            ScoreboardFactory.updateLobbyScoreboard(fastBoard);
        }
    }

}