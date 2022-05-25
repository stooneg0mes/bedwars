package net.stonegomes.bedwars.solo.game.state;

import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameStateContext;

public class StartingGameState extends GameState {

    private int timeToLeave;

    public StartingGameState() {
        this.timeToLeave = 30;
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

}
