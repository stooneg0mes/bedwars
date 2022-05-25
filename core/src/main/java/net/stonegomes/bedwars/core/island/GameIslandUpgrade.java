package net.stonegomes.bedwars.core.island;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
public abstract class GameIslandUpgrade {

    private int level;

    public abstract void onUpgrade(GameIsland gameIsland, int level);

    public abstract GameIslandUpgradeType getUpgradeType();

}
