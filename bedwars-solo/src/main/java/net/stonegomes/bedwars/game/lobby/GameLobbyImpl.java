package net.stonegomes.bedwars.game.lobby;

import lombok.Data;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import org.bukkit.Location;

@Data
public class GameLobbyImpl implements GameLobby {

    private Location spawnLocation;
    private Location npcLocation;

}
