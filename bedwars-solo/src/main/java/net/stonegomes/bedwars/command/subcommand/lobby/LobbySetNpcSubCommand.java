package net.stonegomes.bedwars.command.subcommand.lobby;

import com.github.juliarn.npc.NPC;
import com.github.juliarn.npc.profile.Profile;
import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.fetcher.UUIDFetcher;
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
        usage = "bedwars lobby set npc <skin>",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context, String skin) {
        final NPC lobbyNpc = gamePlugin.getLobby().getNpc();
        if (lobbyNpc != null) {
            gamePlugin.getNpcPool().removeNPC(lobbyNpc.getEntityId());
        }

        final Player player = context.getSender();
        player.sendMessage("§aYou set the §fNPC§a location successfully.");

        final String profileUuid = UUIDFetcher.getFromName(skin);
        if (profileUuid == null) return;

        final Profile profile = new Profile(UUID.fromString(profileUuid));
        profile.complete();
        profile.setName("");

        final NPC npc = NPC.builder()
            .profile(profile)
            .location(player.getLocation())
            .lookAtPlayer(true)
            .imitatePlayer(false)
            .build(gamePlugin.getNpcPool());

        gamePlugin.getLobby().setNpc(npc);
    }

}
