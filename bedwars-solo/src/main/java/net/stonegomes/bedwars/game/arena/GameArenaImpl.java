package net.stonegomes.bedwars.game.arena;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.GameArena;
import net.stonegomes.bedwars.core.build.GameBuildSet;
import net.stonegomes.bedwars.core.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.island.GameIslandMap;
import net.stonegomes.bedwars.core.island.npc.GameNpcMap;
import net.stonegomes.bedwars.core.player.GamePlayerMap;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import net.stonegomes.bedwars.game.state.setup.SetupGameState;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class GameArenaImpl implements GameArena {

    private final UUID uniqueId;

    private final String world;

    private final GameBuildSet buildSet;

    private final GamePlayerMap playerMap;
    private final GameGeneratorMap generatorMap;
    private final GameIslandMap islandMap;
    private final GameNpcMap npcMap;

    private GameState gameState;

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

    @Override
    public boolean isOnSetup() {
        return (gameState instanceof SetupGameState);
    }

    @Override
    public GameStateContext buildContext(Player player) {
        return GameStateContext.builder()
            .gamePlayer(playerMap.getGamePlayer(player.getUniqueId()))
            .gameArena(this)
            .build();
    }

    @Override
    public GameStateContext buildContext(Player player, GameArena gameArena) {
        return GameStateContext.builder()
            .gamePlayer(gameArena.getPlayerMap().getGamePlayer(player.getUniqueId()))
            .gameArena(gameArena)
            .build();
    }

}
