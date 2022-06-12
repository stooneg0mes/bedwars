package net.stonegomes.bedwars.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.arena.build.GameBuildSet;
import net.stonegomes.bedwars.core.arena.player.GamePlayerMap;
import net.stonegomes.bedwars.game.arena.GameArenaCacheImpl;
import net.stonegomes.bedwars.game.arena.GameArenaDaoImpl;
import net.stonegomes.bedwars.game.arena.GameArenaImpl;
import net.stonegomes.bedwars.game.state.WaitingPlayersGameState;
import org.bukkit.Material;
import org.bukkit.block.Block;

@ModuleId(id = "gameArenaModule")
@RequiredArgsConstructor
@Getter
public class GameArenaModule extends Module {

    private GameArenaDao arenaDao;
    private GameArenaCache arenaCache;

    @Override
    public void handleEnable() {
        arenaCache = new GameArenaCacheImpl();
        arenaDao = new GameArenaDaoImpl();

        for (GameArena gameArena : arenaDao.find()) {
            gameArena.setGameState(new WaitingPlayersGameState());
            arenaCache.putGameArena(gameArena.getUniqueId(), gameArena);
        }
    }

    @Override
    public void handleDisable() {
        for (GameArena gameArena : arenaCache.getGameArenas()) {
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

            arenaDao.replace(databaseArena);
        }
    }

}
