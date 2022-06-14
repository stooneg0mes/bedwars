package net.stonegomes.bedwars.game.process.creation;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.process.Process;
import net.stonegomes.bedwars.core.process.ProcessContext;
import net.stonegomes.bedwars.game.process.creation.phase.NameCreatePhase;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class ArenaCreationProcess extends Process {

    private final String world;

    public ArenaCreationProcess(World world) {
        this.world = world.getName();

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
