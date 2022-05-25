package net.stonegomes.bedwars.solo.game.state;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameStateContext;
import org.bukkit.entity.Player;

import java.time.Duration;

import static net.kyori.adventure.title.Title.*;

public class WaitingPlayersGameState extends GameState {

    private static final int REQUIRED_PLAYERS = 6;

    @Override
    public GameState getNextState() {
        return new StartingGameState();
    }

    @Override
    public boolean isFirstState() {
        return true;
    }

    @Override
    public void onUpdate(GameStateContext context) {
        if (context.getOnlinePlayersSize() >= REQUIRED_PLAYERS) {
            context.advanceState();
        }
    }

    @Override
    public void onEnter(GameStateContext context) {
        final int playersLeft = (REQUIRED_PLAYERS - context.getOnlinePlayersSize());

        final TextColor textColor = TextColor.color(0x3cba5d);

        final TextComponent titleComponent = Component.text("WELCOME", textColor);
        final TextComponent subTitleComponent = Component.text("The game will start with more ", NamedTextColor.WHITE)
            .append(Component.text(playersLeft, textColor))
            .append(Component.text(" players.", NamedTextColor.WHITE));

        final Times times = Times.of(
            Duration.ofSeconds(1),
            Duration.ofSeconds(1),
            Duration.ofSeconds(1)
        );

        context.getPlayer().showTitle(Title.title(
            titleComponent,
            subTitleComponent,
            times
        ));
    }

}
