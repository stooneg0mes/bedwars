package net.stonegomes.bedwars.core.lobby;

import org.bukkit.Location;

public interface GameLobby {

    /**
     * Get the spawn location from the lobby
     *
     * @return the spawn location
     */
    Location getSpawnLocation();

    /**
     * Set the spawn location of the lobby
     *
     * @param location the spawn location
     */
    void setSpawnLocation(Location location);

}
