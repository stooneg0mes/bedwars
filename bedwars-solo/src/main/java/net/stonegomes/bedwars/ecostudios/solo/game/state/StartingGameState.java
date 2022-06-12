package net.stonegomes.bedwars.ecostudios.solo.game.state;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;

import java.time.Duration;
import java.util.Set;

import static net.kyori.adventure.title.Title.Times;

public class StartingGameState extends GameState {

    private final Set<Integer> warningTimes = Set.of(10, 5, 4, 3, 2, 1);

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
    public void onEnter(GameStateContext context) {
        context.getPlayer().showTitle(buildWarningTitle());
    }

    @Override
    public void onUpdate(GameStateContext context) {
        timeToLeave--;

        if (timeToLeave <= 0) {
            context.advanceState();
        } else if (warningTimes.contains(timeToLeave)) {
            context.getPlayer().showTitle(buildWarningTitle());
        }
    }

    private Title buildWarningTitle() {
        final TextColor textColor = TextColor.color(0x3cba5d);

        final TextComponent titleComponent = Component.text("STARTING GAME", textColor)
            .decoration(TextDecoration.BOLD, true);
        final TextComponent subTitleComponent = Component.text("The game will start in ", NamedTextColor.WHITE)
            .append(Component.text(timeToLeave, textColor))
            .append(Component.text(" seconds.", NamedTextColor.WHITE));

        final Times times = Times.of(
            Duration.ofSeconds(1),
            Duration.ofSeconds(1),
            Duration.ofSeconds(1)
        );

        return Title.title(
            titleComponent,
            subTitleComponent,
            times
        );
    }

}
