package net.stonegomes.bedwars.core.state;

public abstract class GameState {

    public abstract String getName();

    /**
     * Get the next state
     *
     * @return the next state or null if there is no next state
     */
    public GameState getNextState() {
        return null;
    }

    /**
     * Get the previous state
     *
     * @return the previous state or null if there is no previous state
     */
    public GameState getPreviousState() {
        return null;
    }

    /**
     * Check if this state is the first state
     *
     * @return if the state doesn't have a previous state
     */
    public boolean isFirstState() {
        return getPreviousState() == null;
    }

    /**
     * Check if this state is the last state
     *
     * @return if the state doesn't have a next state
     */
    public boolean isLastState() {
        return getNextState() == null;
    }

    /**
     * Called when entering the state
     *
     * @param context the context
     */
    public void onEnter(GameStateContext context) {}

    /**
     * Called every second to update the state
     *
     * @param context the context
     */
    public void onUpdate(GameStateContext context) {}

    /**
     * Called when leaving the state to another state
     *
     * @param context the context
     */
    public void onExit(GameStateContext context) {}

    /**
     * Called when leaving the game
     *
     * @param context the context
     */
    public void onQuit(GameStateContext context) {}

}