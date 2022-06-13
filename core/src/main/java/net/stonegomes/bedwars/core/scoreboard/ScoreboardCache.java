package net.stonegomes.bedwars.core.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

public interface ScoreboardCache {

    /**
     * Put a game arena into the cache.
     *
     * @param uuid the game arena's unique id
     * @param fastBoard the fast board
     */
    void putFastBoard(UUID uuid, FastBoard fastBoard);

    /**
     * Get a fast board from the cache.
     *
     * @param uuid the fast board's unique id
     * @return the fast board
     */
    FastBoard getFastBoard(UUID uuid);

    /**
     * Check if the fast board is in the cache.
     *
     * @param uuid the fast board's unique id
     * @return if the fast board is in the cache
     */
    boolean hasFastBoard(UUID uuid);

    /**
     * Remove a fast board from the cache.
     *
     * @param uuid the fast board's unique id
     */
    void removeFastBoard(UUID uuid);

    /**
     * Get all fast boards from the cache.
     *
     * @return all fast boards
     */
    Collection<FastBoard> getFastBoards();

    /**
     * Create a fast board if not in the cache or get if already on the cache
     *
     * @param player the fast board player
     * @return the fast board
     */
    default FastBoard createOrGetFastBoard(Player player) {
        FastBoard fastBoard = getFastBoard(player.getUniqueId());
        if (fastBoard == null) {
            fastBoard = new FastBoard(player);
            putFastBoard(player.getUniqueId(), fastBoard);
        }

        return fastBoard;
    }

}
