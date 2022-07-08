package net.stonegomes.bedwars.module.game;

import lombok.Getter;
import net.stonegomes.bedwars.arena.GameArenaCacheImpl;
import net.stonegomes.bedwars.arena.GameArenaDaoImpl;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import net.stonegomes.bedwars.core.process.ProcessCache;
import net.stonegomes.bedwars.core.scoreboard.ScoreboardCache;
import net.stonegomes.bedwars.lobby.GameLobbyImpl;
import net.stonegomes.bedwars.manager.GameManagerImpl;
import net.stonegomes.bedwars.process.ProcessCacheImpl;
import net.stonegomes.bedwars.scoreboard.ScoreboardCacheImpl;

@ModuleId(id = "gameModule")
public class GameModule extends Module {

    @Getter
    private GameManager gameManager;

    /**
     * Handling on load for higher priority
     */
    @Override
    public void handleLoad() {
        gameManager = new GameManagerImpl(
            new GameArenaCacheImpl(),
            new GameArenaDaoImpl(),
            new ScoreboardCacheImpl(),
            new ProcessCacheImpl(),
            new GameLobbyImpl()
        );


    }

    public GameArenaCache getArenaCache() {
        return gameManager.getArenaCache();
    }

    public GameArenaDao getArenaDao() {
        return gameManager.getArenaDao();
    }

    public ScoreboardCache getScoreboardCache() {
        return gameManager.getScoreboardCache();
    }

    public ProcessCache getProcessCache() {
        return gameManager.getProcessCache();
    }

    public GameLobby getLobby() {
        return gameManager.getLobby();
    }

}
