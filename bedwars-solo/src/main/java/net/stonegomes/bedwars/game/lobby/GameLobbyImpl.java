package net.stonegomes.bedwars.game.lobby;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
public class GameLobbyImpl implements GameLobby {

    @Getter(AccessLevel.NONE)
    private static final GamePlugin gamePlugin = GamePlugin.getInstance();

    private Location spawnLocation;
    private Location npcLocation;

    @Override
    public Collection<Player> getPlayers() {
        return Bukkit.getOnlinePlayers().stream()
            .filter(player -> gamePlugin.getArenaCache().getGameArena(player) == null)
            .collect(Collectors.toSet());
    }

}
