package net.stonegomes.bedwars.arena.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.island.GameIsland;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class GamePlayerImpl implements GamePlayer {

    private final UUID uniqueId;

    private GameIsland island;
    private GameArena arena;

    private Long spectatorTime;

    @Override
    public Player getBukkitPlayer() {
        return Bukkit.getPlayer(uniqueId);
    }

}
