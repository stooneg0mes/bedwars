package net.stonegomes.bedwars.lobby;

import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.scoreboard.fast.FastBoard;
import org.bukkit.Bukkit;

import java.util.List;

public class GameLobbyScoreboardFactory {

    private static final GamePlugin gamePlugin = GamePlugin.getInstance();

    public static void updateLobbyScoreboard(FastBoard fastBoard) {
        final List<GameArena> availableGames = gamePlugin.getArenaCache().values().stream()
            .filter(gameArena -> gameArena.getGameState().canEnter())
            .toList();

        fastBoard.updateTitle("§e§lLOBBY");
        fastBoard.updateLines(
            "",
            "§fOnline Players: §e" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers(),
            "§fAvailable Games: §e" + availableGames.size(),
            "",
            "§7Click on the NPC to join",
            "§7a game and have fun!",
            "",
            "§eplay.example.net"
        );
    }

}
