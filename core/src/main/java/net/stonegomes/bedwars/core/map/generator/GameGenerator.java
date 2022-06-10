package net.stonegomes.bedwars.core.map.generator;

import org.bukkit.Location;
import org.bukkit.Material;

public interface GameGenerator {

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
    Material getType();

    /**
     * Get the amount of items from the game generator
     *
     * @return the amount of items
     */
    int getAmountOfItems();

    /**
     * Set the amount of items of the game generator
     *
     * @param amountOfItems the amount of items
     */
    void setAmountOfItems(int amountOfItems);

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
