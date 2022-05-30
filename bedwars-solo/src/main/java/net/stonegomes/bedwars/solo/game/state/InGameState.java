package net.stonegomes.bedwars.solo.game.state;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.core.game.GameState;
import net.stonegomes.bedwars.core.game.GameStateContext;
import net.stonegomes.bedwars.core.generator.GameGenerator;
import net.stonegomes.bedwars.solo.GamePlugin;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class InGameState implements GameState {

    private static final Random RANDOM = new Random();

    private final GamePlugin gamePlugin = GamePlugin.getInstance();

    @Override
    public String getName() {
        return "In Game";
    }

    @Override
    public GameState getNextState() {
        return null;
    }

    @Override
    public void onUpdate(GameStateContext context) {
        for (GameGenerator gameGenerator : gamePlugin.getGeneratorCache().getGameGenerators()) {
            if (gameGenerator.getTimeToGenerate() > System.currentTimeMillis()) continue;

            final int randomAmount = RANDOM.nextInt(gameGenerator.getAmountOfItems());
            final ItemStack itemStack = new ItemStack(gameGenerator.getType(), randomAmount);
            final Location location = gameGenerator.getLocation();
            location.getWorld().dropItemNaturally(location, itemStack);

            final long timeToGenerate = System.currentTimeMillis() + gameGenerator.getDelay();
            gameGenerator.setTimeToGenerate(timeToGenerate);
        }

        /*
        TODO Victory logic
         */
    }

}