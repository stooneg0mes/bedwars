package net.stonegomes.bedwars.core.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.stonegomes.bedwars.core.island.GameIsland;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@AllArgsConstructor
@Data
public class GamePlayer {

    private final UUID uniqueId;
    private GameIsland gameIsland;

    public Player getBukkitPlayer() {
        return Bukkit.getPlayer(uniqueId);
    }

}
