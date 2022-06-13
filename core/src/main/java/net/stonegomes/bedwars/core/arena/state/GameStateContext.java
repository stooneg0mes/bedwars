package net.stonegomes.bedwars.core.arena.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Delegate;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

@AllArgsConstructor
@Builder
@Getter
public class GameStateContext {

    @Delegate
    private GameManager gameManager;

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
            gameArena.getGameState().onExit(gameManager.buildContext(onlinePlayer));

            if (otherState != null) {
                otherState.onEnter(gameManager.buildContext(onlinePlayer));
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
