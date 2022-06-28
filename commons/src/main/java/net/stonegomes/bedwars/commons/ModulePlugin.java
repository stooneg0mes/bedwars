package net.stonegomes.bedwars.commons;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ModulePlugin extends JavaPlugin implements ModuleBootstrap {

    private final Map<String, Object> elements = new HashMap<>();

    /*
    Module
     */

    public Module[] getModules() {
        return null;
    }

    public <T> T getModule(Class<? extends Module> clazz) {
        ModuleId moduleId = clazz.getDeclaredAnnotation(ModuleId.class);
        return (T) elements.get(moduleId.id());
    }

    /*
    Bootstrap
     */

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

        handlePostLoad();
    }

    @Override
    public void onEnable() {
        handleEnable();

        if (getModules() != null) {
            Arrays.stream(getModules()).forEach(Module::handleEnable);
        }

        handlePostLoad();
    }

    @Override
    public void onDisable() {
        handleDisable();

        if (getModules() != null) {
            Arrays.stream(getModules()).forEach(Module::handleDisable);
        }

        handlePostDisable();
    }

    /*
    Config
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
