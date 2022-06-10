package net.stonegomes.bedwars.core.arena.island.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.kyori.adventure.text.format.NamedTextColor;

@AllArgsConstructor
@Getter
public enum GameTeamColor {

    BLUE(
        "Blue",
        NamedTextColor.BLUE
    ),
    RED(
        "Red",
        NamedTextColor.RED
    ),
    YELLOW(
        "Yellow",
        NamedTextColor.YELLOW
    ),
    ORANGE(
        "Orange",
        NamedTextColor.GOLD
    ),
    PURPLE(
        "Purple",
        NamedTextColor.LIGHT_PURPLE
    ),
    GREEN(
        "Green",
        NamedTextColor.GREEN
    );

    private final String name;
    private final NamedTextColor color;

}
