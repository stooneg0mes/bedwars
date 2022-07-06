package net.stonegomes.bedwars.command.subcommand.lobby;

import com.github.eokasta.hologram.Hologram;
import com.github.juliarn.npc.NPC;
import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.factory.NPCFactory;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Random;

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

        final NPC npc = NPCFactory.buildNPC(player.getLocation(), skin, gamePlugin.getNpcPool());
        gamePlugin.getLobby().setNpc(npc);

        final Location npcLocation = npc.getLocation();
        final Location hologramLocation = new Location(
            npcLocation.getWorld(),
            npcLocation.getX(),
            npcLocation.getY() - 0.4,
            npcLocation.getZ()
        );
        final Hologram hologram = NPCFactory.buildHologramNPC(gamePlugin.getHologramRegistry());
        gamePlugin.getLobby().setNpcHologram(hologram);
        hologram.spawn(hologramLocation);

        player.sendMessage("§aYou set the §fNPC§a location on the lobby successfully.");
    }

}