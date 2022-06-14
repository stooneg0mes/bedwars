package net.stonegomes.bedwars.command.subcommand;

import lombok.AllArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class ArenaListSubCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars.arena.list",
        description = "BigCats Bedwars - List arena sub command",
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

        for (GameArena gameArena : gamePlugin.getArenaCache().getGameArenas()) {
            context.sendMessage("§7" + gameArena.getName() + " §8(" + gameArena.getWorld().getName() + ")");
        }

        context.sendMessage("");
    }

}
