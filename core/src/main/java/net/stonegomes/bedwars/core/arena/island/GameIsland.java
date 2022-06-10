package net.stonegomes.bedwars.core.arena.island;

import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.arena.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.arena.island.member.GameIslandMemberSet;
import net.stonegomes.bedwars.core.arena.island.team.GameTeamColor;
import net.stonegomes.bedwars.core.arena.island.upgrade.GameIslandUpgradeMap;
import org.bukkit.Location;

public interface GameIsland {

    GameTeamColor getTeamColor();

    GameIslandMemberSet getMemberSet();

    GameIslandUpgradeMap getUpgradeMap();

    GameGeneratorMap getGeneratorMap();

    Location getSpawnLocation();

    Cuboid getCuboid();

}
