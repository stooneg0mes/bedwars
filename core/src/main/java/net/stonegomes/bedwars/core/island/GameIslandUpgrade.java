package net.stonegomes.bedwars.core.island;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public abstract class GameIslandUpgrade {

    private int level;

    public GameIslandUpgrade() {
        this.level = getInitialLevel();
    }

    public abstract GameIslandUpgradeType getUpgradeType();

    public abstract int getInitialLevel();

    public void onUpgrade(GameIsland gameIsland, int level) {}

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
