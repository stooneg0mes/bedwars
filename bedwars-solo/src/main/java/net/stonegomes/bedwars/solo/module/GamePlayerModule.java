package net.stonegomes.bedwars.solo.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.build.listener.GameBuildListener;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.game.build.GameBuildCacheImpl;
import org.bukkit.plugin.PluginManager;

@ModuleId(id = "gamePlayerModule")
@RequiredArgsConstructor
public class GamePlayerModule extends Module {

    private final GamePlugin gamePlugin;

    @Getter
    private GameBuildCache gameBuildCache;

    @Override
    public void handleEnable() {
        gameBuildCache = new GameBuildCacheImpl();

        final PluginManager pluginManager = gamePlugin.getServer().getPluginManager();
        pluginManager.registerEvents(new GameBuildListener(gameBuildCache), gamePlugin);
    }

}
