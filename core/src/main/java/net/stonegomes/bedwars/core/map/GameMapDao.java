package net.stonegomes.bedwars.core.map;

import java.util.Collection;
import java.util.UUID;

public interface GameMapDao {

    /**
     * Replace the game map in the database.
     *
     * @param gameMap the game map
     */
    void replace(GameMap gameMap);

    /**
     * Delete a game map from the database.
     *
     * @param uuid the game map's unique id
     */
    void delete(UUID uuid);

    /**
     * Get a game map from the database.
     *
     * @param uuid the game map's unique id
     * @return the game map
     */
    GameMap find(UUID uuid);

    /**
     * Get all game maps from the database.
     *
     * @return all game maps
     */
    Collection<GameMap> find();

}
