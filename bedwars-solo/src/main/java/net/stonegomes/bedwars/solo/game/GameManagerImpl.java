package net.stonegomes.bedwars.solo.game;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.arena.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.arena.island.GameIslandMap;
import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import net.stonegomes.bedwars.core.state.GameManager;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@Data
public class GameManagerImpl implements GameManager {

    private final GamePlugin gamePlugin;

    private final GameBuildCache buildCache;
    private final GameGeneratorMap generatorCache;
    private final GameIslandMap islandCache;
    private final GamePlayerCache playerCache;

    private GameState gameState;

    @Override
    public GameStateContext buildContext(Player player, GameState gameState) {
        final GamePlayer gamePlayer = playerCache.getGamePlayer(player.getUniqueId());
        if (gamePlayer == null) return null;

        return GameStateContext.builder()
            .gamePlayer(gamePlayer)
            .gameState(gameState)
            .gameManager(this)
            .build();
    }

    @Override
    public GameStateContext buildContext(Player player) {
        return buildContext(player, gameState);
    }

}
