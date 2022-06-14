package net.stonegomes.bedwars.command;

import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.entity.Player;

public class MainCommand {

    @Command(
        name = "bedwars",
        description = "BigCats Bedwars - Main command",
        permission = "bedwars.admin",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context) {
        context.sendMessage(new String[]{
            "",
            "§2§lBIG CATS",
            "§7(Bedwars Solo)",
            "",
            "§7/bedwars arena create <world> §8- §7Start a new map creation process.",
            "§7/bedwars arena delete <name> §8- §7Delete a map.",
            "§7/bedwars arena list §8- §7List all maps.",
        });
    }

}
