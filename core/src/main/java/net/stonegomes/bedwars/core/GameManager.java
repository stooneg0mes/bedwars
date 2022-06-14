package net.stonegomes.bedwars.core;

import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import net.stonegomes.bedwars.core.process.ProcessCache;
import net.stonegomes.bedwars.core.scoreboard.ScoreboardCache;
import org.bukkit.entity.Player;

public interface GameManager {

    /**
     * Get the game arena cache
     *
     * @return the arena cache
     */
    GameArenaCache getArenaCache();

    /**
     * Get the game arena dao
     *
     * @return the arena dao
     */
    GameArenaDao getArenaDao();

    /**
     * Get the scoreboard cache
     *
     * @return the scoreboard cache
     */
    ScoreboardCache getScoreboardCache();

    /**
     * Get the process cache
     *
     * @return the process cache
     */
    ProcessCache getProcessCache();

    /**
     * Get the game lobby
     *
     * @return the lobby
     */
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
