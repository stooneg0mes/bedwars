package net.stonegomes.bedwars.game.arena.state.impl;

import net.stonegomes.bedwars.core.arena.state.GameState;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;
import net.stonegomes.bedwars.core.scoreboard.fast.FastBoard;
import net.stonegomes.bedwars.game.arena.state.DefaultGameState;
import org.bukkit.entity.Player;

public class WaitingPlayersGameState extends DefaultGameState {

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
    public boolean canEnter() {
        return true;
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

    @Override
    public void onScoreboardUpdate(GameStateContext context) {
        final FastBoard fastBoard = context.getScoreboardCache().createOrGetFastBoard(context.getPlayer());
        fastBoard.updateTitle("§e§lBED WARS");
        fastBoard.updateLines(
            "",
            /*
            TODO
             */
            "§eexample.net"
        );
    }

}
