package net.stonegomes.bedwars.factory;

import com.github.juliarn.npc.NPC;
import com.github.juliarn.npc.NPCPool;
import com.github.juliarn.npc.profile.Profile;
import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import net.stonegomes.bedwars.commons.fetcher.UUIDFetcher;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class NPCFactory {

    private static final Random RANDOM = new Random();

    public static NPC buildNPC(Location location, String skin, NPCPool pool) {
        return NPC.builder()
            .profile(createProfile(skin))
            .location(location)
            .lookAtPlayer(true)
            .imitatePlayer(false)
            .build(pool);
    }

    public static Hologram buildHologramNPC(Location location) {
        return DHAPI.createHologram(
            "npc",
            location,
            List.of(
                "§fClick here to browse all the",
                "§favailable matches on the server!",
                "",
                "§e§lBEDWARS"
            )
        );
    }

    private static Profile createProfile(String skin) {
        final String skinUuid = UUIDFetcher.getFromName(skin);
        if (skinUuid == null) return null;

        Profile profile = new Profile(UUID.fromString(skinUuid));
        profile.complete();

        profile.setName("");
        profile.setUniqueId(new UUID(RANDOM.nextLong(), 0));

        return profile;
    }

}
