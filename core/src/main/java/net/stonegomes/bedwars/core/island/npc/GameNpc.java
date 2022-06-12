package net.stonegomes.bedwars.core.island.npc;

import org.bukkit.Location;

public interface GameNpc {

    /**
     * Get the game npc location
     *
     * @return the npc location
     */
    Location getLocation();

    /**
     * Get the game npc type
     *
     * @return the npc type
     */
    GameNpcType getType();

}
