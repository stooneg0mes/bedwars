package net.stonegomes.bedwars.game.arena.state;

import net.stonegomes.bedwars.core.arena.island.GameIsland;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import net.stonegomes.bedwars.core.arena.state.GameState;
import net.stonegomes.bedwars.core.arena.state.GameStateContext;

public class InGameState extends GameState {

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