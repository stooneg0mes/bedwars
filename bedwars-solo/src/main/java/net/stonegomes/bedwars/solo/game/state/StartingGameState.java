package net.stonegomes.bedwars.solo.game.state;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameStateContext;
import net.stonegomes.bedwars.solo.GamePlugin;

@RequiredArgsConstructor
public class StartingGameState extends GameState {

    private final GamePlugin gamePlugin;

    private int timeToLeave = 30;

    @Override
    public GameState getNextState() {
        return new InGameState(gamePlugin);
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
