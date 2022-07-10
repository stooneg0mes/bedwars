package net.stonegomes.bedwars;

import lombok.experimental.Delegate;
import net.kyori.adventure.text.Component;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleBootstrap;
import net.stonegomes.bedwars.commons.ModulePlugin;
import net.stonegomes.bedwars.module.*;
import net.stonegomes.bedwars.module.game.GameArenaModule;
import net.stonegomes.bedwars.module.game.GameLobbyModule;
import net.stonegomes.bedwars.module.game.GameModule;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GamePlugin extends ModulePlugin {

    @Delegate(excludes = ModuleBootstrap.class)
    private GameModule gameModule;

    @Delegate(excludes = ModuleBootstrap.class)
    private ViewModule viewModule;

    @Delegate(excludes = ModuleBootstrap.class)
    private NpcModule npcModule;
    
    @Override
    public void handlePostLoad() {
        gameModule = getModule(GameModule.class);
        viewModule = getModule(ViewModule.class);
    }

    @Override
    public void handlePostEnable() {
        npcModule = getModule(NpcModule.class);
    }

    @Override
    public void handleDisable() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.kick(Component.text("§cServer is restarting..."));
        }
    }

    @Override
    public Module[] getModules() {
        return new Module[]{
            new GameModule(),
            new SerializerModule(),
            new NpcModule(this),
            new HologramModule(this),
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
