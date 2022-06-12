package net.stonegomes.bedwars.ecostudios.solo.module;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.ecostudios.solo.GamePlugin;
import net.stonegomes.bedwars.ecostudios.solo.listener.traffic.MessageTrafficListener;
import net.stonegomes.bedwars.ecostudios.solo.listener.block.BlockBuildListener;
import net.stonegomes.bedwars.ecostudios.solo.listener.traffic.GameStateTrafficListener;
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
