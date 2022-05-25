package net.stonegomes.bedwars.core.generator;

import org.bukkit.Location;

import java.util.Collection;
import java.util.UUID;

public interface GameGeneratorCache {

    void putGameGenerator(Location location, GameGenerator gameGenerator);

    void removeGameGenerator(UUID uuid, GameGenerator gameGenerator);

    GameGenerator getGameGenerator(UUID uuid);

    Collection<GameGenerator> getGameGenerators();

}