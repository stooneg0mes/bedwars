package net.stonegomes.bedwars.solo.module.game;

import lombok.Getter;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.solo.game.cache.GameBuildCacheImpl;

@ModuleId(id = "gameBuildModule")
public class GameBuildModule extends Module {

    @Getter
    private GameBuildCache gameBuildCache;

    @Override
    public void handleEnable() {
        gameBuildCache = new GameBuildCacheImpl();
    }

}
