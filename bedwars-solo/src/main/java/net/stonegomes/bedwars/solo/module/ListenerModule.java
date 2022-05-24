package net.stonegomes.bedwars.solo.module;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.listener.TrafficListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

@ModuleId(id = "listenerModule")
@RequiredArgsConstructor
public class ListenerModule extends Module {

    private final GamePlugin gamePlugin;

    private final PluginManager pluginManager = Bukkit.getPluginManager();

    @Override
    public void handleEnable() {
        pluginManager.registerEvents(new TrafficListener(), gamePlugin);
    }

}
