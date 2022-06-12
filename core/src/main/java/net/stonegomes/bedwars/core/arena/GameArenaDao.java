package net.stonegomes.bedwars.core.arena;

import java.util.Collection;
import java.util.UUID;

public interface GameArenaDao {

    /**
     * Replace the game arena in the database.
     *
     * @param gameArena the game arena
     */
    void replace(GameArena gameArena);

    /**
     * Delete a game arena from the database.
     *
     * @param uuid the game arena's unique id
     */
    void delete(UUID uuid);

    /**
     * Get a game arena from the database.
     *
     * @param uuid the game arena's unique id
     * @return the game arena
     */
    GameArena find(UUID uuid);

    /**
     * Get all game arenas from the database.
     *
     * @return all game arenas
     */
    Collection<GameArena> find();

}
