package net.stonegomes.bedwars.solo.command;

import lombok.AllArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class MainCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars",
        aliases = "bw",
        description = "Bedwars main command",
        permission = "bedwars.admin",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context) {
        context.sendMessage(new String[]{
            "",
            "§2§lBIG CATS - BEDWARS SOLO",
            "",
        });

        if (gamePlugin.getGameManager().isOnSetup()) {
            /*
            TODO
             */
        } else {
            /*
            TODO
             */
        }
    }

}
