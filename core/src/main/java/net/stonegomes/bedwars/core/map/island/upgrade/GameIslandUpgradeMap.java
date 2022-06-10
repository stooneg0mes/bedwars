package net.stonegomes.bedwars.core.map.island.upgrade;

import java.util.HashMap;
import java.util.Map;

public class GameIslandUpgradeMap {

    private final Map<GameIslandUpgradeType, GameIslandUpgrade> upgradeMap = new HashMap<>();

    /**
     * Get an upgrade from the map
     *
     * @param upgradeType the upgrade type
     * @return the game upgrade
     */
    public GameIslandUpgrade getUpgrade(GameIslandUpgradeType upgradeType) {
        return upgradeMap.get(upgradeType);
    }

    /**
     * Check if the map has an upgrade
     *
     * @param upgradeType the upgrade type
     * @return if the map has this upgrade
     */
    public boolean hasUpgrade(GameIslandUpgradeType upgradeType) {
        return upgradeMap.containsKey(upgradeType);
    }

    /**
     * Put an upgrade in the map
     *
     * @param upgradeType the upgrade type
     * @param upgrade     the game upgrade
     */
    public void putUpgrade(GameIslandUpgradeType upgradeType, GameIslandUpgrade upgrade) {
        upgradeMap.put(upgradeType, upgrade);
    }

}
