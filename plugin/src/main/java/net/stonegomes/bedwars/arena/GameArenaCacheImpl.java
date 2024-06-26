package net.stonegomes.bedwars.arena;

import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameArenaCacheImpl implements GameArenaCache {

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
    public GameArena getGameArena(World world) {
        return arenaCache.values().stream()
            .filter(gameArena -> gameArena.getWorld().getName().equals(world.getName()))
            .findFirst()
            .orElse(null);
    }

    @Override
    public GameArena getGameArena(Player player) {
        return arenaCache.values().stream()
            .filter(gameArena -> gameArena.getPlayerMap().hasGamePlayer(player.getUniqueId()))
            .findFirst()
            .orElse(null);
    }

    @Override
    public Collection<GameArena> values() {
        return arenaCache.values();
    }

}
