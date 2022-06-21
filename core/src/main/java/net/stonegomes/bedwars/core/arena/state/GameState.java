package net.stonegomes.bedwars.core.arena.state;

public interface GameState {

    String getName();

    /**
     * Get the next state
     *
     * @return the next state or null if there is no next state
     */
    GameState getNextState();

    /**
     * Get the previous state
     *
     * @return the previous state or null if there is no previous state
     */
    GameState getPreviousState();

    /**
     * Check if a player can join on this state
     *
     * @return if the player can join on this state
     */
    boolean canEnter();

    /**
     * Check if this state is the first state
     *
     * @return if the state doesn't have a previous state
     */
    default boolean isFirstState() {
        return getPreviousState() == null;
    }

    /**
     * Check if this state is the last state
     *
     * @return if the state doesn't have a next state
     */
    default boolean isLastState() {
        return getNextState() == null;
    }

    /**
     * Called when entering the state
     *
     * @param context the context
     */
    default void onEnter(GameStateContext context) {}

    /**
     * Called when leaving the state to another state
     *
     * @param context the context
     */
    default void onExit(GameStateContext context) {}

    /**
     * Called when leaving the game
     *
     * @param context the context
     */
    default void onQuit(GameStateContext context) {}

    /**
     * Called every second to update the state
     *
     * @param context the context
     */
    default void onUpdate(GameStateContext context) {}

    /**
     * Called every second to update the scoreboard
     *
     * @param context the context
     */
    default void onScoreboardUpdate(GameStateContext context) {}

}