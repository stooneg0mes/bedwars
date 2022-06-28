package net.stonegomes.bedwars;

import com.google.common.collect.Lists;
import lombok.experimental.Delegate;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleBootstrap;
import net.stonegomes.bedwars.commons.ModulePlugin;
import net.stonegomes.bedwars.module.CommandModule;
import net.stonegomes.bedwars.module.ListenerModule;
import net.stonegomes.bedwars.module.RunnableModule;
import net.stonegomes.bedwars.module.ViewModule;
import net.stonegomes.bedwars.module.game.GameArenaModule;
import net.stonegomes.bedwars.module.game.GameLobbyModule;
import net.stonegomes.bedwars.module.game.GameModule;

import java.util.ArrayList;
import java.util.List;

public class GamePlugin extends ModulePlugin {

    @Delegate(excludes = ModuleBootstrap.class)
    private GameModule gameModule;

    @Delegate(excludes = ModuleBootstrap.class)
    private ViewModule viewModule;

    @Override
    public void handlePostLoad() {
        gameModule = getModule(GameModule.class);
        viewModule = getModule(ViewModule.class);
    }

    @Override
    public Module[] getModules() {
        return new Module[]{
            new GameModule(),
            new GameArenaModule(this),
            new GameLobbyModule(this),
            new ViewModule(this),
            new CommandModule(this),
            new ListenerModule(this),
            new RunnableModule(this)
        };
    }

    public static GamePlugin getInstance() {
        return GamePlugin.getPlugin(GamePlugin.class);
    }

}
