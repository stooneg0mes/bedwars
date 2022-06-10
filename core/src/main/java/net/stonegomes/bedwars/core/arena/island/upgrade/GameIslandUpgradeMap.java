package net.stonegomes.bedwars.core.arena.island.upgrade;

import java.util.HashMap;
import java.util.Map;

public class GameIslandUpgradeMap {

    private final Map<GameIslandUpgradeType, GameIslandUpgrade> upgradeMap = new HashMap<>();

    public GameIslandUpgrade getUpgrade(GameIslandUpgradeType upgradeType) {
        return upgradeMap.get(upgradeType);
    }

    public void setUpgrade(GameIslandUpgradeType upgradeType, GameIslandUpgrade upgrade) {
        upgradeMap.put(upgradeType, upgrade);
    }

}
