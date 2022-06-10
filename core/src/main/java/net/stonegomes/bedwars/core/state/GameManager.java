package net.stonegomes.bedwars.core.state;

import net.stonegomes.bedwars.core.map.GameMap;
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
     * Get the current game map
     *
     * @return the current map
     */
    GameMap getGameMap();

    /**
     * Set the current game map
     *
     * @param gameMap the new game map
     */
    void setGameMap(GameMap gameMap);

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

}
