package net.stonegomes.core.game;


import lombok.AllArgsConstructor;
import lombok.Getter;

public abstract class GameState {

    public abstract GameState getNextState();

    public abstract GameStateType getStateType();

    public void onUpdate(GameStateContext context) {}

    public void onEnter(GameStateContext context) {}

    public void onExit(GameStateContext context) {}

    public void onQuit(GameStateContext context) {}

}