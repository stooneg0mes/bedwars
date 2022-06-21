package net.stonegomes.bedwars.command;

import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class MainCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars",
        description = "BigCats Bedwars - Main command",
        permission = "bedwars.admin",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context) {
        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(context.getSender().getWorld());
        if (gameArena == null) {
            context.sendMessage(new String[]{
                "",
                "§2§lBIG CATS - BED WARS",
                "§7(Lobby)",
                "",
                "§7/bedwars arena create <world> §8- §7Start a new map creation process.",
                "§7/bedwars arena delete <name> §8- §7Delete a map.",
                "§7/bedwars arena list §8- §7List all maps.",
                "",
                "§7/bedwars lobby set spawn §8- §7Set the lobby spawn.",
                "§7/bedwars lobby set npc §8- §7Set the arena npc.",
                ""
            });
        } else {
            context.sendMessage(new String[]{
                "",
                "§2§lBIG CATS",
                "§7(" + gameArena.getName() + ")",
                "",
                "§7/bedwars arena edit §8- §7Open the arena edit menu.",
                "§7/bedwars island edit <color> §8- §7Open the island edit menu.",
                ""
            });
        }
    }

}
