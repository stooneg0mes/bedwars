package net.stonegomes.bedwars.solo;

import net.stonegomes.bedwars.commons.AbstractModulePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.solo.game.module.GameModule;

public class GamePlugin extends AbstractModulePlugin {

    @Override
    public Module[] getModules() {
        return new Module[] {
            new GameModule(this)
        };
    }

}
