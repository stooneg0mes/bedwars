package net.stonegomes.bedwars.core.generator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;

@AllArgsConstructor
@Builder
@Getter
public class GameGenerator {

    private Location location;
    private Material type;
    private long timeToGenerate;

}
