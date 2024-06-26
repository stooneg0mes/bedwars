package net.stonegomes.bedwars.module.game;

import com.github.juliarn.npc.NPC;
import de.leonhard.storage.Json;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import net.stonegomes.bedwars.factory.NPCFactory;
import org.bukkit.Location;
import org.bukkit.World;

@ModuleId(id = "gameLobbyModule")
@RequiredArgsConstructor
public class GameLobbyModule extends Module {

    private final GamePlugin gamePlugin;

    @Override
    public void handleEnable() {
        final GameLobby gameLobby = gamePlugin.getLobby();

        final Json json = new Json("lobby-data", gamePlugin.getDataFolder().getPath());
        final Location spawnLocation = json.getSerializable("spawn-location", Location.class);
        if (spawnLocation == null) {
            final World defaultWorld = gamePlugin.getServer().getWorlds().stream()
                .findFirst()
                .orElse(null);
            if (defaultWorld == null) {
                gameLobby.setSpawnLocation(null);
                return;
            }

            json.setSerializable("spawn-location", defaultWorld.getSpawnLocation());
            gameLobby.setSpawnLocation(defaultWorld.getSpawnLocation());
        } else {
            gameLobby.setSpawnLocation(spawnLocation);
        }
    }

    @Override
    public void handlePostEnable() {
        final GameLobby gameLobby = gamePlugin.getLobby();

        final Json json = new Json("lobby-data", gamePlugin.getDataFolder().getPath());
        final Location npcLocation = json.getSerializable("npc-location", Location.class);
        if (npcLocation != null) {
            final String npcSkin = json.getOrSetDefault("npc-skin", "sxsk");
            final NPC npc = NPCFactory.buildNPC(npcLocation, npcSkin, gamePlugin.getNpcPool());
            gameLobby.setNpc(npc);

            final Location hologramLocation = new Location(
                npcLocation.getWorld(),
                npcLocation.getX(),
                (npcLocation.getY() - 0.4),
                npcLocation.getZ()
            );
            final Hologram hologram = NPCFactory.buildHologramNPC(hologramLocation);
            gameLobby.setNpcHologram(hologram);
        }
    }

    @Override
    public void handleDisable() {
        final GameLobby gameLobby = gamePlugin.getLobby();
        final Json json = new Json("lobby-data", gamePlugin.getDataFolder().getPath());

        if (gameLobby.hasNpc()) {
            final NPC npc = gameLobby.getNpc();
            json.getFileData().insert("npc-skin", npc.getProfile().getName());
            json.setSerializable("npc-location", npc.getLocation());
        }

        if (gameLobby.hasSpawnLocation()) {
            json.setSerializable("spawn-location", gameLobby.getSpawnLocation());
        }
    }

}
