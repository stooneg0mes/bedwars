package net.stonegomes.bedwars.runnable;

import lombok.AllArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import net.stonegomes.bedwars.core.arena.state.GameState;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;
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
        for (Player player : Bukkit.getOnlinePlayers()) {
            final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(player);
            if (gameArena == null) continue;

            final GameState gameState = gameArena.getGameState();
            if (gameState == null) continue;

            // State update

            final GameStateContext gameStateContext = gamePlugin.getGameManager().buildContext(player);
            gameState.onUpdate(gameStateContext);
            gameState.onScoreboardUpdate(gameStateContext);

            // Spectator update

            final GamePlayer gamePlayer = gameStateContext.getGamePlayer();
            if (gamePlayer.getSpectatorTime() != null) {
                long secondsLeft = TimeUnit.MILLISECONDS.toSeconds(gamePlayer.getSpectatorTime());

                final TextComponent titleComponent = Component.text("YOU DIED", NamedTextColor.DARK_RED)
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
