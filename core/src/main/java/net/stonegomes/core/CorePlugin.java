package net.stonegomes.core;

import net.stonegomes.commons.AbstractModulePlugin;
import org.bukkit.Bukkit;

public class CorePlugin extends AbstractModulePlugin {

    @Override
    public void handleEnable() {
        Bukkit.getLogger().info("Core initialized.");
    }

}
