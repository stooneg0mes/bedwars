package net.stonegomes.bedwars.module.game;

import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;

@ModuleId(id = "gameLobbyModule")
@RequiredArgsConstructor
public class GameLobbyModule extends Module {

    private final GamePlugin gamePlugin;

    @Override
    public void handleEnable() {
        /*
        TODO Implement this properly

        final Location spawnFromDatabase = database.getSpawnLocation();
        if (spawnFromDatabase != null) {
            gamePlugin.getLobby().setSpawnLocation(spawnFromDatabase);
        }

        final Location npcFromDatabase = database.getNpcLocation();
        if (npcFromDatabase != null) {
            gamePlugin.getLobby().setNpcLocation(npcFromDatabase);
        }
         */
    }

}
