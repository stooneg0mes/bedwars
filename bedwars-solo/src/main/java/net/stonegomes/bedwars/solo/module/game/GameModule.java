package net.stonegomes.bedwars.solo.module.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.state.GameManager;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.game.GameManagerImpl;
import net.stonegomes.bedwars.solo.game.state.WaitingPlayersGameState;

@ModuleId(id = "gameModule")
@RequiredArgsConstructor
public class GameModule extends Module {

    private final GamePlugin gamePlugin;

    @Getter
    private GameManager gameManager;

    @Override
    public void handleEnable() {
        gameManager = new GameManagerImpl(gamePlugin);
        gameManager.setGameState(new WaitingPlayersGameState());
    }

}
