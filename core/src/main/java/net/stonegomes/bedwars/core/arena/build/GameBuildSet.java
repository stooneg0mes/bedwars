package net.stonegomes.bedwars.core.arena.build;

import org.bukkit.block.Block;

import java.util.HashSet;
import java.util.Set;

public class GameBuildSet {

    private final Set<Block> blockSet = new HashSet<>();


    /**
     * Adds a block to the set.
     *
     * @param block the block to add
     */
    public void addBlock(Block block) {
        blockSet.add(block);
    }

    /**
     * Removes a block from the set.
     *
     * @param block the block to remove
     */
    public void removeBlock(Block block) {
        blockSet.remove(block);
    }

    /**
     * Checks if a block is in the set.
     *
     * @param block the block to check
     * @return true if the block is in the cache, false otherwise
     */
    public boolean hasBlock(Block block) {
        return blockSet.contains(block);
    }

    /**
     * Gets all blocks from the set.
     *
     * @return all blocks
     */
    public Set<Block> getBlocks() {
        return blockSet;
    }

}
