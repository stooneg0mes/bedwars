package net.stonegomes.bedwars.core.arena;

import net.stonegomes.bedwars.core.player.GamePlayer;

import java.util.Collection;
import java.util.UUID;

public interface GameArenaCache {

    /**
     * Put a game arena into the cache.
     *
     * @param uuid the game arena's unique id
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
     * Get a game arena from the cache.
     *
     * @param uuid the arena's unique id
     * @return the game arena
     */
    GameArena getGameArena(UUID uuid);

    /**
     * Get all game arenas from the cache.
     *
     * @return all arenas
     */
    Collection<GameArena> getGameArenas();

}