package net.stonegomes.bedwars.solo.game.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.stonegomes.bedwars.core.arena.island.GameIsland;
import net.stonegomes.bedwars.core.player.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class GamePlayerImpl implements GamePlayer {


    private final UUID uniqueId;

    private GameIsland island;
    private Long spectatorTime;

    @Override
    public boolean isSpectator() {
        return spectatorTime >= System.currentTimeMillis();
    }

    @Override
    public Player getBukkitPlayer() {
        return Bukkit.getPlayer(uniqueId);
    }

}