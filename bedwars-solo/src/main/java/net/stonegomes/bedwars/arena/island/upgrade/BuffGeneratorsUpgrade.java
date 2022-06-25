package net.stonegomes.bedwars.arena.island.upgrade;

import net.stonegomes.bedwars.core.arena.generator.GameGenerator;
import net.stonegomes.bedwars.core.arena.island.GameIsland;
import net.stonegomes.bedwars.core.arena.island.upgrade.GameIslandUpgrade;
import net.stonegomes.bedwars.core.arena.island.upgrade.GameIslandUpgradeType;

public class BuffGeneratorsUpgrade extends GameIslandUpgrade {

    public BuffGeneratorsUpgrade(int level) {
        super(level);
    }

    @Override
    public void onUpgrade(GameIsland gameIsland, int level) {
        for (GameGenerator gameGenerator : gameIsland.getOwner().getGeneratorMap().getGeneratorsByIsland(gameIsland)) {
            if (!gameIsland.getCuboid().contains(gameGenerator.getLocation())) continue;

            switch (level) {
                case 1:
                    gameGenerator.setAmountOfItems(3);
                case 2:
                    gameGenerator.setAmountOfItems(4);
                case 3:
                    gameGenerator.setAmountOfItems(5);
                case 4:
                    gameGenerator.setAmountOfItems(6);
            }
        }
    }

    @Override
    public GameIslandUpgradeType getUpgradeType() {
        return GameIslandUpgradeType.BUFF_GENERATORS;
    }

}
