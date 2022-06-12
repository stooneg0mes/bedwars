package net.stonegomes.bedwars.listener.player;

import lombok.AllArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.GameArena;
import net.stonegomes.bedwars.core.player.GamePlayer;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class PlayerDeathListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handlePlayerDeath(PlayerDeathEvent event) {
        final Player player = event.getPlayer();
        player.spigot().respawn();

        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(player);
        if (gameArena == null) return;

        final GamePlayer gamePlayer = gameArena.getPlayerMap().getGamePlayer(player.getUniqueId());
        if (gamePlayer != null) {
            player.setGameMode(GameMode.SPECTATOR);
            gamePlayer.setSpectatorTime(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));
        }

        final Player killer = event.getPlayer().getKiller();
        if (killer == null) {
            event.deathMessage(Component.text(player.getName() + " fell into the void.", NamedTextColor.WHITE));
            return;
        }

        event.deathMessage(Component.text(player.getName() + " was killed by " + killer.getName(), NamedTextColor.WHITE));

        final GamePlayer gameKiller = gameArena.getPlayerMap().getGamePlayer(killer.getUniqueId());
        if (gameKiller != null) {
            killer.spigot().respawn();
            killer.setGameMode(GameMode.SPECTATOR);

            gameKiller.setSpectatorTime(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));
        }
    }

}
