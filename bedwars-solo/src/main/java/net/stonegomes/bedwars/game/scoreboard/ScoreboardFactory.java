package net.stonegomes.bedwars.game.scoreboard;

import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.scoreboard.fast.FastBoard;
import org.bukkit.Bukkit;

import java.util.List;

public class ScoreboardFactory {

    private static final GamePlugin gamePlugin = GamePlugin.getInstance();

    public static void updateLobbyScoreboard(FastBoard fastBoard) {
        final List<GameArena> availableGames = gamePlugin.getArenaCache().values().stream()
            .filter(gameArena -> gameArena.getGameState().canEnter())
            .toList();

        fastBoard.updateLines(
            "§e§lLOBBY",
            "",
            "§fOnline players: " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers(),
            "§fAvailable games: " + availableGames.size(),
            "",
            "§7Click on the NPC to join a game",
            "§7and have some fun!",
            "",
            "§eexample.net"
        );
    }

}
