package net.stonegomes.game;

import net.stonegomes.commons.AbstractModulePlugin;
import net.stonegomes.commons.Module;
import net.stonegomes.game.game.module.GameModule;

public class GamePlugin extends AbstractModulePlugin {

    @Override
    public Module[] getModules() {
        return new Module[] {
            new GameModule(this)
        };
    }

}
