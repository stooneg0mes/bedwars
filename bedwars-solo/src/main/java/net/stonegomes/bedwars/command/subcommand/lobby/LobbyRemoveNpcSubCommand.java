package net.stonegomes.bedwars.command.subcommand.lobby;

import com.github.juliarn.npc.NPC;
import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.lobby.GameLobby;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class LobbyRemoveNpcSubCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars.lobby.remove.npc",
        description = "BigCats Bedwars - Remove arena npc sub command",
        permission = "bedwars.admin",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context, String skin) {
        final Player player = context.getSender();
        final NPC lobbyNpc = gamePlugin.getLobby().getNpc();
        if (lobbyNpc == null) {
            player.sendMessage("§cThe lobby doesn't have a §fNPC§a set at the moment.");
            return;
        }

        final GameLobby gameLobby = gamePlugin.getLobby();
        gameLobby.getNpcHologram().destroy();
        gameLobby.setNpcHologram(null);

        gamePlugin.getNpcPool().removeNPC(lobbyNpc.getEntityId());
        gameLobby.setNpc(null);

        player.sendMessage("§aYou removed the lobby §fNPC§a successfully!");
    }

}
