package net.stonegomes.bedwars.game.island;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.stonegomes.bedwars.core.arena.generator.GameGenerator;
import org.bukkit.Location;
import org.bukkit.Material;

@AllArgsConstructor
@Builder
@Data
public class GameGeneratorImpl implements GameGenerator {

    private Location location;
    private Material type;

    private int amountOfItems;
    private long timeToGenerate, delay;

}