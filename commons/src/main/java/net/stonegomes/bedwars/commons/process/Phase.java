package net.stonegomes.bedwars.commons.process;

import org.bukkit.entity.Player;

import java.util.function.BiPredicate;

public interface Phase {

    PhaseType getType();

    String[] getMessage();

    String[] getMessageTitle();

    BiPredicate<Object, Player> getInput();

}