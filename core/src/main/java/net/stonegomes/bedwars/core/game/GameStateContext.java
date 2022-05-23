package net.stonegomes.bedwars.core.game;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Set;

@AllArgsConstructor
@Getter
public class GameStateContext {

    private GameState gameState;
    private Player player;

    public void advanceState() {
        GameState nextState = gameState.getNextState();

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            GameStateContext currentStateContext = new GameStateContext(gameState, onlinePlayer);
            gameState.onExit(currentStateContext);

            GameStateContext nextStateContext = new GameStateContext(nextState, onlinePlayer);
            gameState.onEnter(nextStateContext);
        }
    }

    public Set<Player> getOnlinePlayers() {
        return Sets.newHashSet(Bukkit.getOnlinePlayers());
    }

    public int getOnlinePlayersSize() {
        return Bukkit.getOnlinePlayers().size();
    }

}
