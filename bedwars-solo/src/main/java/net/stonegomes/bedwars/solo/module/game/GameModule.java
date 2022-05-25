package net.stonegomes.bedwars.solo.module.game;

import lombok.Getter;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.solo.game.GameManagerImpl;
import net.stonegomes.bedwars.solo.game.state.WaitingPlayersGameState;

@ModuleId(id = "gameModule")
public class GameModule extends Module {

    @Getter
    private GameManager gameManager;

    @Override
    public void handleEnable() {
        gameManager = new GameManagerImpl();
        gameManager.setGameState(new WaitingPlayersGameState());
    }

}
