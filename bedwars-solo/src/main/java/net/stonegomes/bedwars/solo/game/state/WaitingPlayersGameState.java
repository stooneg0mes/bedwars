package net.stonegomes.bedwars.solo.game.state;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import net.stonegomes.bedwars.core.island.team.GameTeamColor;
import org.bukkit.entity.Player;

import java.time.Duration;

import static net.kyori.adventure.title.Title.Times;

public class WaitingPlayersGameState extends GameState {

    private final int requiredPlayers = GameTeamColor.values().length;

    @Override
    public String getName() {
        return "Waiting for Players";
    }

    @Override
    public GameState getNextState() {
        return new StartingGameState();
    }

    @Override
    public GameState getPreviousState() {
        return null;
    }

    @Override
    public void handleEnter(GameStateContext context) {
        final Player player = context.getPlayer();
        player.teleport(player.getWorld().getSpawnLocation());

        final int playersLeft = (requiredPlayers - context.getOnlinePlayers().size());

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
    public void handleUpdate(GameStateContext context) {
        if (context.getOnlinePlayers().size() >= requiredPlayers) {
            context.advanceState();
        }
    }

}
