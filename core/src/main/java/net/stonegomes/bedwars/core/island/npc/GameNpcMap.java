package net.stonegomes.bedwars.core.island.npc;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class GameNpcMap {

    private final Map<Location, GameNpc> npcMap = new HashMap<>();

    /**
     * Put a npc in the map
     *
     * @param location the npc location
     * @param gameNpc  the game npc
     */
    public void putNpc(Location location, GameNpc gameNpc) {
        npcMap.put(location, gameNpc);
    }

    /**
     * Get a npc from the map
     *
     * @param location the npc location
     * @return the game npc
     */
    public GameNpc getNpc(Location location) {
        return npcMap.get(location);
    }

    /**
     * Check if the map has a npc
     *
     * @param location the npc location
     * @return if the map has this npc
     */
    public boolean hasNpc(Location location) {
        return getNpc(location) != null;
    }

}
