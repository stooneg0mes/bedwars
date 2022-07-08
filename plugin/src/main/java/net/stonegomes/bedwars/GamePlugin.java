package net.stonegomes.bedwars;

import lombok.experimental.Delegate;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleBootstrap;
import net.stonegomes.bedwars.commons.ModulePlugin;
import net.stonegomes.bedwars.module.*;
import net.stonegomes.bedwars.module.game.GameArenaModule;
import net.stonegomes.bedwars.module.game.GameLobbyModule;
import net.stonegomes.bedwars.module.game.GameModule;

public class GamePlugin extends ModulePlugin {

    @Delegate(excludes = ModuleBootstrap.class)
    private GameModule gameModule;

    @Delegate(excludes = ModuleBootstrap.class)
    private ViewModule viewModule;

    @Delegate(excludes = ModuleBootstrap.class)
    private HologramModule hologramModule;

    @Delegate(excludes = ModuleBootstrap.class)
    private NpcModule npcModule;
    
    @Override
    public void handlePostLoad() {
        gameModule = getModule(GameModule.class);
        viewModule = getModule(ViewModule.class);
    }

    @Override
    public void handlePostEnable() {
        hologramModule = getModule(HologramModule.class);
        npcModule = getModule(NpcModule.class);
    }

    @Override
    public Module[] getModules() {
        return new Module[]{
            new GameModule(),
            new SerializerModule(),
            new HologramModule(this),
            new NpcModule(this),
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
