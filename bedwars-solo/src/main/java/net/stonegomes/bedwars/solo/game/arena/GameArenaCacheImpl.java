package net.stonegomes.bedwars.solo.game.arena;

import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.core.player.GamePlayerCache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameArenaCacheImpl implements GameArenaCache{

    private final Map<UUID, GameArena> arenaCache = new HashMap<>();


    @Override
    public void putGameArena(UUID uuid, GameArena gameArena) {
        arenaCache.put(uuid, gameArena);
    }

    @Override
    public void removeGameArena(UUID uuid) {
        arenaCache.remove(uuid);
    }

    @Override
    public GameArena getGameArena(UUID uuid) {
        return arenaCache.get(uuid);
    }

    @Override
    public Collection<GameArena> getGameArenas() {
        return arenaCache.values();
    }
}
