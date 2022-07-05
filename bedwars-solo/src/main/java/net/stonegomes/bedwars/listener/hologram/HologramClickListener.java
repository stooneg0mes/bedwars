package net.stonegomes.bedwars.listener.hologram;

import com.github.eokasta.hologram.event.HologramClickEvent;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@RequiredArgsConstructor
public class HologramClickListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handleHologramClick(HologramClickEvent event) {
        event.getPlayer().sendMessage("a");
        if (!gamePlugin.getLobby().getNpcHologram().equals(event.getHologram())) return;

        event.getPlayer().sendMessage("a");
    }

}
