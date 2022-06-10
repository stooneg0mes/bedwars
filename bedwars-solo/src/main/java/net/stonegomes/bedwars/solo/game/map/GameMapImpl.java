package net.stonegomes.bedwars.solo.game.map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.map.GameMap;
import net.stonegomes.bedwars.core.map.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.map.island.GameIslandMap;
import net.stonegomes.bedwars.core.map.island.npc.GameNpcMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class GameMapImpl implements GameMap {

    private final UUID uniqueId;

    private final String world;

    private final GameGeneratorMap generatorMap;
    private final GameIslandMap islandMap;
    private final GameNpcMap npcMap;

    private String name;

    private Location waitingSpawnLocation;
    private Location waitingFirstPosition, waitingSecondPosition;

    @Override
    public World getWorld() {
        return Bukkit.getWorld(world);
    }

    @Override
    public Cuboid getWaitingCuboid() {
        return new Cuboid(waitingFirstPosition, waitingSecondPosition);
    }
}
