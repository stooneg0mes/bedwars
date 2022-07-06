package net.stonegomes.bedwars.process.creation;

import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.arena.GameArenaImpl;
import net.stonegomes.bedwars.arena.state.impl.setup.SetupGameState;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.build.GameBuildSet;
import net.stonegomes.bedwars.core.arena.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.arena.island.GameIslandMap;
import net.stonegomes.bedwars.core.arena.island.npc.GameNpcMap;
import net.stonegomes.bedwars.core.arena.player.GamePlayerMap;
import net.stonegomes.bedwars.core.process.Process;
import net.stonegomes.bedwars.core.process.ProcessContext;
import net.stonegomes.bedwars.process.creation.phase.NameCreatePhase;
import net.stonegomes.bedwars.process.creation.phase.WaitingFirstPositionCreatePhase;
import net.stonegomes.bedwars.process.creation.phase.WaitingSecondPositionCreatePhase;
import net.stonegomes.bedwars.process.creation.phase.WaitingSpawnCreatePhase;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ArenaCreationProcess extends Process {

    private final GamePlugin gamePlugin;
    private final World world;

    public ArenaCreationProcess(GamePlugin gamePlugin, World world) {
        this.gamePlugin = gamePlugin;
        this.world = world;

        addPhases(
            new NameCreatePhase(),
            new WaitingSpawnCreatePhase(),
            new WaitingFirstPositionCreatePhase(),
            new WaitingSecondPositionCreatePhase()
        );
    }

    @Override
    public void onFinish(Player player, ProcessContext context) {
        GameArena gameArena = GameArenaImpl.builder()
            .uniqueId(UUID.randomUUID())
            .world(world.getName())
            .buildSet(new GameBuildSet())
            .playerMap(new GamePlayerMap())
            .generatorMap(new GameGeneratorMap())
            .islandMap(new GameIslandMap())
            .npcMap(new GameNpcMap())
            .gameState(new SetupGameState())
            .name(context.get("name"))
            .waitingSpawnLocation(context.get("waitingSpawnLocation"))
            .waitingFirstPosition(context.get("waitingFirstPosition"))
            .waitingSecondPosition(context.get("waitingSecondPosition"))
            .build();

        gamePlugin.getArenaCache().putGameArena(gameArena.getUniqueId(), gameArena);
        player.sendMessage("§2§lBIG CATS §7You created the arena §a" + gameArena.getName() + "§7 successfully!");
    }

}
