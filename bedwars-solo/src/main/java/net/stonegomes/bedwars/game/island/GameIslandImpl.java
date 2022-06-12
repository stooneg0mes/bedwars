package net.stonegomes.bedwars.game.island;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.island.GameIsland;
import net.stonegomes.bedwars.core.island.member.GameIslandMemberSet;
import net.stonegomes.bedwars.core.island.team.GameTeamColor;
import net.stonegomes.bedwars.core.island.upgrade.GameIslandUpgradeMap;
import org.bukkit.Location;

@AllArgsConstructor
@Builder
@Getter
public class GameIslandImpl implements GameIsland {

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

}
