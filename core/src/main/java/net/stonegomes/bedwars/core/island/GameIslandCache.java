package net.stonegomes.bedwars.core.island;

import net.stonegomes.bedwars.core.island.team.GameTeamColor;

import java.util.Collection;

public interface GameIslandCache {

    /**
     * Put an island in the cache.
     * @param teamColor the team color of the island
     * @param gameIsland the island
     */
    void putIsland(GameTeamColor teamColor, GameIsland gameIsland);

    /**
     * Remove an island from the cache.
     * @param teamColor the team color of the island
     */
    void removeIsland(GameTeamColor teamColor);

    /**
     * Get an island from the cache.
     * @param teamColor the team color of the island
     * @return the island
     */
    GameIsland getIsland(GameTeamColor teamColor);

    /**
     * Get the island with lowest number of players.
     * @return the island
     */
    GameIsland getLowestIsland();

    /**
     * Get all islands in the cache.
     * @return the islands
     */
    Collection<GameIsland> getIslands();

}