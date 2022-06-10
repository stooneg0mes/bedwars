package net.stonegomes.bedwars.core.arena.island.npc;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class GameNpcMap {

    private final Map<Location, GameNpc> npcMap = new HashMap<>();

    public void putNpc(Location location, GameNpc gameNpc) {
        npcMap.put(location, gameNpc);
    }

    public GameNpc getNpc(Location location) {
        return npcMap.get(location);
    }

    public boolean hasNpc(Location location) {
        return getNpc(location) != null;
    }

}
