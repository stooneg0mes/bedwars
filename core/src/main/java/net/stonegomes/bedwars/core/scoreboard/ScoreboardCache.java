package net.stonegomes.bedwars.core.scoreboard;

import net.stonegomes.bedwars.core.scoreboard.fast.FastBoard;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

public interface ScoreboardCache {

    /**
     * Put a fast board into the cache.
     *
     * @param uuid      the player uuid
     * @param fastBoard the fast board
     */
    void putFastBoard(UUID uuid, FastBoard fastBoard);

    /**
     * Get a fast board from the cache.
     *
     * @param uuid the player uuid
     * @return the fast board
     */
    FastBoard getFastBoard(UUID uuid);

    /**
     * Check if a fast board is in the cache.
     *
     * @param uuid the player uuid
     * @return if the fast board is in the cache
     */
    boolean hasFastBoard(UUID uuid);

    /**
     * Remove a fast board from the cache.
     *
     * @param uuid the player uuid
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
     * @param player the player
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
