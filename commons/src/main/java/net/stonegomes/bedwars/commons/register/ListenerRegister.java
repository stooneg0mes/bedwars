package net.stonegomes.bedwars.commons.register;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class ListenerRegister {

    public static void registerAll(Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static void register(Plugin plugin, Listener listener) {
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }

}
