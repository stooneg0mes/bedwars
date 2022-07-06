package net.stonegomes.bedwars.command.subcommand.arena;

import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.view.GameArenaPaginatedView;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class ArenaListSubCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars.arena.list",
        description = "BigCats Bedwars - List arena sub command",
        permission = "bedwars.admin",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context) {
        gamePlugin.getViewFrame().open(GameArenaPaginatedView.class, context.getSender());
    }

}
