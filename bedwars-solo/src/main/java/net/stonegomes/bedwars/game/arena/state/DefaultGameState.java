package net.stonegomes.bedwars.game.arena.state;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import net.stonegomes.bedwars.core.arena.state.GameState;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;
import org.bukkit.entity.Player;

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
    public void onQuit(GameStateContext context) {
        final Player player = context.getGamePlayer().getBukkitPlayer();
        context.getGameArena().getPlayerMap().removeGamePlayer(player.getUniqueId());

        final TextComponent textComponent = Component.text("§e" + player.getName() + "§e left the game.");
        for (GamePlayer gamePlayer : context.getGameArena().getPlayerMap().values()) {
            gamePlayer.getBukkitPlayer().sendMessage(textComponent);
        }
    }

}
