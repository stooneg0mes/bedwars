package net.stonegomes.bedwars.solo.command.subcommand;

import lombok.AllArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.core.map.GameMap;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class DeleteSubCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars.map.delete",
        description = "BigCats Bedwars - Delete sub command",
        permission = "bedwars.admin",
        usage = "bedwars delete <map>",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context, GameMap gameMap) {
        if (gameMap == null) {
            context.sendMessage("§cMap not found.");
            return;
        }

        gamePlugin.getMapDao().delete(gameMap.getUniqueId());
        gamePlugin.getMapCache().removeGameMap(gameMap.getUniqueId());

        context.sendMessage("§2§lBIG CATS §7You have deleted the map §a" + gameMap.getName() + "§7 successfully.");
    }

}
