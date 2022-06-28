package net.stonegomes.bedwars.commons;

public interface ModuleBootstrap {

    default void handleEnable() {}

    default void handlePostEnable() {}

    default void handleLoad() {}

    default void handlePostLoad() {}

    default void handleDisable() {}

    default void handlePostDisable() {}

}
