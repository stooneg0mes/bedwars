package net.stonegomes.bedwars.core.arena;

import java.util.Collection;
import java.util.UUID;

public interface GameArenaCache {

    /**
     * Put a game arena into the cache.
     *
     * @param uuid      the game arena's unique id
     * @param gameArena the game arena
     */
    void putGameMap(UUID uuid, GameArena gameArena);

    /**
     * Remove a game arena from the cache.
     *
     * @param uuid the game arena's unique id
     */
    void removeGameMap(UUID uuid);

    /**
     * Get a game arena from the cache.
     *
     * @param uuid the map's unique id
     * @return the game arena
     */
    GameArena getGameMap(UUID uuid);

    /**
     * Get all game arenas from the cache.
     *
     * @return all maps
     */
    Collection<GameArena> getGameMaps();

}