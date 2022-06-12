package net.stonegomes.bedwars.command.subcommand;

import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.entity.Player;

public class CreateSubCommand {

    @Command(
        name = "bedwars.arena.create",
        description = "BigCats Bedwars - Create arena sub command",
        permission = "bedwars.admin",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context) {
        /*
        TODO
         */
    }

}
