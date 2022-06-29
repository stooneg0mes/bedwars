package net.stonegomes.bedwars.command.subcommand.lobby;

import com.github.juliarn.npc.NPC;
import com.github.juliarn.npc.profile.Profile;
import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class LobbySetNpcSubCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars.lobby.set.npc",
        description = "BigCats Bedwars - Set arena npc sub command",
        permission = "bedwars.admin",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context) {
        final NPC lobbyNpc = gamePlugin.getLobby().getNpc();
        if (lobbyNpc != null) {
            gamePlugin.getNpcPool().removeNPC(lobbyNpc.getEntityId());
        }

        final Player player = context.getSender();
        player.sendMessage("§aYou set the §fNPC§a location successfully.");

        final Profile npcProfile = new Profile("stonegomes_");
        npcProfile.complete();

        final NPC npc = NPC.builder()
            .profile(npcProfile)
            .location(player.getLocation())
            .lookAtPlayer(true)
            .imitatePlayer(false)
            .build(gamePlugin.getNpcPool());

        gamePlugin.getLobby().setNpc(npc);
    }

}
