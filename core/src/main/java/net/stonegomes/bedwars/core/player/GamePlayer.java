package net.stonegomes.bedwars.core.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.stonegomes.bedwars.core.game.GameTeamColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@AllArgsConstructor
@Data
public class GamePlayer {

    private final UUID uniqueId;
    private GameTeamColor teamColor;

    public Player getBukkitPlayer() {
        return Bukkit.getPlayer(uniqueId);
    }

}
