package net.stonegomes.bedwars.core.arena.generator;

import net.stonegomes.bedwars.core.arena.island.GameIsland;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.Set;

public interface GameGenerator {

    /**
     * Get the game generator island owner
     *
     * @return the island owner
     */
    GameIsland getOwner();

    /**
     * Get the game generator location
     *
     * @return the generator location
     */
    Location getLocation();

    /**
     * Get the game generator type
     *
     * @return the generator type
     */
    Set<Material> getMaterialPool();

    /**
     * Get the amount of items from the game generator
     *
     * @return the amount of items
     */
    int getAmountPool();

    /**
     * Set the amount of items of the game generator
     *
     * @param amountOfItems the amount of items
     */
    void setAmountPool(int amountOfItems);

    /**
     * Get the time to generate items from the game generator
     *
     * @return the time to generate of the generator
     */
    long getTimeToGenerate();

    /**
     * Set the time to generate items of the game generator
     *
     * @param timeToGenerate the time to generate
     */
    void setTimeToGenerate(long timeToGenerate);

    /**
     * Get the delay to generate items from the game generator
     *
     * @return the delay
     */
    long getDelay();

    /**
     * Set the delay to generate items of the game generator
     *
     * @param delay the delay to generate items
     */
    void setDelay(long delay);

}
