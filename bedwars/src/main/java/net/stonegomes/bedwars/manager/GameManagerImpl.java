package net.stonegomes.bedwars.manager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import net.stonegomes.bedwars.core.process.ProcessCache;
import net.stonegomes.bedwars.core.scoreboard.ScoreboardCache;
import org.bukkit.entity.Player;

@AllArgsConstructor
@Getter
public class GameManagerImpl implements GameManager {

    private final GameArenaCache arenaCache;
    private final GameArenaDao arenaDao;

    private final ScoreboardCache scoreboardCache;

    private final ProcessCache processCache;

    private final GameLobby lobby;

    @Override
    public GameStateContext buildContext(Player player) {
        final GameArena gameArena = arenaCache.getGameArena(player);

        return GameStateContext.builder()
            .gameManager(this)
            .gamePlayer(gameArena.getPlayerMap().getGamePlayer(player.getUniqueId()))
            .gameArena(gameArena)
            .build();
    }

    @Override
    public GameStateContext buildContext(Player player, GameArena gameArena) {
        return GameStateContext.builder()
            .gameManager(this)
            .gamePlayer(gameArena.getPlayerMap().getGamePlayer(player.getUniqueId()))
            .gameArena(gameArena)
            .build();
    }

}
