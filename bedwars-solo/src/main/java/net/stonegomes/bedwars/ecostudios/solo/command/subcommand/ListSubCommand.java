package net.stonegomes.bedwars.ecostudios.solo.command.subcommand;

import lombok.AllArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.ecostudios.solo.GamePlugin;
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

        for (GameArena gameArena : gamePlugin.getMapCache().getGameMaps()) {
            context.sendMessage("§7" + gameArena.getName() + " §8(" + gameArena.getWorld().getName() + ")");
        }

        context.sendMessage("");
    }

}
