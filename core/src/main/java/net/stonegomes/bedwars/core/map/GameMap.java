package net.stonegomes.bedwars.core.map;

import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.map.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.map.island.GameIslandMap;
import net.stonegomes.bedwars.core.map.island.npc.GameNpcMap;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.UUID;

public interface GameMap {

    /**
     * Get the game map unique id
     *
     * @return the map unique id
     */
    UUID getUniqueId();

    /**
     * Get the game map world
     *
     * @return the map world
     */
    World getWorld();

    /**
     * Get the game map name
     *
     * @return the map name
     */
    String getName();

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
     * Get the game map waiting spawn location
     *
     * @return the waiting spawn location
     */
    Location getWaitingSpawnLocation();

    /**
     * Get the game map waiting build cuboid
     *
     * @return the waiting cuboid
     */
    Cuboid getWaitingCuboid();

}
