package net.stonegomes.bedwars.ecostudios.solo.game.player;

import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import net.stonegomes.bedwars.core.arena.player.GamePlayerMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GamePlayerMapImpl implements GamePlayerMap {

    private final Map<UUID, GamePlayer> playerCache = new HashMap<>();

    @Override
    public void putGamePlayer(UUID uuid, GamePlayer gamePlayer) {
        playerCache.put(uuid, gamePlayer);
    }

    @Override
    public void removeGamePlayer(UUID uuid) {
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
