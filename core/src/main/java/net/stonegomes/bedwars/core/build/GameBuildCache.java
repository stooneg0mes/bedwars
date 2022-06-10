package net.stonegomes.bedwars.core.build;

import org.bukkit.block.Block;

public interface GameBuildCache {

    /**
     * Adds a block to the cache.
     *
     * @param block the block to add
     */
    void addBlock(Block block);

    /**
     * Removes a block from the cache.
     *
     * @param block the block to remove
     */
    void removeBlock(Block block);

    /**
     * Checks if a block is in the cache.
     *
     * @param block the block to check
     * @return true if the block is in the cache, false otherwise
     */
    boolean hasBlock(Block block);

}
