package net.stonegomes.bedwars.command.subcommand.arena;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.process.Process;
import net.stonegomes.bedwars.game.process.creation.ArenaCreationProcess;
import org.bukkit.World;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class ArenaCreateSubCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars.arena.create",
        description = "BigCats Bedwars - Create arena sub command",
        permission = "bedwars.admin",
        usage = "bedwars arena create <world>",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context, World world) {
        if (world == null) {
            context.sendMessage("§cWorld not found.");
            return;
        }

        final Player player = context.getSender();
        final Process arenaCreationProcess = new ArenaCreationProcess(gamePlugin, world);
        arenaCreationProcess.startProcess(player);

        gamePlugin.getProcessCache().putProcess(player.getUniqueId(), arenaCreationProcess);
    }

}
