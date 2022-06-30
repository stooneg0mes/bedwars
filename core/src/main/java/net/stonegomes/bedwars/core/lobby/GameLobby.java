package net.stonegomes.bedwars.core.lobby;

import com.github.eokasta.hologram.Hologram;
import com.github.juliarn.npc.NPC;
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

}
