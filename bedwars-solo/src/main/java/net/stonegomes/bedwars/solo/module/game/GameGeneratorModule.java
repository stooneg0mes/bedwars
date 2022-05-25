package net.stonegomes.bedwars.solo.module.game;

import lombok.Getter;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.generator.GameGeneratorCache;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.solo.game.cache.GameGeneratorCacheImpl;
import net.stonegomes.bedwars.solo.game.cache.GamePlayerCacheImpl;

@ModuleId(id = "gamePlayerModule")
public class GameGeneratorModule extends Module {

    @Getter
    private GameGeneratorCache gameGeneratorCache;

    @Override
    public void handleEnable() {
        gameGeneratorCache = new GameGeneratorCacheImpl();
    }

}
