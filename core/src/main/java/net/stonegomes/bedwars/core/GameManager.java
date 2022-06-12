package net.stonegomes.bedwars.core;

import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import org.bukkit.entity.Player;

public interface GameManager {

    /**
     * Get the game arena cache.
     *
     * @return the arena cache
     */
    GameArenaCache getArenaCache();

    /**
     * Get the game arena dao.
     *
     * @return the arena dao
     */
    GameArenaDao getArenaDao();

    /**
     * Get the current game arena
     *
     * @return the current arena
     */
    GameArena getGameArena();

    /**
     * Set the current game arena
     *
     * @param gameArena the new game arena
     */
    void setGameArena(GameArena gameArena);

    /**
     * Get the current game state.
     *
     * @return the current state
     */
    GameState getGameState();

    /**
     * Set the current game state.
     *
     * @param gameState the new state
     */
    void setGameState(GameState gameState);

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
     * @param gameState the state to build the context
     * @return the built context
     */
    GameStateContext buildContext(Player player, GameState gameState);

    /**
     * Check if the game is on setup mode.
     *
     * @return if the game is on setup mode
     */
    boolean isOnSetup();

}
