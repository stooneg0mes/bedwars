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
    public void putGenerator(Location location, GameGenerator gameGenerator) {
        generatorCache.put(location, gameGenerator);
    }

    @Override
    public void removeGenerator(Location location) {
        generatorCache.remove(location);
    }

    @Override
    public GameGenerator getGenerator(Location location) {
        return generatorCache.get(location);
    }

    @Override
    public Collection<GameGenerator> getGenerators() {
        return generatorCache.values();
    }

}
