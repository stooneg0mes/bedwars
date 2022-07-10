package net.stonegomes.bedwars.core.lobby;

import com.github.juliarn.npc.NPC;
import eu.decentsoftware.holograms.api.holograms.Hologram;
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

    /**
     * Check if the game lobby has a spawn location
     *
     * @return if the lobby has a spawn location
     */
    default boolean hasSpawnLocation() {
        return getSpawnLocation() != null;
    }

    /**
     * Get the npc from the lobby
     *
     * @return the npc
     */
    NPC getNpc();

    /**
     * Set the npc of the lobby
     *
     * @param npc the npc
     */
    void setNpc(NPC npc);

    /**
     * Check if the game lobby has a NPC
     *
     * @return if the lobby has a NPC
     */
    default boolean hasNpc() {
        return getNpc() != null;
    }

    /**
     * Get the npc hologram from the lobby
     *
     * @return the npc hologram
     */
    Hologram getNpcHologram();

    /**
     * Set the npc hologram of the lobby
     *
     * @param hologram the npc hologram
     */
    void setNpcHologram(Hologram hologram);

    /**
     * Check if the game lobby has a NPC hologram
     *
     * @return if the lobby has a NPC hologram
     */
    default boolean hasNpcHologram() {
        return getNpcHologram() != null;
    }

}
