package net.stonegomes.bedwars.core.game;

public interface GameState {

    String getName();

    GameState getNextState();

    default boolean isFirstState() {
        return false;
    }

    default void onUpdate(GameStateContext context) {}

    default void onEnter(GameStateContext context) {}

    default void onExit(GameStateContext context) {}

    default void onQuit(GameStateContext context) {}

}