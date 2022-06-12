package net.stonegomes.bedwars.ecostudios.solo.game.map;

import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaCache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameArenaCacheImpl implements GameArenaCache {

    private final Map<UUID, GameArena> mapCache = new HashMap<>();


    @Override
    public void putGameMap(UUID uuid, GameArena gameArena) {
        mapCache.put(uuid, gameArena);
    }

    @Override
    public void removeGameMap(UUID uuid) {
        mapCache.remove(uuid);
    }

    @Override
    public GameArena getGameMap(UUID uuid) {
        return mapCache.get(uuid);
    }

    @Override
    public Collection<GameArena> getGameMaps() {
        return mapCache.values();
    }
}
