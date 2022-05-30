package net.stonegomes.bedwars.solo.game.state;

import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameStateContext;

public class StartingGameState implements GameState {

    private int timeToLeave = 30;

    @Override
    public String getName() {
        return "Starting Game";
    }

    @Override
    public GameState getNextState() {
        return new InGameState();
    }

    @Override
    public void onUpdate(GameStateContext context) {
        timeToLeave--;

        if (timeToLeave <= 0) {
            context.advanceState();
        }
    }

    @Override
    public void onEnter(GameStateContext context) {
        /*
        TODO
         */
    }

}
