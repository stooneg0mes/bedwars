package net.stonegomes.bedwars.listener.process;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.process.Process;
import net.stonegomes.bedwars.core.process.ProcessPhase;
import net.stonegomes.bedwars.core.process.ProcessPhaseType;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

@RequiredArgsConstructor
public class ProcessInteractListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handleChat(PlayerInteractEvent event) {
        final Block block = event.getClickedBlock();
        if (block == null) return;

        final Player player = event.getPlayer();
        final Process process = gamePlugin.getProcessCache().getProcess(player.getUniqueId());
        if (process == null) return;

        final ProcessPhase processPhase = process.getCurrentPhase();
        if (processPhase == null || processPhase.getType() != ProcessPhaseType.INTERACT_BLOCK) return;

        if (!processPhase.handleInput(process.getProcessContext()).test(block, player)) {
            process.advancePhase(player);

            if (process.isOnLastPhase()) {
                process.onFinish(player, process.getProcessContext());
            }
        }
    }

}
