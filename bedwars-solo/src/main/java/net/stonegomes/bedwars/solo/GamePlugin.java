package net.stonegomes.bedwars.solo;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.commons.AbstractModulePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.solo.module.RunnableModule;
import net.stonegomes.bedwars.solo.module.game.GameBuildModule;
import net.stonegomes.bedwars.solo.module.game.GameModule;
import net.stonegomes.bedwars.solo.module.game.GamePlayerModule;
import net.stonegomes.bedwars.solo.module.ListenerModule;
import org.bukkit.Bukkit;

@AllArgsConstructor
public class GamePlugin extends AbstractModulePlugin {

    @Override
    public void handleLoad() {
        Bukkit.getLogger().info("Plugin loading.");
    }

    @Override
    public void handleEnable() {
        Bukkit.getLogger().info("Plugin enabling.");
    }

    @Override
    public void handleDisable() {
        Bukkit.getLogger().info("Plugin disabling.");
    }

    @Override
    public Module[] getModules() {
        return new Module[] {
            // Game
            new GameModule(),
            new GameBuildModule(),
            new GamePlayerModule(),
            // Other
            new ListenerModule(this),
            new RunnableModule(this)
        };
    }

    public GameManager getGameManager() {
        return ((GameModule) getModule(GameModule.class)).getGameManager();
    }

    public GameBuildCache getBuildCache() {
        return ((GameBuildModule) getModule(GameBuildModule.class)).getGameBuildCache();
    }

    public GamePlayerCache getPlayerCache() {
        return ((GamePlayerModule) getModule(GamePlayerModule.class)).getGamePlayerCache();
    }

}
