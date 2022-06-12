package net.stonegomes.bedwars.core;

import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.build.GameBuildSet;
import net.stonegomes.bedwars.core.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.island.GameIslandMap;
import net.stonegomes.bedwars.core.island.npc.GameNpcMap;
import net.stonegomes.bedwars.core.player.GamePlayerMap;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface GameArena {

    /**
     * Get the game arena unique id
     *
     * @return the arena unique id
     */
    UUID getUniqueId();

    /**
     * Get the game arena world
     *
     * @return the arena world
     */
    World getWorld();

    /**
     * Get the game arena name
     *
     * @return the arena name
     */
    String getName();

    /**
     * Get the game build set
     *
     * @return the build set
     */
    GameBuildSet getBuildSet();

    /**
     * Get the game island map
     *
     * @return the island map
     */
    GameIslandMap getIslandMap();

    /**
     * Get the game generator map
     *
     * @return the generator map
     */
    GameGeneratorMap getGeneratorMap();

    /**
     * Get the game npc map
     *
     * @return the npc map
     */
    GameNpcMap getNpcMap();

    /**
     * Get the game player map
     *
     * @return the player map
     */
    GamePlayerMap getPlayerMap();

    /**
     * Get the game arena waiting spawn location
     *
     * @return the waiting spawn location
     */
    Location getWaitingSpawnLocation();

    /**
     * Get the game arena waiting build cuboid
     *
     * @return the waiting cuboid
     */
    Cuboid getWaitingCuboid();

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
     * Check if the game arena is on setup mode.
     *
     * @return if the arena is on setup
     */
    boolean isOnSetup();

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
