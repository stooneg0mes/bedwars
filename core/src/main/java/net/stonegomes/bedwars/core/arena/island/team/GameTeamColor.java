package net.stonegomes.bedwars.core.arena.island.team;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GameTeamColor {

    BLUE("§9[Blue]"),
    RED("§c[Red]"),
    YELLOW("§e[Yellow]"),
    ORANGE("§6[Orange]"),
    PURPLE("§5[Purple]"),
    GREEN("§a[Green]");

    private final String prefix;

}
