package net.stonegomes.bedwars.arena.state;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import net.stonegomes.bedwars.core.arena.state.GameState;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;
import net.stonegomes.bedwars.arena.state.impl.StartingGameState;
import net.stonegomes.bedwars.arena.state.impl.WaitingPlayersGameState;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public abstract class DefaultGameState implements GameState {

    @Override
    public GameState getNextState() {
        return null;
    }

    @Override
    public GameState getPreviousState() {
        return null;
    }

    @Override
    public boolean canEnter() {
        return false;
    }

    @Override
    public boolean isStarterState() {
        return (this instanceof WaitingPlayersGameState) || (this instanceof StartingGameState);
    }

    @Override
    public void onQuit(GameStateContext context) {
        final Player player = context.getGamePlayer().getBukkitPlayer();
        context.getGameArena().getPlayerMap().removeGamePlayer(player.getUniqueId());

        final TextComponent textComponent = Component.text("§e" + player.getName() + "§e left the game.");
        for (GamePlayer gamePlayer : context.getGameArena().getPlayerMap().values()) {
            gamePlayer.getBukkitPlayer().sendMessage(textComponent);
        }
    }

    @Override
    public void onDeath(GameStateContext context) {
        final GameArena gameArena = context.getGameArena();
        final GamePlayer gamePlayer = context.getGamePlayer();
        final Player player = gamePlayer.getBukkitPlayer();

        player.spigot().respawn();
        player.setGameMode(GameMode.SPECTATOR);

        gamePlayer.setSpectatorTime(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));

        final Player killer = player.getKiller();
        if (killer != null) {
            final GamePlayer gameKiller = gameArena.getPlayerMap().getGamePlayer(killer.getUniqueId());
            if (gameKiller == null) return;

            killer.spigot().respawn();
            killer.setGameMode(GameMode.SPECTATOR);

            gameKiller.setSpectatorTime(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));
        }

        Component deathComponent;
        if (killer == null) {
            deathComponent = Component.text(player.getName() + " fell into the void.", NamedTextColor.YELLOW);
        } else {
            deathComponent = Component.text(player.getName() + " has been killed by " + killer.getName(), NamedTextColor.YELLOW);
        }

        gameArena.broadcastMessage(deathComponent);
    }


}
