package net.stonegomes.bedwars.arena.state.impl.setup;

import net.stonegomes.bedwars.arena.state.DefaultGameState;

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
