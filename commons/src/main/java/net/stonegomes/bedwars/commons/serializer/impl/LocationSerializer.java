package net.stonegomes.bedwars.commons.serializer.impl;

import lombok.Getter;
import net.stonegomes.bedwars.commons.serializer.Serializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationSerializer implements Serializer<Location> {

    @Getter
    private static final LocationSerializer instance = new LocationSerializer();

    @Override
    public String serialize(Location value) {
        if (value == null || value.getWorld() == null) return "Empty";

        return value.getWorld().getName() + ";" + value.getX() + ";" + value.getY() + ";" + value.getZ() + ";" + value.getYaw() + ";" + value.getPitch();
    }

    @Override
    public Location deserialize(String key) {
        if (key.equals("Empty")) return null;

        String[] splitKey = key.split(";");

        World world = Bukkit.getWorld(splitKey[0]);
        if (world == null) return null;

        return new Location(world,
            Double.parseDouble(splitKey[1]),
            Double.parseDouble(splitKey[2]),
            Double.parseDouble(splitKey[3]),
            Float.parseFloat(splitKey[4]),
            Float.parseFloat(splitKey[5])
        );
    }

}