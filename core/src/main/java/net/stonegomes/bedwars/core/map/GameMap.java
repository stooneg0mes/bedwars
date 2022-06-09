package net.stonegomes.bedwars.core.map;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

@AllArgsConstructor
public class GameMap {

    private final String world;
    private final String name;

    private Location waitingLocation;
    private Location firstWaitingPosition, secondWaitingPosition;


    public Cuboid getWaitingCuboid() {
        return new Cuboid(firstWaitingPosition, secondWaitingPosition);
    }

    public World getWorld() {
        return Bukkit.getWorld(world);
    }

}
