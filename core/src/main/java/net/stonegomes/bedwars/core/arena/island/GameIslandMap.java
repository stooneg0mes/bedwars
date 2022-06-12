package net.stonegomes.bedwars.core.arena.island;

import net.stonegomes.bedwars.core.arena.island.team.GameTeamColor;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GameIslandMap {

    private final Map<GameTeamColor, GameIsland> islandMap = new HashMap<>();

    /**
     * Put an island in the cache.
     *
     * @param teamColor  the team color of the island
     * @param gameIsland the island
     */
    public void putIsland(GameTeamColor teamColor, GameIsland gameIsland) {
        islandMap.put(teamColor, gameIsland);
    }

    /**
     * Remove an island from the cache.
     *
     * @param teamColor the team color of the island
     */
    public void removeIsland(GameTeamColor teamColor) {
        islandMap.remove(teamColor);
    }

    /**
     * Get an island from the cache.
     *
     * @param teamColor the team color of the island
     * @return the island
     */
    public GameIsland getIsland(GameTeamColor teamColor) {
        return islandMap.get(teamColor);
    }

    /**
     * Get the island with lowest number of players.
     *
     * @return the island
     */
    public GameIsland getLowestIsland() {
        return islandMap.values().stream()
            .min(Comparator.comparingInt(island -> island.getMemberSet().size()))
            .orElse(null);
    }

    /**
     * Get all islands in the cache.
     *
     * @return the islands
     */
    public Collection<GameIsland> getIslands() {
        return islandMap.values();
    }

}