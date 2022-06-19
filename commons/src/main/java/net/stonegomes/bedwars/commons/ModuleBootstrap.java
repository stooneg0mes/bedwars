package net.stonegomes.bedwars.commons;

public interface ModuleBootstrap {

    default void handleEnable() {}

    default void handleLoad() {}

    default void handleDisable() {}

}
