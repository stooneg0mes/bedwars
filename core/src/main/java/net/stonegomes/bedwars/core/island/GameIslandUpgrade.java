package net.stonegomes.bedwars.core.island;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public interface GameIslandUpgrade {

    default void onUpgrade(GameIsland gameIsland, int level) {}

    GameIslandUpgradeType getUpgradeType();

    void setLevel(int level);

    int getLevel();

    int getInitialLevel();

}
