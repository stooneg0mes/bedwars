package net.stonegomes.bedwars.game.arena.state.impl.setup;

import net.stonegomes.bedwars.game.arena.state.DefaultGameState;

public class SetupGameState extends DefaultGameState {

    @Override
    public String getName() {
        return "Setup";
    }

    @Override
    public boolean canEnter() {
        return true;
    }

}
