package net.stonegomes.bedwars.solo.game.upgrade;

import net.stonegomes.bedwars.core.generator.GameGenerator;
import net.stonegomes.bedwars.core.generator.GameGeneratorCache;
import net.stonegomes.bedwars.core.island.GameIsland;
import net.stonegomes.bedwars.core.island.GameIslandUpgrade;
import net.stonegomes.bedwars.core.island.GameIslandUpgradeType;
import net.stonegomes.bedwars.solo.GamePlugin;

public class BuffGeneratorsUpgrade extends GameIslandUpgrade {

    private final GameGeneratorCache generatorCache = GamePlugin.getInstance().getGeneratorCache();

    public BuffGeneratorsUpgrade() {
        super(1);
    }

    @Override
    public void onUpgrade(GameIsland gameIsland, int level) {
        for (GameGenerator gameGenerator : generatorCache.getGenerators()) {
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
