package net.stonegomes.game.game;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import net.stonegomes.core.game.GameState;
import net.stonegomes.core.game.GameStateContext;
import net.stonegomes.core.game.GameStateType;
import org.bukkit.entity.Player;

import java.time.Duration;

import static net.kyori.adventure.title.Title.*;

public class WaitingPlayersStateImpl implements GameState {

    private static final int REQUIRED_PLAYERS = 8;

    @Override
    public GameState getNextState() {
        return null;
    }

    @Override
    public GameStateType getStateType() {
        return GameStateType.JOIN_SERVER;
    }

    @Override
    public void onUpdate(GameStateContext context) {
        if (context.getOnlinePlayersSize() < REQUIRED_PLAYERS) return;

        context.advanceState();
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

        final Player player = context.getPlayer();
        final TextComponent messageComponent = Component.text(player.getName(), NamedTextColor.WHITE)
            .append(Component.text(" has joined the game.", NamedTextColor.GRAY));

        context.getOnlinePlayers().forEach(onlinePlayer -> onlinePlayer.sendMessage(messageComponent));
    }

    @Override
    public void onExit(GameStateContext context) {
        final Player player = context.getPlayer();
        final TextComponent messageComponent = Component.text(player.getName() + " has left the game. ", NamedTextColor.GRAY)
            .append(Component.text("(" + context.getOnlinePlayersSize() + "/" + REQUIRED_PLAYERS + ")", NamedTextColor.WHITE));

        context.getOnlinePlayers().forEach(onlinePlayer -> onlinePlayer.sendMessage(messageComponent));
    }

}
