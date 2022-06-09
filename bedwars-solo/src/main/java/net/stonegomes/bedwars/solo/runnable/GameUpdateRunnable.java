package net.stonegomes.bedwars.solo.runnable;

import lombok.AllArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static net.kyori.adventure.title.Title.Times;

@AllArgsConstructor
public class GameUpdateRunnable extends BukkitRunnable {

    private final GamePlugin gamePlugin;

    @Override
    public void run() {
        final GameState gameState = gamePlugin.getGameManager().getGameState();
        if (gameState == null) return;

        for (Player player : Bukkit.getOnlinePlayers()) {
            // State update

            final GameStateContext gameStateContext = gamePlugin.getGameManager().buildContext(player);
            gameState.onUpdate(gameStateContext);

            // Spectators update

            final GamePlayer gamePlayer = gameStateContext.getGamePlayer();
            if (gamePlayer.getSpectatorTime() != null) {
                long secondsLeft = TimeUnit.MILLISECONDS.toSeconds(gamePlayer.getSpectatorTime());

                final TextComponent titleComponent = Component.text("SPECTATOR", NamedTextColor.DARK_RED)
                    .decoration(TextDecoration.BOLD, true);
                final TextComponent subTitleComponent = Component.text("You will respawn in ", NamedTextColor.WHITE)
                    .append(Component.text(secondsLeft, NamedTextColor.RED))
                    .append(Component.text(" seconds", NamedTextColor.WHITE));

                final Times times = Times.of(
                    Duration.ofSeconds(0),
                    Duration.ofSeconds(1),
                    Duration.ofSeconds(0)
                );

                player.showTitle(Title.title(
                    titleComponent,
                    subTitleComponent,
                    times
                ));

                if (gamePlayer.getSpectatorTime() <= System.currentTimeMillis()) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.teleport(gamePlayer.getIsland().getSpawnLocation());

                    gamePlayer.setSpectatorTime(null);
                }
            }
        }
    }

}
