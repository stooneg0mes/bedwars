package net.stonegomes.game.game.manager;

import lombok.Data;
import net.stonegomes.core.game.GameManager;
import net.stonegomes.core.game.GameState;

@Data
public class GameManagerImpl implements GameManager {

    private GameState gameState;

}
