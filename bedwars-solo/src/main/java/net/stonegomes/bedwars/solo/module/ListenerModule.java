package net.stonegomes.bedwars.solo.module;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.listener.block.BlockBuildListener;
import net.stonegomes.bedwars.solo.listener.traffic.GameStateTrafficListener;
import net.stonegomes.bedwars.solo.listener.traffic.MessageTrafficListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

@ModuleId(id = "listenerModule")
@AllArgsConstructor
public class ListenerModule extends Module {

    private final GamePlugin gamePlugin;

    @Override
    public void handleEnable() {
        final PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new MessageTrafficListener(), gamePlugin);

        pluginManager.registerEvents(new GameStateTrafficListener(gamePlugin), gamePlugin);
        pluginManager.registerEvents(new BlockBuildListener(gamePlugin), gamePlugin);
    }

}
