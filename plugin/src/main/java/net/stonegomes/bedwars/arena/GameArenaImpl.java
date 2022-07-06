package net.stonegomes.bedwars.arena;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.stonegomes.bedwars.arena.state.impl.setup.SetupGameState;
import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.build.GameBuildSet;
import net.stonegomes.bedwars.core.arena.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.arena.island.GameIslandMap;
import net.stonegomes.bedwars.core.arena.island.npc.GameNpcMap;
import net.stonegomes.bedwars.core.arena.player.GamePlayerMap;
import net.stonegomes.bedwars.core.arena.state.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class GameArenaImpl implements GameArena {

    private final UUID uniqueId;

    private final String world;

    private final GameBuildSet buildSet;

    private final GameGeneratorMap generatorMap;
    private final GamePlayerMap playerMap;
    private final GameIslandMap islandMap;
    private final GameNpcMap npcMap;

    private Location waitingSecondPosition;
    private Location waitingSpawnLocation;
    private Location waitingFirstPosition;

    private GameState gameState;

    private String name;

    @Override
    public World getWorld() {
        return Bukkit.getWorld(world);
    }

    @Override
    public Cuboid getWaitingCuboid() {
        return new Cuboid(waitingFirstPosition, waitingSecondPosition);
    }

    @Override
    public boolean isOnSetup() {
        return (gameState instanceof SetupGameState);
    }

}
