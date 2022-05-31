package net.stonegomes.bedwars.core.state;

import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.stonegomes.bedwars.core.player.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
public class GameStateContext {

    @Getter(AccessLevel.NONE)
    private GameManager gameManager;

    private GameState gameState;
    private GamePlayer gamePlayer;

    public void advanceState() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            gameState.handleExit(gameManager.buildContext(onlinePlayer));

            final GameState nextState = gameState.getNextState();
            if (nextState != null) {
                nextState.handleEnter(gameManager.buildContext(onlinePlayer));
            }
        }
    }

    public Player getPlayer() {
        return gamePlayer.getBukkitPlayer();
    }

    public Set<Player> getOnlinePlayers() {
        return Sets.newHashSet(Bukkit.getOnlinePlayers());
    }

    public int getOnlinePlayersSize() {
        return Bukkit.getOnlinePlayers().size();
    }

}
