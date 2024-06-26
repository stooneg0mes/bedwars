package net.stonegomes.bedwars.core.arena.island.upgrade;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.stonegomes.bedwars.core.arena.island.GameIsland;

@AllArgsConstructor
@Data
public abstract class GameIslandUpgrade {

    private int level;

    public GameIslandUpgrade() {
        this.level = getInitialLevel();
    }

    /**
     * The type of this upgrade.
     *
     * @return the upgrade type.
     */
    public abstract GameIslandUpgradeType getUpgradeType();

    /**
     * Get the game island upgrade initial level
     *
     * @return the upgrade initial level
     */
    public int getInitialLevel() {
        return 1;
    }

    /**
     * Called when running the upgrade.
     *
     * @param gameIsland the island that is being upgraded.
     * @param level      the level of the upgrade.
     */
    public void onUpgrade(GameIsland gameIsland, int level) {
    }

}
