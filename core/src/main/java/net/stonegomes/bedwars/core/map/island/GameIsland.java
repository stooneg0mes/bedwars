package net.stonegomes.bedwars.core.map.island;

import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.map.generator.GameGeneratorMap;
import net.stonegomes.bedwars.core.map.island.member.GameIslandMemberSet;
import net.stonegomes.bedwars.core.map.island.team.GameTeamColor;
import net.stonegomes.bedwars.core.map.island.upgrade.GameIslandUpgradeMap;
import org.bukkit.Location;

public interface GameIsland {

    /**
     * Get the island team color
     *
     * @return the team color
     */
    GameTeamColor getTeamColor();

    /**
     * Get the island member set
     *
     * @return the member set
     */
    GameIslandMemberSet getMemberSet();

    /**
     * Get the island upgrade map
     *
     * @return the upgrade map
     */
    GameIslandUpgradeMap getUpgradeMap();

    /**
     * Get the island generator map
     *
     * @return the generator map
     */
    GameGeneratorMap getGeneratorMap();

    /**
     * Get the island spawn location
     *
     * @return the spawn location
     */
    Location getSpawnLocation();

    /**
     * Get the island cuboid
     *
     * @return the cuboid
     */
    Cuboid getCuboid();

}
