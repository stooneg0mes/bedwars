package net.stonegomes.bedwars.solo.module.game;

import lombok.Getter;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.solo.game.cache.GamePlayerCacheImpl;

@ModuleId(id = "gamePlayerModule")
public class GamePlayerModule extends Module {

    @Getter
    private GamePlayerCache gamePlayerCache;

    @Override
    public void handleEnable() {
        gamePlayerCache = new GamePlayerCacheImpl();
    }

}
