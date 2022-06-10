package net.stonegomes.bedwars.solo.game.island.upgrade;

import net.stonegomes.bedwars.core.map.generator.GameGenerator;
import net.stonegomes.bedwars.core.map.island.GameIsland;
import net.stonegomes.bedwars.core.map.island.upgrade.GameIslandUpgrade;
import net.stonegomes.bedwars.core.map.island.upgrade.GameIslandUpgradeType;

public class BuffGeneratorsUpgrade extends GameIslandUpgrade {

    public BuffGeneratorsUpgrade(int level) {
        super(level);
    }

    @Override
    public void onUpgrade(GameIsland gameIsland, int level) {
        for (GameGenerator gameGenerator : gameIsland.getGeneratorMap().getGenerators()) {
            if (!gameIsland.getCuboid().contains(gameGenerator.getLocation())) continue;

            switch (level) {
                case 1: gameGenerator.setAmountOfItems(3);
                case 2: gameGenerator.setAmountOfItems(4);
                case 3: gameGenerator.setAmountOfItems(5);
                case 4: gameGenerator.setAmountOfItems(6);
            }
        }
    }

    @Override
    public GameIslandUpgradeType getUpgradeType() {
        return GameIslandUpgradeType.BUFF_GENERATORS;
    }

}
