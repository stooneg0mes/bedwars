package net.stonegomes.bedwars.module.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.arena.build.GameBuildSet;
import net.stonegomes.bedwars.core.arena.player.GamePlayerMap;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import net.stonegomes.bedwars.core.process.ProcessCache;
import net.stonegomes.bedwars.core.scoreboard.ScoreboardCache;
import net.stonegomes.bedwars.game.GameManagerImpl;
import net.stonegomes.bedwars.game.arena.GameArenaCacheImpl;
import net.stonegomes.bedwars.game.arena.GameArenaDaoImpl;
import net.stonegomes.bedwars.game.arena.GameArenaImpl;
import net.stonegomes.bedwars.game.arena.state.WaitingPlayersGameState;
import net.stonegomes.bedwars.game.lobby.GameLobbyImpl;
import net.stonegomes.bedwars.game.process.ProcessCacheImpl;
import net.stonegomes.bedwars.game.scoreboard.ScoreboardCacheImpl;
import org.bukkit.Material;
import org.bukkit.block.Block;

@ModuleId(id = "gameArenaModule")
@RequiredArgsConstructor
public class GameArenaModule extends Module {

    private final GamePlugin gamePlugin;

    @Override
    public void handleEnable() {
        for (GameArena gameArena : gamePlugin.getArenaDao().find()) {
            gameArena.setGameState(new WaitingPlayersGameState());
            gamePlugin.getArenaCache().putGameArena(gameArena.getUniqueId(), gameArena);
        }
    }

    @Override
    public void handleDisable() {
        for (GameArena gameArena : gamePlugin.getArenaCache().values()) {
            for (Block block : gameArena.getBuildSet().values()) {
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

            gamePlugin.getArenaDao().replace(databaseArena);
        }
    }

}