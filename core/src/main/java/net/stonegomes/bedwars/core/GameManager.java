package net.stonegomes.bedwars.core;

import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import net.stonegomes.bedwars.core.scoreboard.ScoreboardCache;
import org.bukkit.entity.Player;

public interface GameManager {

    GameArenaCache getArenaCache();

    GameArenaDao getArenaDao();

    ScoreboardCache getScoreboardCache();

    GameLobby getLobby();

    /**
     * Build a new context {@link GameStateContext} for the given player.
     *
     * @param player the player to build the context for
     * @return the built context
     */
    GameStateContext buildContext(Player player);

    /**
     * Build a new {@link GameStateContext} for the given player and state.
     *
     * @param player    the player to build the context
     * @param gameArena the arena to build the context
     * @return the built context
     */
    GameStateContext buildContext(Player player, GameArena gameArena);

}
