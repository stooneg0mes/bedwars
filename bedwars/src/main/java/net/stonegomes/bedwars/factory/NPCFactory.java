package net.stonegomes.bedwars.factory;

import com.github.eokasta.hologram.Hologram;
import com.github.eokasta.hologram.HologramBuilder;
import com.github.eokasta.hologram.HologramRegistry;
import com.github.juliarn.npc.NPC;
import com.github.juliarn.npc.NPCPool;
import com.github.juliarn.npc.profile.Profile;
import net.stonegomes.bedwars.commons.fetcher.UUIDFetcher;
import org.bukkit.Location;

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

    public static Hologram buildHologramNPC(HologramRegistry hologramRegistry) {
        return new HologramBuilder()
            .addLine("§fClick here to browse all the")
            .addLine("§favailable matches on the server!")
            .addEmptyLine()
            .addLine("§e§lBEDWARS")
            .build(hologramRegistry);
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
