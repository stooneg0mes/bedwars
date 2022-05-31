package net.stonegomes.bedwars.core.state;

import org.bukkit.entity.Player;

public interface GameManager {


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
