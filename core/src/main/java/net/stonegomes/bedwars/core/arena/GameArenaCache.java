package net.stonegomes.bedwars.core.arena;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

public interface GameArenaCache {

    /**
     * Put a game arena into the cache.
     *
     * @param uuid      the game arena's unique id
     * @param gameArena the game arena
     */
    void putGameArena(UUID uuid, GameArena gameArena);

    /**
     * Remove a game arena from the cache.
     *
     * @param uuid the game arena's unique id
     */
    void removeGameArena(UUID uuid);

    /**
     * Get a game arena from the cache by the uuid.
     *
     * @param uuid the map's unique id
     * @return the game arena
     */
    GameArena getGameArena(UUID uuid);

    /**
     * Get a game arena from the cache by the world.
     *
     * @param world the map's world
     * @return the game arena
     */
    GameArena getGameArena(World world);

    /**
     * Get the game arena of a player.
     *
     * @param player the player
     * @return the game arena
     */
    GameArena getGameArena(Player player);

    /**
     * Get the game arena of a block.
     *
     * @param block the block
     * @return the game arena
     */
    default GameArena getGameArena(Block block) {
        return getGameArena(block.getWorld());
    }

    /**
     * Get the game arena of a location.
     *
     * @param location the location
     * @return the game arena
     */
    default GameArena getGameArena(Location location) {
        return getGameArena(location.getWorld());
    }

    /**
     * Get all game arenas from the cache.
     *
     * @return all arenas
     */
    Collection<GameArena> values();

}