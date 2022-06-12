package net.stonegomes.bedwars.ecostudios.solo.module;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.ecostudios.solo.GamePlugin;
import net.stonegomes.bedwars.ecostudios.solo.runnable.GameUpdateRunnable;

@ModuleId(id = "listenerModule")
@AllArgsConstructor
public class RunnableModule extends Module {

    private final GamePlugin gamePlugin;

    @Override
    public void handleEnable() {
        new GameUpdateRunnable(gamePlugin).runTaskTimerAsynchronously(gamePlugin, 0L, 20L);
    }

}
