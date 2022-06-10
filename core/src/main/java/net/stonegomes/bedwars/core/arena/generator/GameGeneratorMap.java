package net.stonegomes.bedwars.core.arena.generator;

import org.bukkit.Location;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameGeneratorMap {

    private final Map<Location, GameGenerator> generatorMap = new HashMap<>();

    public void putGenerator(Location location, GameGenerator gameGenerator) {
        generatorMap.put(location, gameGenerator);
    }

    public GameGenerator getGenerator(Location location) {
        return generatorMap.get(location);
    }

    public boolean hasGenerator(Location location) {
        return getGenerator(location) != null;
    }

    public Collection<GameGenerator> getGenerators() {
        return generatorMap.values();
    }

}