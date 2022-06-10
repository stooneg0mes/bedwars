package net.stonegomes.bedwars.solo.game.map;

import net.stonegomes.bedwars.core.map.GameMap;
import net.stonegomes.bedwars.core.map.GameMapCache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameMapCacheImpl implements GameMapCache {

    private final Map<UUID, GameMap> mapCache = new HashMap<>();


    @Override
    public void putGameMap(UUID uuid, GameMap gameMap) {
        mapCache.put(uuid, gameMap);
    }

    @Override
    public void removeGameMap(UUID uuid) {
        mapCache.remove(uuid);
    }

    @Override
    public GameMap getGameMap(UUID uuid) {
        return mapCache.get(uuid);
    }

    @Override
    public Collection<GameMap> getGameMaps() {
        return mapCache.values();
    }
}
