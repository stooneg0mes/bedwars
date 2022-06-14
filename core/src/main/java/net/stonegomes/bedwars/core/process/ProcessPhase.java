package net.stonegomes.bedwars.core.process;

import org.bukkit.entity.Player;

import java.util.function.BiPredicate;

public interface ProcessPhase {

    String[] getStartMessage();

    ProcessPhaseType getType();

    BiPredicate<Object, Player> handleInput();

}
