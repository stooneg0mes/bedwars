package net.stonegomes.bedwars.module;

import lombok.Getter;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.scoreboard.ScoreboardCache;
import net.stonegomes.bedwars.scoreboard.ScoreboardCacheImpl;

@ModuleId(id = "scoreboardModule")
@Getter
public class ScoreboardModule extends Module {

    private ScoreboardCache scoreboardCache;

    @Override
    public void handleEnable() {
        scoreboardCache = new ScoreboardCacheImpl();
    }

}
