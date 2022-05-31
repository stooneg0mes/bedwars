package net.stonegomes.bedwars.core.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Delegate;
import net.stonegomes.bedwars.core.player.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

@AllArgsConstructor
@Builder
@Getter
public class GameStateContext {

    @Delegate
    private GameManager gameManager;

    private GameState gameState;
    private GamePlayer gamePlayer;

    public void advanceState() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            gameState.onExit(gameManager.buildContext(onlinePlayer));

            final GameState nextState = gameState.getNextState();
            if (nextState != null) {
                nextState.onEnter(gameManager.buildContext(onlinePlayer));
            }
        }
    }

    public Player getPlayer() {
        return gamePlayer.getBukkitPlayer();
    }

    public Collection<? extends Player> getOnlinePlayers() {
        return Bukkit.getOnlinePlayers();
    }

}
