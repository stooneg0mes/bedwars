package net.stonegomes.bedwars.core.arena.player;

import net.stonegomes.bedwars.core.arena.island.GameIsland;
import net.stonegomes.bedwars.core.arena.island.team.GameTeamColor;

import java.util.*;

public class GamePlayerMap {

    private final Map<UUID, GamePlayer> playerMap = new HashMap<>();

    /**
     * Put a player in the map.
     *
     * @param uuid the uuid of the player
     * @param gamePlayer the player
     */
    public void putPlayer(UUID uuid, GamePlayer gamePlayer) {
        playerMap.put(uuid, gamePlayer);
    }

    /**
     * Remove a player from the cache.
     *
     * @param uuid the uuid of the player
     */
    public void removePlayer(UUID uuid) {
        playerMap.remove(uuid);
    }

    /**
     * Get a player from the cache.
     *
     * @param uuid the uuid of the player
     * @return the player
     */
    public GamePlayer getPlayer(UUID uuid) {
        return playerMap.get(uuid);
    }

    /**
     * Get all players in the cache.
     *
     * @return the players
     */
    public Collection<GamePlayer> getPlayers() {
        return playerMap.values();
    }

}