package net.stonegomes.bedwars.command.completer;

import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.executor.CompleterExecutor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class MainCommandCompleter implements CompleterExecutor<CommandSender> {

    private final GamePlugin gamePlugin;

    @Override
    public List<String> execute(Context<CommandSender> context) {
        final List<String> list = new ArrayList<>();
        final String[] args = context.getArgs();

        switch (args.length) {
            case 1 -> applyPrimaryArguments(list);
            case 2 -> applySecondaryArguments(list, args);
            case 3 -> applyTertiaryArguments(list, args);
        }

        return list;
    }

    private void applyPrimaryArguments(List<String> list) {
        list.addAll(List.of("lobby", "arena"));
    }

    private void applySecondaryArguments(List<String> list, String[] args) {
        switch (args[0].toLowerCase()) {
            case "lobby" -> list.addAll(List.of("remove", "set"));
            case "arena" -> list.addAll(List.of("create", "delete", "list"));
        }
    }

    private void applyTertiaryArguments(List<String> list, String[] args) {
        switch (args[0].toLowerCase()) {
            case "lobby" -> {
                if (args[1].equalsIgnoreCase("remove")) list.add("npc");
                if (args[1].equalsIgnoreCase("set")) list.addAll(List.of("npc", "spawn"));
            }
            case "arena" -> {
                if (args[1].equalsIgnoreCase("delete")) {
                    for (GameArena gameArena : gamePlugin.getArenaCache().values()) {
                        list.add(gameArena.getName());
                    }
                }
            }
        }
    }

}

