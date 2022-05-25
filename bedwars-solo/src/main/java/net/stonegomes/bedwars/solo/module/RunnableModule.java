package net.stonegomes.bedwars.solo.module;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.solo.GamePlugin;
import net.stonegomes.bedwars.solo.runnable.GameUpdateRunnable;

@ModuleId(id = "listenerModule")
public class RunnableModule extends Module {

    private final GamePlugin gamePlugin;
    private final GameManager gameManager;

    public RunnableModule(GamePlugin gamePlugin) {
        this.gamePlugin = gamePlugin;
        this.gameManager = gamePlugin.getGameManager();
    }

    @Override
    public void handleEnable() {
        new GameUpdateRunnable(gameManager).runTaskTimerAsynchronously(gamePlugin, 0L, 20L);
    }

}
