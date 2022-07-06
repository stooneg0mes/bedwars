package net.stonegomes.bedwars.module;

import lombok.RequiredArgsConstructor;
import me.saiintbrisson.bukkit.command.BukkitFrame;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.command.MainCommand;
import net.stonegomes.bedwars.command.subcommand.arena.ArenaCreateSubCommand;
import net.stonegomes.bedwars.command.subcommand.arena.ArenaDeleteSubCommand;
import net.stonegomes.bedwars.command.subcommand.arena.ArenaListSubCommand;
import net.stonegomes.bedwars.command.subcommand.lobby.LobbyRemoveNpcSubCommand;
import net.stonegomes.bedwars.command.subcommand.lobby.LobbySetNpcSubCommand;
import net.stonegomes.bedwars.command.subcommand.lobby.LobbySetSpawnSubCommand;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;

@ModuleId(id = "commandModule")
@RequiredArgsConstructor
public class CommandModule extends Module {

    private final GamePlugin gamePlugin;

    @Override
    public void handleEnable() {
        BukkitFrame bukkitFrame = new BukkitFrame(gamePlugin);
        bukkitFrame.registerCommands(
            new MainCommand(gamePlugin),
            new ArenaCreateSubCommand(gamePlugin),
            new ArenaDeleteSubCommand(gamePlugin),
            new ArenaListSubCommand(gamePlugin),
            new LobbySetNpcSubCommand(gamePlugin),
            new LobbySetSpawnSubCommand(gamePlugin),
            new LobbyRemoveNpcSubCommand(gamePlugin)
        );
    }

}
