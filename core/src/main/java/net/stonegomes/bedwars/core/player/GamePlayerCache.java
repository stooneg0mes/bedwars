package net.stonegomes.bedwars.core.player;

import java.util.Collection;
import java.util.UUID;

public interface GamePlayerCache {

    /**
     * Put a game player into the cache.
     * @param uuid the player's unique id
     * @param gamePlayer the game player
     */
    void putGamePlayer(UUID uuid, GamePlayer gamePlayer);

    /**
     * Remove a game player from the cache.
     * @param uuid the player's unique id
     */
    void removeGamePlayer(UUID uuid);

    /**
     * Get a game player from the cache.
     * @param uuid the player's unique id
     * @return the game player
     */
    GamePlayer getGamePlayer(UUID uuid);

    /**
     * Get all game players from the cache.
     * @return all game players
     */
    Collection<GamePlayer> getGamePlayers();

}