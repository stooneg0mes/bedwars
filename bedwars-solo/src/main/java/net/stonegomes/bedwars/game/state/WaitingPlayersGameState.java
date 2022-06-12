package net.stonegomes.bedwars.game.state;

import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import org.bukkit.entity.Player;


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

    }

    @Override
    public void onUpdate(GameStateContext context) {
        if (context.getOnlinePlayers().size() >= REQUIRED_PLAYERS) {
            context.advanceState();
        }
    }

}
