package net.stonegomes.bedwars.game.process.creation.phase;

import net.stonegomes.bedwars.core.process.ProcessContext;
import net.stonegomes.bedwars.core.process.ProcessPhase;
import net.stonegomes.bedwars.core.process.ProcessPhaseType;
import org.bukkit.entity.Player;

import java.util.function.BiPredicate;

public class WaitingSecondPositionCreatePhase implements ProcessPhase {

    @Override
    public String[] getStartMessage() {
        return new String[]{
            "",
            "§aGo to the §fwaiting second position§a and enter §f'done'§a on chat.",
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
            String message = messageObject.toString();
            if (!message.equalsIgnoreCase("done")) return false;

            context.set("waitingSecondPosition", player.getLocation());
            return true;
        };
    }

}
