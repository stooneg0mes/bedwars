package net.stonegomes.bedwars.core.arena;

import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.arena.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.arena.island.GameIslandMap;
import org.bukkit.Location;
import org.bukkit.World;

public interface GameArena {

    /**
     * Get the game arena world
     * @return the arena world
     */
    World getWorld();

    /**
     * Get the game arena name
     * @return the arena name
     */
    String getName();

    /**
     * Get the game island map
     * @return the island map
     */
    GameIslandMap getIslandMap();

    /**
     * Get the game generator map
     * @return the generator map
     */
    GameGeneratorMap getGeneratorMap();

    /**
     * Get the game arena waiting spawn location
     * @return the waiting spawn location
     */
    Location getWaitingSpawnLocation();

    /**
     * Get the game arena waiting build cuboid
     * @return the waiting cuboid
     */
    Cuboid getWaitingCuboid();

}
