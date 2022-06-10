package net.stonegomes.bedwars.solo.game.state;

import net.stonegomes.bedwars.core.arena.generator.GameGenerator;
import net.stonegomes.bedwars.core.arena.island.GameIsland;
import net.stonegomes.bedwars.core.player.GamePlayer;
import net.stonegomes.bedwars.core.state.GameState;
import net.stonegomes.bedwars.core.state.GameStateContext;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

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
        for (GameGenerator gameGenerator : context.getGameArena().getGeneratorMap().getGenerators()) {
            if (gameGenerator.getTimeToGenerate() > System.currentTimeMillis()) continue;

            final int randomAmount = RANDOM.nextInt(gameGenerator.getAmountOfItems());
            final ItemStack itemStack = new ItemStack(gameGenerator.getType(), randomAmount);
            final Location location = gameGenerator.getLocation();
            location.getWorld().dropItemNaturally(location, itemStack);

            final long timeToGenerate = System.currentTimeMillis() + gameGenerator.getDelay();
            gameGenerator.setTimeToGenerate(timeToGenerate);
        }
    }

}