package net.stonegomes.bedwars.core.generator;

import org.bukkit.Location;

import java.util.Collection;

public interface GameGeneratorCache {

    /**
     * Put a generator in the cache.
     * @param location the location of the generator
     * @param gameGenerator the generator
     */
    void putGenerator(Location location, GameGenerator gameGenerator);

    /**
     * Remove a generator from the cache.
     * @param location the location of the generator
     */
    void removeGenerator(Location location);

    /**
     * Get a generator from the cache.
     * @param location the location of the generator
     * @return the generator
     */
    GameGenerator getGenerator(Location location);

    /**
     * Get all generators in the cache.
     * @return all generators
     */
    Collection<GameGenerator> getGenerators();

}