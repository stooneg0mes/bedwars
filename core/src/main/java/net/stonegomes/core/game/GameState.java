package net.stonegomes.core.game;


import lombok.AllArgsConstructor;
import lombok.Getter;

public interface GameState {

    GameState getNextState();

    GameStateType getStateType();

    void onUpdate(GameStateContext context);

    void onEnter(GameStateContext context);

    void onExit(GameStateContext context);

}