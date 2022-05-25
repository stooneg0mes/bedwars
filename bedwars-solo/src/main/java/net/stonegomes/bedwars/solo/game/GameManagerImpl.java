package net.stonegomes.bedwars.solo.game;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameStateContext;
import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@Data
public class GameManagerImpl implements GameManager {

    private final GamePlugin gamePlugin;

    private GameState gameState;

    @Override
    public GameStateContext buildContext(Player player, GameState gameState) {
        final GamePlayer gamePlayer = gamePlugin.getPlayerCache().getGamePlayer(player.getUniqueId());
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
