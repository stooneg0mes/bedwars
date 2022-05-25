package net.stonegomes.bedwars.core.build;

import org.bukkit.block.Block;

public interface GameBuildCache {

    void addBlock(Block block);

    void removeBlock(Block block);

    boolean hasBlock(Block block);

}
