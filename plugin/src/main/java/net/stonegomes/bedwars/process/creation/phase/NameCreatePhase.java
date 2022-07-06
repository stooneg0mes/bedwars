package net.stonegomes.bedwars.process.creation.phase;

import net.stonegomes.bedwars.core.process.ProcessContext;
import net.stonegomes.bedwars.core.process.ProcessPhase;
import net.stonegomes.bedwars.core.process.ProcessPhaseType;
import org.bukkit.entity.Player;

import java.util.function.BiPredicate;

public class NameCreatePhase implements ProcessPhase {

    @Override
    public String[] getStartMessage() {
        return new String[]{
            "",
            "§aEnter the name of the arena.",
            "§7(Use 'cancel' to cancel the process)",
            ""
        };
    }

    @Override
    public ProcessPhaseType getType() {
        return ProcessPhaseType.CHAT;
    }

    @Override
    public BiPredicate<Object, Player> handleInput(ProcessContext context) {
        return (messageObject, player) -> {
            context.set("arenaName", messageObject.toString());
            return true;
        };
    }

}
