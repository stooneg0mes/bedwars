package net.stonegomes.bedwars.core.arena.generator;

import org.bukkit.Location;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameGeneratorMap {

    private final Map<Location, GameGenerator> generatorMap = new HashMap<>();

    /**
     * Put a generator in the map
     *
     * @param location      the generator location
     * @param gameGenerator the game generator
     */
    public void putGenerator(Location location, GameGenerator gameGenerator) {
        generatorMap.put(location, gameGenerator);
    }

    /**
     * Get a generator from the map
     *
     * @param location the generator location
     * @return the game generator
     */
    public GameGenerator getGenerator(Location location) {
        return generatorMap.get(location);
    }

    /**
     * Check if the map has a generator
     *
     * @param location the generator location
     * @return if the map has this generator
     */
    public boolean hasGenerator(Location location) {
        return getGenerator(location) != null;
    }

    /**
     * Get all the generators from the map
     *
     * @return all the generators
     */
    public Collection<GameGenerator> getGenerators() {
        return generatorMap.values();
    }

}