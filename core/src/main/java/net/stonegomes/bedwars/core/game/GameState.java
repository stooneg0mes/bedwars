package net.stonegomes.bedwars.core.game;

public abstract class GameState {

    public abstract String getName();

    /*
    State methods
     */

    public abstract GameState getNextState();

    public abstract GameState getPreviousState();

    public boolean isFirstState() {
        return getPreviousState() == null;
    }

    public boolean isLastState() {
        return getNextState() == null;
    }

    /*
    Handle methods
     */

    public void handleUpdate(GameStateContext context) {}

    public void handleEnter(GameStateContext context) {}

    public void handleExit(GameStateContext context) {}

    public void handleQuit(GameStateContext context) {}

}