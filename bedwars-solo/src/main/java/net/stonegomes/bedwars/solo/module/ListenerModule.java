package net.stonegomes.bedwars.solo.module;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.listener.TrafficMessageListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

@ModuleId(id = "listenerModule")
@RequiredArgsConstructor
public class ListenerModule extends Module {

    private final GamePlugin gamePlugin;

    @Override
    public void handleEnable() {
        final PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new TrafficMessageListener(), gamePlugin);
    }

}
