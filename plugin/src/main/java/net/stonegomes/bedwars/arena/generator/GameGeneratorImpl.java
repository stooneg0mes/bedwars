package net.stonegomes.bedwars.arena.generator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.stonegomes.bedwars.core.arena.generator.GameGenerator;
import net.stonegomes.bedwars.core.arena.island.GameIsland;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.Set;

@AllArgsConstructor
@Builder
@Data
public class GameGeneratorImpl implements GameGenerator {

    private final GameIsland owner;

    private Location location;
    private Set<Material> materialPool;

    private int amountPool;
    private long timeToGenerate, delay;

}
