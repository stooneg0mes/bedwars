package net.stonegomes.bedwars.core.arena.island;

import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.island.member.GameIslandMemberSet;
import net.stonegomes.bedwars.core.arena.island.team.GameTeamColor;
import net.stonegomes.bedwars.core.arena.island.upgrade.GameIslandUpgradeMap;
import org.bukkit.Location;

import java.util.UUID;

public interface GameIsland {

    /**
     * Get the game island unique id
     *
     * @return the island unique id
     */
    UUID getUniqueId();

    /**
     * Get the game island arena owner
     * @return the arena owner
     */
    GameArena getOwner();

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
