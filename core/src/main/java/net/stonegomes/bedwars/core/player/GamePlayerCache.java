package net.stonegomes.bedwars.core.player;

import java.util.Collection;
import java.util.UUID;

public interface GamePlayerCache {

    void putGamePlayer(UUID uuid, GamePlayer gamePlayer);

    void removeGamePlayer(UUID uuid, GamePlayer gamePlayer);

    GamePlayer getGamePlayer(UUID uuid);

    Collection<GamePlayer> getGamePlayers();

}