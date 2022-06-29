package net.stonegomes.bedwars.lobby;

import com.github.juliarn.npc.NPC;
import lombok.Data;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import org.bukkit.Location;

@Data
public class GameLobbyImpl implements GameLobby {

    private Location spawnLocation;
    private NPC npc;

}
