package net.stonegomes.bedwars.scoreboard;

import net.stonegomes.bedwars.core.scoreboard.FastBoard;
import net.stonegomes.bedwars.core.scoreboard.ScoreboardCache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreboardCacheImpl implements ScoreboardCache {

    private final Map<UUID, FastBoard> scoreboardCache = new HashMap<>();

    @Override
    public void putFastBoard(UUID uuid, FastBoard fastBoard) {
        scoreboardCache.put(uuid, fastBoard);
    }

    @Override
    public FastBoard getFastBoard(UUID uuid) {
        return scoreboardCache.get(uuid);
    }

    @Override
    public boolean hasFastBoard(UUID uuid) {
        return getFastBoard(uuid) != null;
    }

    @Override
    public void removeFastBoard(UUID uuid) {
        scoreboardCache.remove(uuid);
    }

    @Override
    public Collection<FastBoard> getFastBoards() {
        return scoreboardCache.values();
    }

}
