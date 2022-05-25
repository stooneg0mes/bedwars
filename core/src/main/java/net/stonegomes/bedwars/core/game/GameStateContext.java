package net.stonegomes.bedwars.core.game;

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
            GameStateContext currentStateContext = gameManager.buildContext(onlinePlayer);
            gameState.onExit(currentStateContext);

            GameState nextState = gameState.getNextState();
            if (nextState != null) {
                GameStateContext nextStateContext = gameManager.buildContext(onlinePlayer);
                if (!nextState.isFirstState()) nextState.onEnter(nextStateContext);
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
