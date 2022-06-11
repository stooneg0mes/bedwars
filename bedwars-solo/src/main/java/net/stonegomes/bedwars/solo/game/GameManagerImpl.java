package net.stonegomes.bedwars.solo.game;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.core.map.GameMap;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.map.GameMapCache;
import net.stonegomes.bedwars.core.map.GameMapDao;
import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import net.stonegomes.bedwars.solo.game.state.setup.SetupGameState;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@Data
public class GameManagerImpl implements GameManager {

    private final GameBuildCache buildCache;
    private final GamePlayerCache playerCache;
    private final GameMapCache mapCache;

    private final GameMapDao mapDao;

    private GameState gameState;
    private GameMap gameMap;

    @Override
    public boolean isOnSetup() {
        return (gameState instanceof SetupGameState);
    }

    @Override
    public GameStateContext buildContext(Player player, GameState gameState) {
        final GamePlayer gamePlayer = playerCache.getGamePlayer(player.getUniqueId());
        if (gamePlayer == null) return null;

        return GameStateContext.builder()
            .gamePlayer(gamePlayer)
            .gameManager(this)
            .build();
    }

    @Override
    public GameStateContext buildContext(Player player) {
        return buildContext(player, gameState);
    }

}
