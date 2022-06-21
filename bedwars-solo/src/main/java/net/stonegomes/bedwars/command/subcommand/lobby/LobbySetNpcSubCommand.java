package net.stonegomes.bedwars.command.subcommand.lobby;

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
        gamePlugin.getLobby().setNpcLocation(context.getSender().getLocation());
        context.sendMessage("§aYou set the arena npc location successfully.");
    }

}
