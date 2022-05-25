package net.stonegomes.bedwars.core.island;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import net.stonegomes.bedwars.commons.cuboid.Cuboid;
import net.stonegomes.bedwars.core.game.GameTeamColor;
import net.stonegomes.bedwars.core.player.GamePlayer;
import org.bukkit.Location;

import java.util.Set;

@AllArgsConstructor
@Builder
@Data
public class GameIsland {

    private final GameTeamColor teamColor;

    private final Set<GamePlayer> players;
    private final Set<GameIslandUpgrade> upgrades;

    private final Location spawnLocation;
    private final Location firstPosition;
    private final Location secondPosition;

    public Cuboid getCuboid() {
        return new Cuboid(firstPosition, secondPosition);
    }

    public GameIslandUpgrade getUpgrade(GameIslandUpgradeType upgradeType) {
        return upgrades.stream()
            .filter(gameIslandUpgrade -> gameIslandUpgrade.getUpgradeType() == upgradeType)
            .findFirst()
            .orElse(null);
    }

}
