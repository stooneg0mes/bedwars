package net.stonegomes.bedwars.core.generator;

import org.bukkit.Location;

import java.util.Collection;

public interface GameGeneratorCache {

    void putGenerator(Location location, GameGenerator gameGenerator);

    void removeGenerator(Location location);

    GameGenerator getGenerator(Location location);

    Collection<GameGenerator> getGenerators();

}