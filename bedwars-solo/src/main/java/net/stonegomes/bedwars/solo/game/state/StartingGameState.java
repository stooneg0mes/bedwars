package net.stonegomes.bedwars.solo.game.state;

import com.google.common.collect.Sets;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameStateContext;

import java.time.Duration;
import java.util.Set;

import static net.kyori.adventure.title.Title.*;

public class StartingGameState extends GameState {

    private final Set<Integer> warningTimes = Sets.newHashSet(10, 5, 4, 3, 2, 1);

    private int timeToLeave = 30;

    @Override
    public String getName() {
        return "Starting Game";
    }

    @Override
    public GameState getNextState() {
        return new InGameState();
    }

    @Override
    public GameState getPreviousState() {
        return new WaitingPlayersGameState();
    }

    @Override
    public void handleUpdate(GameStateContext context) {
        timeToLeave--;

        if (warningTimes.contains(timeToLeave)) {
            final TextColor textColor = TextColor.color(0x3cba5d);

            final TextComponent titleComponent = Component.text("STARTING GAME", textColor)
                .decoration(TextDecoration.BOLD, true);
            final TextComponent subTitleComponent = Component.text("The game will start in ", NamedTextColor.WHITE)
                .append(Component.text(timeToLeave, textColor))
                .append(Component.text(" seconds.", NamedTextColor.WHITE));

            int fadeInOut = (timeToLeave == 10) ? 1 : 0;
            final Times times = Title.Times.of(
                Duration.ofSeconds(fadeInOut),
                Duration.ofSeconds(1),
                Duration.ofSeconds(fadeInOut)
            );

            context.getPlayer().showTitle(Title.title(
                titleComponent,
                subTitleComponent,
                times
            ));
        }

        if (timeToLeave <= 0) {
            context.advanceState();
        }
    }

    @Override
    public void handleEnter(GameStateContext context) {
        /*
        TODO
         */
    }

}
