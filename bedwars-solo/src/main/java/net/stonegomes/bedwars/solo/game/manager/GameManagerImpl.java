package net.stonegomes.bedwars.solo.game.manager;

import lombok.Data;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.game.GameState;

@Data
public class GameManagerImpl implements GameManager {

    private GameState gameState;

}
