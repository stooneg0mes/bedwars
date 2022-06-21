package net.stonegomes.bedwars.runnable;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.scoreboard.fast.FastBoard;
import net.stonegomes.bedwars.game.scoreboard.ScoreboardFactory;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class GameLobbyUpdateRunnable extends BukkitRunnable {

    private final GamePlugin gamePlugin;

    @Override
    public void run() {
        for (Player player : gamePlugin.getLobby().getPlayers()) {
            FastBoard fastBoard = gamePlugin.getScoreboardCache().createOrGetFastBoard(player);
            ScoreboardFactory.updateLobbyScoreboard(fastBoard);
        }
    }

}
