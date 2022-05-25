package net.stonegomes.bedwars.solo.listener;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

@AllArgsConstructor
public class GameBuildListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handlePlace(BlockPlaceEvent event) {
        final Block block = event.getBlock();
        gamePlugin.getBuildCache().addBlock(block);
    }

    @EventHandler
    public void handleBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlock();

        if (!gamePlugin.getBuildCache().hasBlock(block)) {
            event.setCancelled(!player.hasPermission("bedwars.admin"));
        } else {
            gamePlugin.getBuildCache().removeBlock(block);
        }
    }

}
