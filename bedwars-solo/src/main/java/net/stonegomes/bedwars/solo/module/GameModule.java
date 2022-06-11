package net.stonegomes.bedwars.solo.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.map.GameMap;
import net.stonegomes.bedwars.core.map.GameMapCache;
import net.stonegomes.bedwars.core.map.GameMapDao;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.solo.game.GameManagerImpl;
import net.stonegomes.bedwars.solo.game.build.GameBuildCacheImpl;
import net.stonegomes.bedwars.solo.game.map.GameMapCacheImpl;
import net.stonegomes.bedwars.solo.game.map.GameMapDaoImpl;
import net.stonegomes.bedwars.solo.game.player.GamePlayerCacheImpl;
import net.stonegomes.bedwars.solo.game.state.WaitingPlayersGameState;
import net.stonegomes.bedwars.solo.game.state.setup.SetupGameState;

@ModuleId(id = "gameModule")
@RequiredArgsConstructor
public class GameModule extends Module {

    @Getter
    private GameManager gameManager;

    @Override
    public void handleEnable() {
        gameManager = new GameManagerImpl(
            new GameBuildCacheImpl(),
            new GamePlayerCacheImpl(),
            new GameMapCacheImpl(),
            new GameMapDaoImpl()
        );

        if (gameManager.getMapDao().find().isEmpty()) {
            gameManager.setGameState(new SetupGameState());
        } else {
            final GameMap randomMap = gameManager.getMapDao().find().stream()
                .findAny()
                .orElse(null);

            gameManager.setGameMap(randomMap);
            gameManager.setGameState(new WaitingPlayersGameState());
        }
    }

    public GameBuildCache getBuildCache() {
        return gameManager.getBuildCache();
    }

    public GamePlayerCache getPlayerCache() {
        return gameManager.getPlayerCache();
    }

    public GameMapCache getMapCache() {
        return gameManager.getMapCache();
    }

    public GameMapDao getMapDao() {
        return gameManager.getMapDao();
    }

}
