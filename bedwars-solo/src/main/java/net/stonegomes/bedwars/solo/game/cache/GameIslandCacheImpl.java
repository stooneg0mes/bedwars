package net.stonegomes.bedwars.solo.game.cache;

import net.stonegomes.bedwars.core.island.GameIsland;
import net.stonegomes.bedwars.core.island.GameIslandCache;
import net.stonegomes.bedwars.core.island.team.GameTeamColor;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GameIslandCacheImpl implements GameIslandCache {

    private final Map<GameTeamColor, GameIsland> islandCache = new HashMap<>();

    @Override
    public void putIsland(GameTeamColor teamColor, GameIsland gameIsland) {
        islandCache.put(teamColor, gameIsland);
    }

    @Override
    public void removeIsland(GameTeamColor teamColor) {
        islandCache.remove(teamColor);
    }

    @Override
    public GameIsland getIsland(GameTeamColor teamColor) {
        return islandCache.get(teamColor);
    }

    @Override
    public GameIsland getLowestIsland() {
        return islandCache.values().stream()
            .min(Comparator.comparingInt(island -> island.getPlayers().size()))
            .orElse(null);
    }

    @Override
    public Collection<GameIsland> getIslands() {
        return islandCache.values();
    }

}
