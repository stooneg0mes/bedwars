package net.stonegomes.bedwars.core.generator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bukkit.Location;
import org.bukkit.Material;

@AllArgsConstructor
@Builder
@Data
public class GameGenerator {

    private final Location location;
    private final Material type;

    private int amountOfItems;
    private long timeToGenerate;
    private long delay;

}
