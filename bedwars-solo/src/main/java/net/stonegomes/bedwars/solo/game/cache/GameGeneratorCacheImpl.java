package net.stonegomes.bedwars.solo.game.cache;

import net.stonegomes.bedwars.core.generator.GameGenerator;
import net.stonegomes.bedwars.core.generator.GameGeneratorCache;
import org.bukkit.Location;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameGeneratorCacheImpl implements GameGeneratorCache {

    private final Map<Location, GameGenerator> generatorCache = new HashMap<>();

    @Override
    public void putGameGenerator(Location location, GameGenerator gameGenerator) {
        generatorCache.put(location, gameGenerator);
    }

    @Override
    public void removeGameGenerator(Location location, GameGenerator gameGenerator) {
        generatorCache.remove(location, gameGenerator);
    }

    @Override
    public GameGenerator getGameGenerator(Location location) {
        return generatorCache.get(location);
    }

    @Override
    public Collection<GameGenerator> getGameGenerators() {
        return generatorCache.values();
    }

}
