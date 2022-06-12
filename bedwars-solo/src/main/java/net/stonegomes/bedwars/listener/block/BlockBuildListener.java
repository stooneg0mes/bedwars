package net.stonegomes.bedwars.listener.block;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.state.GameState;
import net.stonegomes.bedwars.game.state.StartingGameState;
import net.stonegomes.bedwars.game.state.WaitingPlayersGameState;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

@AllArgsConstructor
public class BlockBuildListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handlePlace(BlockPlaceEvent event) {
        final Block block = event.getBlock();
        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(block);
        if (gameArena == null) return;

        final GameState gameState = gameArena.getGameState();
        if (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState) {
            event.setCancelled(true);
            return;
        }

        gameArena.getBuildSet().addBlock(block);
    }

    @EventHandler
    public void handleBreak(BlockBreakEvent event) {
        final Block block = event.getBlock();
        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(block);
        if (gameArena == null) return;

        final GameState gameState = gameArena.getGameState();
        if (gameState instanceof WaitingPlayersGameState || gameState instanceof StartingGameState) {
            event.setCancelled(true);
            return;
        }

        if (!gameArena.getBuildSet().hasBlock(block)) {
            event.setCancelled(!event.getPlayer().hasPermission("bedwars.admin"));
        } else {
            gameArena.getBuildSet().removeBlock(block);
        }
    }

}
