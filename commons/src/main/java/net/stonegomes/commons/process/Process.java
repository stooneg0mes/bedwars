package net.stonegomes.commons.process;

import org.bukkit.entity.Player;

import java.util.List;

public interface Process {

    boolean startProcess(Player player);

    boolean nextPhase(Player player);

    boolean previousPhase(Player player);

    void createPhase(int position, Phase phase);

    void run(Player player, List<Object> values);

    String getCancelMessage();

}
