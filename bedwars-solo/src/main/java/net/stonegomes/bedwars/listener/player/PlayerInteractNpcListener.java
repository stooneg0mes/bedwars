package net.stonegomes.bedwars.listener.player;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.view.GameArenaPaginatedView;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

@RequiredArgsConstructor
public class PlayerInteractNpcListener implements Listener {

    private GamePlugin gamePlugin;

    @EventHandler
    public void handlePlayerInteract(PlayerInteractEvent event) {
        final Location location = event.getInteractionPoint();
        if (location == null) return;

        if (!location.equals(gamePlugin.getLobby().getNpcLocation())) return;

        final Player player = event.getPlayer();
        gamePlugin.getViewFrame().open(GameArenaPaginatedView.class, player);
    }

}
