package net.stonegomes.bedwars.core.state;

public abstract class GameState {

    public abstract String getName();

    /*
    State methods
     */

    /**
     * Get the next state
     * @return the next state
     */
    public abstract GameState getNextState();

    /**
     * Get the previous state
     * @return the previous state
     */
    public abstract GameState getPreviousState();

    /**
     * Check if this state is the first state
     * @return if the state doesn't have a previous state
     */
    public boolean isFirstState() {
        return getPreviousState() == null;
    }

    /**
     * Check if this state is the last state
     * @return if the state doesn't have a next state
     */
    public boolean isLastState() {
        return getNextState() == null;
    }

    /**
     * Called when entering the state
     * @param context the context
     */
    public void handleEnter(GameStateContext context) {}

    /**
     * Called every second to update the state
     * @param context the context
     */
    public void handleUpdate(GameStateContext context) {}

    /**
     * Called when leaving the state to another state
     * @param context the context
     */
    public void handleExit(GameStateContext context) {}

    /**
     * Called when leaving the game
     * @param context the context
     */
    public void handleQuit(GameStateContext context) {}

}