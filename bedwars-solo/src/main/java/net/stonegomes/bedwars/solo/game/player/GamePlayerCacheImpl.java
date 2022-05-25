package net.stonegomes.bedwars.solo.game.player;

import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.core.player.GamePlayerCache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GamePlayerCacheImpl implements GamePlayerCache {

    private final Map<UUID, GamePlayer> playerCache = new HashMap<>();

    @Override
    public void putGamePlayer(UUID uuid, GamePlayer gamePlayer) {
        playerCache.put(uuid, gamePlayer);
    }

    @Override
    public void removeGamePlayer(UUID uuid, GamePlayer gamePlayer) {
        playerCache.remove(uuid);
    }

    @Override
    public GamePlayer getGamePlayer(UUID uuid) {
        return playerCache.get(uuid);
    }

    @Override
    public Collection<GamePlayer> getGamePlayers() {
        return playerCache.values();
    }

}
