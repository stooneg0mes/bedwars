package net.stonegomes.bedwars.module;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.listener.block.BlockBuildListener;
import net.stonegomes.bedwars.listener.entity.EntityDamageByEntityListener;
import net.stonegomes.bedwars.listener.food.FoodLevelChangeListener;
import net.stonegomes.bedwars.listener.player.PlayerDeathListener;
import net.stonegomes.bedwars.listener.player.PlayerDropPickupItemListener;
import net.stonegomes.bedwars.listener.player.PlayerInteractNpcListener;
import net.stonegomes.bedwars.listener.traffic.MessageTrafficListener;
import net.stonegomes.bedwars.listener.traffic.ScoreboardTrafficListener;
import net.stonegomes.bedwars.listener.weather.WeatherChangeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

@ModuleId(id = "listenerModule")
@RequiredArgsConstructor
public class ListenerModule extends Module {

    private final GamePlugin gamePlugin;


    @Override
    public void handleEnable() {
        final PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new BlockBuildListener(gamePlugin), gamePlugin);

        pluginManager.registerEvents(new EntityDamageByEntityListener(gamePlugin), gamePlugin);

        pluginManager.registerEvents(new FoodLevelChangeListener(gamePlugin), gamePlugin);

        pluginManager.registerEvents(new PlayerDeathListener(gamePlugin), gamePlugin);
        pluginManager.registerEvents(new PlayerDropPickupItemListener(gamePlugin), gamePlugin);
        pluginManager.registerEvents(new PlayerInteractNpcListener(gamePlugin), gamePlugin);

        pluginManager.registerEvents(new MessageTrafficListener(gamePlugin), gamePlugin);
        pluginManager.registerEvents(new ScoreboardTrafficListener(gamePlugin), gamePlugin);

        pluginManager.registerEvents(new WeatherChangeListener(), gamePlugin);
    }

}
