package net.stonegomes.bedwars.core.arena;

import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.arena.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.arena.island.GameIslandMap;
import net.stonegomes.bedwars.core.arena.island.npc.GameNpcMap;
import org.bukkit.Location;
import org.bukkit.World;

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

}
