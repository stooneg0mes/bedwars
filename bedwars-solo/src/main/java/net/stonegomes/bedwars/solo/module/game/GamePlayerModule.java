package net.stonegomes.bedwars.solo.module.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.solo.game.player.GamePlayerCacheImpl;
import net.stonegomes.bedwars.solo.listener.GameBuildListener;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.game.build.GameBuildCacheImpl;
import org.bukkit.plugin.PluginManager;

@ModuleId(id = "gamePlayerModule")
public class GamePlayerModule extends Module {

    @Getter
    private GamePlayerCache gamePlayerCache;

    @Override
    public void handleEnable() {
        gamePlayerCache = new GamePlayerCacheImpl();
    }

}
