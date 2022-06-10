package net.stonegomes.bedwars.core.arena.island.npc;

import org.bukkit.Location;

public interface GameNpc {

    Location getLocation();

    GameNpcType getType();

}
