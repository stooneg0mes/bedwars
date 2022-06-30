package net.stonegomes.bedwars.command.subcommand.lobby;

import com.github.eokasta.hologram.Hologram;
import com.github.eokasta.hologram.HologramBuilder;
import com.github.juliarn.npc.NPC;
import com.github.juliarn.npc.profile.Profile;
import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.fetcher.UUIDFetcher;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
public class LobbySetNpcSubCommand {

    private static final Random RANDOM = new Random();

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars.lobby.set.npc",
        description = "BigCats Bedwars - Set arena npc sub command",
        permission = "bedwars.admin",
        usage = "bedwars lobby set npc [skin]",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context, String skin) {
        final Player player = context.getSender();
        final NPC lobbyNpc = gamePlugin.getLobby().getNpc();
        if (lobbyNpc != null) {
            gamePlugin.getNpcPool().removeNPC(lobbyNpc.getEntityId());
        }

        final NPC npc = NPC.builder()
            .profile(createProfile(skin))
            .location(player.getLocation())
            .lookAtPlayer(true)
            .imitatePlayer(false)
            .build(gamePlugin.getNpcPool());

        final Location npcLocation = npc.getLocation();
        final Location hologramLocation = new Location(
            npcLocation.getWorld(),
            npcLocation.getX(),
            npcLocation.getY(),
            npcLocation.getZ()
        );

        final Hologram hologram = new HologramBuilder()
            .addLine("§fClick here to browse all the")
            .addLine("§favailable matches on the server!")
            .addEmptyLine()
            .addLine("§e§lBEDWARS")
            .build();

        gamePlugin.getLobby().setNpc(npc);

        hologram.spawn(hologramLocation);
        gamePlugin.getLobby().setNpcHologram(hologram);

        player.sendMessage("§aYou set the §fNPC§a location on the lobby successfully.");
    }

    private Profile createProfile(String skin) {
        final String skinUuid = UUIDFetcher.getFromName(skin);
        if (skinUuid == null) return null;

        Profile profile = new Profile(UUID.fromString(skinUuid));
        profile.complete();

        profile.setName("");
        profile.setUniqueId(new UUID(RANDOM.nextLong(), 0));

        return profile;
    }


}
