package net.stonegomes.bedwars.core.build.listener;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.game.GameManager;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

@AllArgsConstructor
public class GameBuildListener implements Listener {

    private final GameBuildCache gameBuildCache;

    @EventHandler
    public void handlePlace(BlockPlaceEvent event) {
        final Block block = event.getBlock();
        gameBuildCache.addBlock(block);
    }

    @EventHandler
    public void handleBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlock();

        if (!gameBuildCache.hasBlock(block)) {
            event.setCancelled(!player.hasPermission("bedwars.admin"));
        } else {
            gameBuildCache.removeBlock(block);
        }
    }

}
