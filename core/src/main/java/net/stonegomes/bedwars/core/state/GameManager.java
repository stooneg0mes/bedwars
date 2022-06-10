package net.stonegomes.bedwars.core.state;

import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import org.bukkit.entity.Player;

public interface GameManager {

    /**
     * Get the game build cache.
     *
     * @return the game build cache
     */
    GameBuildCache getBuildCache();

    /**
     * Get the game player cache.
     *
     * @return the game player cache
     */
    GamePlayerCache getPlayerCache();

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
     * Build a new {@link GameStateContext} for the given player.
     *
     * @param player the player to build the context for
     * @return the built context
     */
    GameStateContext buildContext(Player player);


    /**
     * Build a new {@link GameStateContext} for the given player and state.
     *
     * @param player the player to build the context
     * @param gameState the state to build the context
     * @return the built context
     */
    GameStateContext buildContext(Player player, GameState gameState);

}
