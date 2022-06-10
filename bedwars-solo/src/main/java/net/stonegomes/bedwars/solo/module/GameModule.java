package net.stonegomes.bedwars.solo.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.arena.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.arena.island.GameIslandMap;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.core.state.GameManager;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.game.GameManagerImpl;
import net.stonegomes.bedwars.solo.game.cache.GameBuildCacheImpl;
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
            new GameGeneratorMapImpl(),
            new GameIslandMapImpl(),
            new GamePlayerCacheImpl()
        );

        gameManager.setGameState(new WaitingPlayersGameState());
    }

    public GameBuildCache getBuildCache() {
        return gameManager.getBuildCache();
    }

    public GameGeneratorMap getGeneratorCache() {
        return gameManager.getGeneratorCache();
    }

    public GameIslandMap getIslandCache() {
        return gameManager.getIslandCache();
    }

    public GamePlayerCache getPlayerCache() {
        return gameManager.getPlayerCache();
    }

}
