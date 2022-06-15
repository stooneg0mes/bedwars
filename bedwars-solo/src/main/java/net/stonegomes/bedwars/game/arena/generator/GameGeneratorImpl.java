package net.stonegomes.bedwars.game.arena.generator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.stonegomes.bedwars.core.arena.generator.GameGenerator;
import net.stonegomes.bedwars.core.arena.island.GameIsland;
import org.bukkit.Location;
import org.bukkit.Material;

@AllArgsConstructor
@Builder
@Data
public class GameGeneratorImpl implements GameGenerator {

    private final GameIsland owner;

    private Location location;
    private Material type;

    private int amountOfItems;
    private long timeToGenerate, delay;

}
