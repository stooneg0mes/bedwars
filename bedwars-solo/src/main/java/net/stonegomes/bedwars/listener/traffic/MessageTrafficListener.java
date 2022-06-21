package net.stonegomes.bedwars.listener.traffic;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor
public class MessageTrafficListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handleJoin(PlayerJoinEvent event) {
        event.joinMessage(null);
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent event) {
        event.quitMessage(null);
    }

}
