package net.stonegomes.bedwars.core.arena.player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GamePlayerMap {

    private final Map<UUID, GamePlayer> playerMap = new HashMap<>();

    /**
     * Put a game player in the map.
     *
     * @param uuid       the uuid of the game player
     * @param gamePlayer the player
     */
    public void putGamePlayer(UUID uuid, GamePlayer gamePlayer) {
        playerMap.put(uuid, gamePlayer);
    }

    /**
     * Remove a game player from the cache.
     *
     * @param uuid the uuid of the game player
     */
    public void removeGamePlayer(UUID uuid) {
        playerMap.remove(uuid);
    }

    /**
     * Check if a game player is in the map.
     *
     * @param uuid the uuid of the game player
     * @return if the game player is in the map
     */
    public boolean hasGamePlayer(UUID uuid) {
        return getGamePlayer(uuid) != null;
    }

    /**
     * Get a game player from the cache.
     *
     * @param uuid the uuid of the game player
     * @return the player
     */
    public GamePlayer getGamePlayer(UUID uuid) {
        return playerMap.get(uuid);
    }

    /**
     * Get all game players in the cache.
     *
     * @return the game players
     */
    public Collection<GamePlayer> values() {
        return playerMap.values();
    }

    /**
     * Get the size of the cache.
     *
     * @return the size
     */
    public int size() {
        return playerMap.size();
    }

}