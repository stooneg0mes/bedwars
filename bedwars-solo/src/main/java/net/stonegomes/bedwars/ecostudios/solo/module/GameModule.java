package net.stonegomes.bedwars.ecostudios.solo.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.arena.build.GameBuildSet;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.arena.player.GamePlayerMap;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.ecostudios.solo.game.GameManagerImpl;
import net.stonegomes.bedwars.ecostudios.solo.game.build.GameBuildSetImpl;
import net.stonegomes.bedwars.ecostudios.solo.game.map.GameArenaCacheImpl;
import net.stonegomes.bedwars.ecostudios.solo.game.map.GameArenaDaoImpl;
import net.stonegomes.bedwars.ecostudios.solo.game.player.GamePlayerMapImpl;
import net.stonegomes.bedwars.ecostudios.solo.game.state.WaitingPlayersGameState;
import net.stonegomes.bedwars.ecostudios.solo.game.state.setup.SetupGameState;

@ModuleId(id = "gameModule")
@RequiredArgsConstructor
public class GameModule extends Module {

    @Getter
    private GameManager gameManager;

    @Override
    public void handleEnable() {
        gameManager = new GameManagerImpl(
            new GameBuildSetImpl(),
            new GamePlayerMapImpl(),
            new GameArenaCacheImpl(),
            new GameArenaDaoImpl()
        );

        if (gameManager.getArenaDao().find().isEmpty()) {
            gameManager.setGameState(new SetupGameState());
        } else {
            final GameArena randomMap = gameManager.getArenaDao().find().stream()
                .findAny()
                .orElse(null);

            gameManager.setGameArena(randomMap);
            gameManager.setGameState(new WaitingPlayersGameState());
        }
    }

    public GameBuildSet getBuildCache() {
        return gameManager.getBuildCache();
    }

    public GamePlayerMap getPlayerCache() {
        return gameManager.getPlayerCache();
    }

    public GameArenaCache getMapCache() {
        return gameManager.getArenaCache();
    }

    public GameArenaDao getMapDao() {
        return gameManager.getArenaDao();
    }

}
