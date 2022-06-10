package net.stonegomes.bedwars.core.player;

import net.stonegomes.bedwars.core.arena.island.GameIsland;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface GamePlayer {

    /**
     * Get the game player unique id
     * @return the unique id
     */
    UUID getUniqueId();

    /**
     * Get the game player island
     * @return the island
     */
    GameIsland getIsland();

    /**
     * Set the game player island
     * @param island the new island
     */
    void setIsland(GameIsland island);

    /**
     * Get the game player spectator time
     * @return the player spectator time
     */
    Long getSpectatorTime();

    /**
     * Set the game player spectator time
     * @param time the spectator time
     */
    void setSpectatorTime(Long time);

    /**
     * Check if the game player is spectator
     * @return if the player is spectator
     */
    boolean isSpectator();

    /**
     * Get the bukkit game player
     * @return the player
     */
    Player getBukkitPlayer();

}
