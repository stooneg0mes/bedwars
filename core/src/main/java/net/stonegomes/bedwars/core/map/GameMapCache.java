package net.stonegomes.bedwars.core.map;

import java.util.Collection;
import java.util.UUID;

public interface GameMapCache {

    /**
     * Put a game map into the cache.
     *
     * @param uuid      the game map's unique id
     * @param gameMap the game map
     */
    void putGameMap(UUID uuid, GameMap gameMap);

    /**
     * Remove a game map from the cache.
     *
     * @param uuid the game map's unique id
     */
    void removeGameMap(UUID uuid);

    /**
     * Get a game map from the cache.
     *
     * @param uuid the map's unique id
     * @return the game map
     */
    GameMap getGameMap(UUID uuid);

    /**
     * Get all game maps from the cache.
     *
     * @return all maps
     */
    Collection<GameMap> getGameMaps();

}