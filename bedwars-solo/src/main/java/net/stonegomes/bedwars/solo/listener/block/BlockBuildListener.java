package net.stonegomes.bedwars.solo.listener.block;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.game.state.StartingGameState;
import net.stonegomes.bedwars.solo.game.state.WaitingPlayersGameState;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

@AllArgsConstructor
public class BlockBuildListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handlePlace(BlockPlaceEvent event) {
        final GameState gameState = gamePlugin.getGameManager().getGameState();
        if (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState) {
            event.setCancelled(true);
            return;
        }

        final Block block = event.getBlock();
        gamePlugin.getBuildCache().addBlock(block);
    }

    @EventHandler
    public void handleBreak(BlockBreakEvent event) {
        final GameState gameState = gamePlugin.getGameManager().getGameState();
        if (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState) {
            event.setCancelled(true);
            return;
        }

        final Player player = event.getPlayer();
        final Block block = event.getBlock();

        if (!gamePlugin.getBuildCache().hasBlock(block)) {
            event.setCancelled(!player.hasPermission("bedwars.admin"));
        } else {
            gamePlugin.getBuildCache().removeBlock(block);
        }
    }

}
