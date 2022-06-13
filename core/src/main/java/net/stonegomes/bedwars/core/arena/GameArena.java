package net.stonegomes.bedwars.core.arena;

import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.arena.build.GameBuildSet;
import net.stonegomes.bedwars.core.arena.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.arena.island.GameIslandMap;
import net.stonegomes.bedwars.core.arena.island.npc.GameNpcMap;
import net.stonegomes.bedwars.core.arena.player.GamePlayerMap;
import net.stonegomes.bedwars.core.arena.state.GameState;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;
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

}
