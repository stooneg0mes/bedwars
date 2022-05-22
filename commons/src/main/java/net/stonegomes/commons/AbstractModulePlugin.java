package net.stonegomes.commons;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractModulePlugin extends JavaPlugin {

    private final Map<String, Module> elements = new HashMap<>();

    /*
    Modules
     */

    public Module[] getModules() {
        return null;
    }

    /*
    Load
     */

    public void handleLoad() {}

    public void handlePostLoad() {}

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

    /*
    Enable
     */

    public void handleEnable() {}

    public void handlePostEnable() {}

    @Override
    public void onEnable() {
        handleEnable();

        if (!elements.isEmpty()) {
            elements.values().forEach(Module::handleEnable);
        }

        handlePostEnable();
    }

    /*
    Disable
     */

    public void handleDisable() {}

    public void handlePostDisable() {}

    @Override
    public void onDisable() {
        handleDisable();

       if (!elements.isEmpty()) {
           elements.values().forEach(Module::handleDisable);
       }

        handlePostDisable();
    }

    /*
    Module methods
     */

    public Module getModule(Class<? extends Module> clazz) {
        ModuleId moduleId = clazz.getDeclaredAnnotation(ModuleId.class);
        return elements.get(moduleId.id());
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
