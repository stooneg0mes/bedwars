package net.stonegomes.bedwars.ecostudios.solo.game;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.build.GameBuildSet;
import net.stonegomes.bedwars.core.arena.GameArenaCache;
import net.stonegomes.bedwars.core.arena.GameArenaDao;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import net.stonegomes.bedwars.core.arena.player.GamePlayerMap;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import net.stonegomes.bedwars.ecostudios.solo.game.state.setup.SetupGameState;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@Data
public class GameManagerImpl implements GameManager {

    private final GameBuildSet buildCache;
    private final GamePlayerMap playerCache;
    private final GameArenaCache mapCache;

    private final GameArenaDao mapDao;

    private GameState gameState;
    private GameArena gameArena;

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
