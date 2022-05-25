package net.stonegomes.bedwars.core.game;

import org.bukkit.entity.Player;

public interface GameManager {

    void setGameState(GameState gameState);

    GameState getGameState();

    GameStateContext buildContext(Player player);

    GameStateContext buildContext(Player player, GameState gameState);

}
