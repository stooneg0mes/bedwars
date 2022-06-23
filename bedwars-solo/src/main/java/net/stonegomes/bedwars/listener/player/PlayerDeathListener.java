package net.stonegomes.bedwars.listener.player;

import lombok.AllArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
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
        event.deathMessage(null);

        final Player player = event.getPlayer();
        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(player);
        if (gameArena == null) return;

        final GamePlayer gamePlayer = gameArena.getPlayerMap().getGamePlayer(player.getUniqueId());
        if (gamePlayer != null) {
            player.spigot().respawn();

            gamePlayer.setSpectatorTime(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));
            player.setGameMode(GameMode.SPECTATOR);
        }

        final Player killer = player.getKiller();
        if (killer == null) {
            broadcastMessageOnArena(gameArena, player.getName() + " fell into the void.");
            return;
        } else {
            broadcastMessageOnArena(gameArena, killer.getName() + " has killed " + player.getName() + ".");
        }

        final GamePlayer gameKiller = gameArena.getPlayerMap().getGamePlayer(killer.getUniqueId());
        if (gameKiller == null) return;
        
        killer.spigot().respawn();
        
        killer.setGameMode(GameMode.SPECTATOR);
        gameKiller.setSpectatorTime(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));
    }

    private void broadcastMessageOnArena(GameArena gameArena, String message) {
        for (GamePlayer onlinePlayer : gameArena.getPlayerMap().values()) {
            onlinePlayer.getBukkitPlayer().sendMessage(Component.text(message, NamedTextColor.YELLOW));
        }
    }

}
