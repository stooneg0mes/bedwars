package net.stonegomes.bedwars.ecostudios.solo.listener.traffic;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MessageTrafficListener implements Listener {

    @EventHandler
    public void handleJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final TextComponent messageComponent = Component.text(player.getName() + " has joined the game.", NamedTextColor.YELLOW);

        event.joinMessage(messageComponent);
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final TextComponent messageComponent = Component.text(player.getName() + " has left the game.", NamedTextColor.YELLOW);

        event.quitMessage(messageComponent);
    }

}
