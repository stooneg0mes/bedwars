package net.stonegomes.bedwars.listener.player;

import com.github.juliarn.npc.NPC;
import com.github.juliarn.npc.event.PlayerNPCInteractEvent;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.view.GameArenaPaginatedView;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@RequiredArgsConstructor
public class PlayerInteractNpcListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handlePlayerInteract(PlayerNPCInteractEvent event) {
        final NPC npc = event.getNPC();
        if (npc.getEntityId() != gamePlugin.getLobby().getNpc().getEntityId()) return;

        final Player player = event.getPlayer();
        gamePlugin.getViewFrame().open(GameArenaPaginatedView.class, player);
    }

}
