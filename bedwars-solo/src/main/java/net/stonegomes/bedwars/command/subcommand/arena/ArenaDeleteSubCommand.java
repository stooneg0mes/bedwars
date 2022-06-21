package net.stonegomes.bedwars.command.subcommand.arena;

import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class ArenaDeleteSubCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars.arena.delete",
        description = "BigCats Bedwars - Delete arena sub command",
        permission = "bedwars.admin",
        usage = "bedwars arena delete <name>",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context, GameArena gameArena) {
        if (gameArena == null) {
            context.sendMessage("§cArena not found.");
            return;
        }

        gamePlugin.getArenaDao().delete(gameArena.getUniqueId());
        gamePlugin.getArenaCache().removeGameArena(gameArena.getUniqueId());

        context.sendMessage("§2§lBIG CATS §7You have deleted the arena §a" + gameArena.getName() + "§7 successfully.");
    }

}
