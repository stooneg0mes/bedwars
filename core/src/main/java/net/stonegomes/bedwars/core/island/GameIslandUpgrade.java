package net.stonegomes.bedwars.core.island;

import lombok.Data;

@Data
public abstract class GameIslandUpgrade {

    private final int initialLevel;
    private int level;

    public GameIslandUpgrade(int initialLevel) {
        this.initialLevel = initialLevel;
        this.level = initialLevel;
    }

    /**
     * The type of this upgrade.
     * @return the upgrade type.
     */
    public abstract GameIslandUpgradeType getUpgradeType();

    /**
     * Called when running the upgrade.
     * @param gameIsland the island that is being upgraded.
     * @param level the level of the upgrade.
     */
    public void onUpgrade(GameIsland gameIsland, int level) {}

}
