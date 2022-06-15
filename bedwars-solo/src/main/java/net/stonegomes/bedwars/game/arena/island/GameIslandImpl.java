package net.stonegomes.bedwars.game.arena.island;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.arena.island.GameIsland;
import net.stonegomes.bedwars.core.arena.island.member.GameIslandMemberSet;
import net.stonegomes.bedwars.core.arena.island.team.GameTeamColor;
import net.stonegomes.bedwars.core.arena.island.upgrade.GameIslandUpgradeMap;
import org.bukkit.Location;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class GameIslandImpl implements GameIsland {

    @Getter(AccessLevel.NONE)
    private static final GamePlugin gamePlugin = GamePlugin.getInstance();

    private final UUID uniqueId;
    private final UUID owner;
    private final GameTeamColor teamColor;

    private final GameIslandMemberSet memberSet;

    private final GameIslandUpgradeMap upgradeMap;
    private final GameGeneratorMap generatorMap;

    private final Location spawnLocation;
    private final Location firstPosition, secondPosition;

    @Override
    public Cuboid getCuboid() {
        return new Cuboid(firstPosition, secondPosition);
    }

    @Override
    public GameArena getOwner() {
        return gamePlugin.getArenaCache().getGameArena(owner);
    }

}
