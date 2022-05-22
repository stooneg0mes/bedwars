package net.stonegomes.game.game.module;

import lombok.Data;
import lombok.Getter;
import net.stonegomes.commons.Module;
import net.stonegomes.commons.ModuleId;
import net.stonegomes.core.game.GameManager;
import net.stonegomes.core.game.GameState;
import net.stonegomes.game.game.WaitingPlayersStateImpl;
import net.stonegomes.game.game.manager.GameManagerImpl;

@ModuleId(id = "gameModule")
public class GameModule extends Module {

    @Getter
    private GameManager gameManager;

    @Override
    public void handleEnable() {
        gameManager = new GameManagerImpl();
        gameManager.setGameState(new WaitingPlayersStateImpl());
    }

}
