package net.stonegomes.bedwars.core.state;

import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.generator.GameGeneratorCache;
import net.stonegomes.bedwars.core.island.GameIslandCache;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import org.bukkit.entity.Player;

public interface GameManager {


    /**
     * Get the game build cache.
     * @return the game build cache
     */
    GameBuildCache getBuildCache();

    /**
     * Get the game generator cache.
     * @return the game generator cache
     */
    GameGeneratorCache getGeneratorCache();

    /**
     * Get the island cache.
     * @return the island cache
     */
    GameIslandCache getIslandCache();

    /**
     * Get the game player cache.
     * @return the game player cache
     */
    GamePlayerCache getPlayerCache();

    /**
     * Set the current game state.
     * @param gameState the new game state
     */
    void setGameState(GameState gameState);

    /**
     * Get the current game state.
     * @return the current game state
     */
    GameState getGameState();

    /**
     * Build a new GameStateContext for the given player.
     * @param player the player to build the context for
     * @return the built context
     */
    GameStateContext buildContext(Player player);


    /**
     * Build a new GameStateContext for the given player and state.
     * @param player the player to build the context for
     * @param gameState the state to build the context for
     * @return the built context
     */
    GameStateContext buildContext(Player player, GameState gameState);

}
