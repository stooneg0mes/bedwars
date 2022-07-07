package net.stonegomes.bedwars.arena.island.upgrade;

import net.stonegomes.bedwars.core.arena.generator.GameGenerator;
import net.stonegomes.bedwars.core.arena.island.GameIsland;
import net.stonegomes.bedwars.core.arena.island.upgrade.GameIslandUpgrade;
import net.stonegomes.bedwars.core.arena.island.upgrade.GameIslandUpgradeType;

public class BuffGeneratorsUpgrade extends GameIslandUpgrade {

    @Override
    public void onUpgrade(GameIsland gameIsland, int level) {
        for (GameGenerator gameGenerator : gameIsland.getOwner().getGeneratorMap().getGeneratorsByIsland(gameIsland)) {
            if (!gameIsland.getCuboid().contains(gameGenerator.getLocation())) continue;

            switch (level) {
                case 1:
                    gameGenerator.setAmountPool(3);
                case 2:
                    gameGenerator.setAmountPool(4);
                case 3:
                    gameGenerator.setAmountPool(5);
                case 4:
                    gameGenerator.setAmountPool(6);
            }
        }
    }

    @Override
    public GameIslandUpgradeType getUpgradeType() {
        return GameIslandUpgradeType.BUFF_GENERATORS;
    }

}
