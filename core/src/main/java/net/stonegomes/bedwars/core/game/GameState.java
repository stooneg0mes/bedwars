package net.stonegomes.bedwars.core.game;

public abstract class GameState {

    public abstract GameState getNextState();

    public boolean isFirstState() {
        return false;
    }

    public void onUpdate(GameStateContext context) {}

    public void onEnter(GameStateContext context) {}

    public void onExit(GameStateContext context) {}

    public void onQuit(GameStateContext context) {}

}