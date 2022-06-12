package net.stonegomes.bedwars.ecostudios.solo.game.state;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import org.bukkit.entity.Player;

import java.time.Duration;

import static net.kyori.adventure.title.Title.Times;

public class WaitingPlayersGameState extends GameState {

    private static final int REQUIRED_PLAYERS = 6;

    @Override
    public String getName() {
        return "Waiting for Players";
    }

    @Override
    public GameState getNextState() {
        return new StartingGameState();
    }

    @Override
    public void onEnter(GameStateContext context) {
        final Player player = context.getPlayer();
        player.teleport(player.getWorld().getSpawnLocation());

        final int playersLeft = (REQUIRED_PLAYERS - context.getOnlinePlayers().size());

        final TextColor textColor = TextColor.color(0x3cba5d);

        final TextComponent titleComponent = Component.text("WAITING FOR PLAYERS", textColor)
            .decoration(TextDecoration.BOLD, true);
        final TextComponent subTitleComponent = Component.text("The game will start with more ", NamedTextColor.WHITE)
            .append(Component.text(playersLeft, textColor))
            .append(Component.text(" players.", NamedTextColor.WHITE));

        final Times times = Times.of(
            Duration.ofSeconds(1),
            Duration.ofSeconds(1),
            Duration.ofSeconds(1)
        );

        player.showTitle(Title.title(
            titleComponent,
            subTitleComponent,
            times
        ));
    }

    @Override
    public void onUpdate(GameStateContext context) {
        if (context.getOnlinePlayers().size() >= REQUIRED_PLAYERS) {
            context.advanceState();
        }
    }

}
