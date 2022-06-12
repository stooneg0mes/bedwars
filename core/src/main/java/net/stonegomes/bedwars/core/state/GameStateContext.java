package net.stonegomes.bedwars.core.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.stonegomes.bedwars.core.GameArena;
import net.stonegomes.bedwars.core.player.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

@AllArgsConstructor
@Builder
@Getter
public class GameStateContext {

    private GameArena gameArena;
    private GamePlayer gamePlayer;

    /**
     * Get the current game state
     *
     * @return the state
     */
    public GameState getGameState() {
        return gameArena.getGameState();
    }

    /**
     * Run a game state change, exit & enter methods
     *
     * @param otherState the other state
     */
    public void runStateChange(GameState otherState) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            gameArena.getGameState().onExit(gameArena.buildContext(onlinePlayer));

            if (otherState != null) {
                otherState.onEnter(gameArena.buildContext(onlinePlayer));
            }
        }
    }

    /**
     * Go to the previous game state
     */
    public void backState() {
        runStateChange(gameArena.getGameState().getPreviousState());
    }

    /**
     * Go to the next game state
     */
    public void advanceState() {
        runStateChange(gameArena.getGameState().getNextState());
    }

    /**
     * Get the bukkit player
     *
     * @return the player
     */
    public Player getPlayer() {
        return gamePlayer.getBukkitPlayer();
    }

    /**
     * Get the server online players
     *
     * @return the online players
     */
    public Collection<? extends Player> getOnlinePlayers() {
        return Bukkit.getOnlinePlayers();
    }

}
