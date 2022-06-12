package net.stonegomes.bedwars.ecostudios.solo.command.subcommand;

import lombok.AllArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.ecostudios.solo.GamePlugin;
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
    public void handleCommand(Context<Player> context, GameArena gameArena) {
        if (gameArena == null) {
            context.sendMessage("§cMap not found.");
            return;
        }

        gamePlugin.getMapDao().delete(gameArena.getUniqueId());
        gamePlugin.getMapCache().removeGameMap(gameArena.getUniqueId());

        context.sendMessage("§2§lBIG CATS §7You have deleted the map §a" + gameArena.getName() + "§7 successfully.");
    }

}
