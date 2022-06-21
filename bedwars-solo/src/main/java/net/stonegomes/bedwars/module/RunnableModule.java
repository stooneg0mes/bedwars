package net.stonegomes.bedwars.module;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.runnable.GameArenaUpdateRunnable;

@ModuleId(id = "listenerModule")
@RequiredArgsConstructor
public class RunnableModule extends Module {

    private final GamePlugin gamePlugin;

    @Override
    public void handleEnable() {
        new GameArenaUpdateRunnable(gamePlugin).runTaskTimerAsynchronously(gamePlugin, 0L, 20L);
    }

}
