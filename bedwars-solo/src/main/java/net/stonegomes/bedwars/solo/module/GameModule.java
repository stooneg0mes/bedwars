package net.stonegomes.bedwars.solo.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.generator.GameGeneratorCache;
import net.stonegomes.bedwars.core.island.GameIslandCache;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.core.state.GameManager;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.game.GameManagerImpl;
import net.stonegomes.bedwars.solo.game.cache.GameBuildCacheImpl;
import net.stonegomes.bedwars.solo.game.cache.GameGeneratorCacheImpl;
import net.stonegomes.bedwars.solo.game.cache.GameIslandCacheImpl;
import net.stonegomes.bedwars.solo.game.cache.GamePlayerCacheImpl;
import net.stonegomes.bedwars.solo.game.state.WaitingPlayersGameState;

@ModuleId(id = "gameModule")
@RequiredArgsConstructor
public class GameModule extends Module {

    private final GamePlugin gamePlugin;

    @Getter
    private GameManager gameManager;

    @Override
    public void handleEnable() {
        gameManager = new GameManagerImpl(
            gamePlugin,
            new GameBuildCacheImpl(),
            new GameGeneratorCacheImpl(),
            new GameIslandCacheImpl(),
            new GamePlayerCacheImpl()
        );

        gameManager.setGameState(new WaitingPlayersGameState());
    }

    public GameBuildCache getBuildCache() {
        return gameManager.getBuildCache();
    }

    public GameGeneratorCache getGeneratorCache() {
        return gameManager.getGeneratorCache();
    }

    public GameIslandCache getIslandCache() {
        return gameManager.getIslandCache();
    }

    public GamePlayerCache getPlayerCache() {
        return gameManager.getPlayerCache();
    }

}
