package net.stonegomes.bedwars.game.state;

import net.stonegomes.bedwars.core.island.GameIsland;
import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;

import java.util.Random;

public class InGameState extends GameState {

    private static final Random RANDOM = new Random();

    @Override
    public String getName() {
        return "In Game";
    }

    @Override
    public GameState getPreviousState() {
        return new StartingGameState();
    }

    @Override
    public void onEnter(GameStateContext context) {
        final GameIsland lowestIsland = context.getGameArena().getIslandMap().getLowestIsland();
        final GamePlayer gamePlayer = context.getGamePlayer();

        gamePlayer.setIsland(lowestIsland);
        gamePlayer.getBukkitPlayer().teleport(lowestIsland.getSpawnLocation());
    }

    @Override
    public void onUpdate(GameStateContext context) {
        /*
        TODO
         */
    }

}