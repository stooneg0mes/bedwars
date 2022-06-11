package net.stonegomes.bedwars.core.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.map.GameMap;
import net.stonegomes.bedwars.core.build.GameBuildCache;
import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.core.player.GamePlayerCache;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

@AllArgsConstructor
@Builder
@Getter
public class GameStateContext {

    private GameManager gameManager;
    private GamePlayer gamePlayer;

    /**
     * Run a game state change, exit & enter methods
     *
     * @param otherState the other state
     */
    public void runStateChange(GameState otherState) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            gameManager.getGameState().onExit(gameManager.buildContext(onlinePlayer));

            if (otherState != null) {
                otherState.onEnter(gameManager.buildContext(onlinePlayer));
            }
        }
    }

    /**
     * Go to the previous game state
     */
    public void backState() {
        runStateChange(gameManager.getGameState().getPreviousState());
    }

    /**
     * Go to the next game state
     */
    public void advanceState() {
        runStateChange(gameManager.getGameState().getNextState());
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

    /**
     * Get the current game state
     *
     * @return the state
     */
    public GameState getGameState() {
        return gameManager.getGameState();
    }

    /**
     * Get the game map
     *
     * @return the map
     */
    public GameMap getGameMap() {
        return gameManager.getGameMap();
    }

    /**
     * Get the game build cache
     *
     * @return the build cache
     */
    public GameBuildCache getBuildCache() {
        return gameManager.getBuildCache();
    }

    /**
     * Get the game player cache
     *
     * @return the player cache
     */
    public GamePlayerCache getPlayerCache() {
        return gameManager.getPlayerCache();
    }

}
