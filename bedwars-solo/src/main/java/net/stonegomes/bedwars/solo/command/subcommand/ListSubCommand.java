package net.stonegomes.bedwars.solo.command.subcommand;

import lombok.AllArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.core.map.GameMap;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class ListSubCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars.map.list",
        description = "BigCats Bedwars - Delete sub command",
        permission = "bedwars.admin",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context) {
        context.sendMessage(new String[]{
            "§2§lBIG CATS",
            "§7(Bedwars Solo)",
            "",
            "§2§lMAPS",
        });

        for (GameMap gameMap : gamePlugin.getMapCache().getGameMaps()) {
            context.sendMessage("§7" + gameMap.getName() + " §8(" + gameMap.getWorld().getName() + ")");
        }

        context.sendMessage("");
    }

}
