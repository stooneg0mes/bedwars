package net.stonegomes.bedwars.core;

import net.stonegomes.bedwars.commons.ModulePlugin;
import org.bukkit.Bukkit;

public class CorePlugin extends ModulePlugin {

    @Override
    public void handleLoad() {
        Bukkit.getLogger().info("Core loading.");
    }

    @Override
    public void handleEnable() {
        Bukkit.getLogger().info("Core enabling.");
    }

    @Override
    public void handleDisable() {
        Bukkit.getLogger().info("Core disabling.");
    }

}
