package net.stonegomes.bedwars.solo.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TrafficListener implements Listener {

    @EventHandler
    public void handleJoin(PlayerJoinEvent event) {
        event.joinMessage(null);

        /*
        TODO nametag & display name stuff
         */
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent event) {
        event.quitMessage(null);
        event.getPlayer().getInventory().clear();
    }

}
