package net.stonegomes.bedwars.game.process.creation;

import net.stonegomes.bedwars.core.process.Process;
import net.stonegomes.bedwars.core.process.ProcessContext;
import net.stonegomes.bedwars.game.process.creation.phase.NameCreatePhase;
import org.bukkit.entity.Player;

public class ArenaCreationProcess extends Process {

    public ArenaCreationProcess() {
        addPhases(
            new NameCreatePhase()
        );
    }

    @Override
    public void onFinish(Player player, ProcessContext context) {
        /*
        TODO
         */
    }

}
