package net.stonegomes.bedwars.ecostudios.solo.game.build;

import net.stonegomes.bedwars.core.arena.build.GameBuildSet;
import org.bukkit.block.Block;

import java.util.HashSet;
import java.util.Set;

public class GameBuildSetImpl implements GameBuildSet {

    private final Set<Block> blockCache = new HashSet<>();

    @Override
    public void addBlock(Block block) {
        blockCache.add(block);
    }

    @Override
    public void removeBlock(Block block) {
        blockCache.remove(block);
    }

    @Override
    public boolean hasBlock(Block block) {
        return blockCache.contains(block);
    }

}
