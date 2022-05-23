package net.stonegomes.bedwars.core;

import net.stonegomes.bedwars.commons.AbstractModulePlugin;
import org.bukkit.Bukkit;

public class CorePlugin extends AbstractModulePlugin {

    @Override
    public void handleEnable() {
        Bukkit.getLogger().info("Core initialized.");
    }

}
