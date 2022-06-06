package net.stonegomes.bedwars.commons;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModulePlugin extends JavaPlugin {

    private final Map<String, Object> elements = new HashMap<>();

    /*
    Modules
     */

    public Module[] getModules() {
        return null;
    }

    /*
    Load
     */

    public void handleLoad() {
        Bukkit.getLogger().info("Commons loading.");
    }

    @Override
    public void onLoad() {
        handleLoad();

        if (getModules() != null) {
            for (Module module : getModules()) {
                ModuleId moduleId = module.getClass().getDeclaredAnnotation(ModuleId.class);
                if (!elements.containsKey(moduleId.id())) elements.put(moduleId.id(), module);

                module.handleLoad();
            }
        }
    }

    /*
    Enable
     */

    public void handleEnable() {
        Bukkit.getLogger().info("Commons enabling.");
    }

    @Override
    public void onEnable() {
        handleEnable();

        if (getModules() != null) {
            Arrays.stream(getModules()).forEach(Module::handleEnable);
        }
    }

    /*
    Disable
     */

    public void handleDisable() {
        Bukkit.getLogger().info("Commons disabling.");
    }

    @Override
    public void onDisable() {
        handleDisable();

        if (getModules() != null) {
            Arrays.stream(getModules()).forEach(Module::handleDisable);
        }
    }

    /*
    Module methods
     */

    public <T> T getModule(Class<? extends Module> clazz) {
        ModuleId moduleId = clazz.getDeclaredAnnotation(ModuleId.class);
        return (T) elements.get(moduleId.id());
    }

    /*
    Config methods
     */

    public String getString(String... values) {
        return getConfig().getString(String.join(".", values));
    }

    public Double getDouble(String... values) {
        return getConfig().getDouble(String.join(".", values));
    }

    public List<String> getStringList(String... values) {
        return getConfig().getStringList(String.join(".", values));
    }

}
