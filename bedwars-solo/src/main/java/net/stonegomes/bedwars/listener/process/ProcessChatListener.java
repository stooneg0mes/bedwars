package net.stonegomes.bedwars.listener.process;

import io.papermc.paper.event.player.AsyncChatEvent;
import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.process.Process;
import net.stonegomes.bedwars.core.process.ProcessPhase;
import net.stonegomes.bedwars.core.process.ProcessPhaseType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@AllArgsConstructor
public class ProcessChatListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handleChat(AsyncChatEvent event) {
        final Player player = event.getPlayer();
        final Process process = gamePlugin.getProcessCache().getProcess(player.getUniqueId());
        if (process == null) return;

        final ProcessPhase processPhase = process.getCurrentPhase();
        if (processPhase == null || processPhase.getType() != ProcessPhaseType.CHAT) return;

        final String message = event.originalMessage().toString();
        if (!processPhase.handleInput(process.getProcessContext()).test(message, player)) {
            process.advancePhase(player);

            if (process.isOnLastPhase()) {
                process.onFinish(player, process.getProcessContext());
            }
        }
    }

}
