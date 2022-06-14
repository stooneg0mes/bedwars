package net.stonegomes.bedwars.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.build.GameBuildSet;
import net.stonegomes.bedwars.core.arena.player.GamePlayerMap;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;
import net.stonegomes.bedwars.game.GameManagerImpl;
import net.stonegomes.bedwars.game.arena.GameArenaCacheImpl;
import net.stonegomes.bedwars.game.arena.GameArenaDaoImpl;
import net.stonegomes.bedwars.game.arena.GameArenaImpl;
import net.stonegomes.bedwars.game.lobby.GameLobbyImpl;
import net.stonegomes.bedwars.game.process.ProcessCacheImpl;
import net.stonegomes.bedwars.game.scoreboard.ScoreboardCacheImpl;
import net.stonegomes.bedwars.game.arena.state.WaitingPlayersGameState;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

@ModuleId(id = "gameArenaModule")
@RequiredArgsConstructor
public class GameModule extends Module {

    @Delegate(excludes = DelegateContextBuilder.class)
    @Getter
    private GameManager gameManager;

    @Override
    public void handleEnable() {
        gameManager = new GameManagerImpl(
            new GameArenaCacheImpl(),
            new GameArenaDaoImpl(),
            new ScoreboardCacheImpl(),
            new ProcessCacheImpl(),
            new GameLobbyImpl()
        );

        for (GameArena gameArena : gameManager.getArenaDao().find()) {
            gameArena.setGameState(new WaitingPlayersGameState());
            gameManager.getArenaCache().putGameArena(gameArena.getUniqueId(), gameArena);
        }
    }

    @Override
    public void handleDisable() {
        for (GameArena gameArena : gameManager.getArenaCache().getGameArenas()) {
            for (Block block : gameArena.getBuildSet().getBlocks()) {
                block.setType(Material.AIR); // TODO: asynchronous removal of blocks
            }

            final GameArena databaseArena = GameArenaImpl.builder()
                .uniqueId(gameArena.getUniqueId())
                .world(gameArena.getWorld().getName())
                .buildSet(new GameBuildSet())
                .playerMap(new GamePlayerMap())
                .generatorMap(gameArena.getGeneratorMap())
                .islandMap(gameArena.getIslandMap())
                .npcMap(gameArena.getNpcMap())
                .gameState(null)
                .name(gameArena.getName())
                .waitingSpawnLocation(gameArena.getWaitingSpawnLocation())
                .waitingFirstPosition(gameArena.getWaitingCuboid().getFirstPos())
                .waitingSecondPosition(gameArena.getWaitingCuboid().getSecondPos())
                .build();

            gameManager.getArenaDao().replace(databaseArena);
        }
    }

    private interface DelegateContextBuilder {

        GameStateContext buildContext(Player player);

        GameStateContext buildContext(Player player, GameArena gameArena);

    }

}