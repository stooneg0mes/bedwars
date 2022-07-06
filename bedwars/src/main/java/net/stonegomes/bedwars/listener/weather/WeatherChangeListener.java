package net.stonegomes.bedwars.listener.weather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChangeListener implements Listener {

    @EventHandler
    public void handleWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }

}
