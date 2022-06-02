package net.stonegomes.bedwars.core.player;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashSet;
import java.util.Set;

public class GamePlayerInventory {

    private final Set<Material> materialSet = Set.of(
        Material.IRON_INGOT,
        Material.GOLD_INGOT,
        Material.DIAMOND,
        Material.EMERALD
    );


    public Set<ItemStack> getOreItems(PlayerInventory playerInventory) {
        Set<ItemStack> itemStacks = new HashSet<>();
        for (ItemStack itemStack : playerInventory.getContents()) {
            if (itemStack == null || !materialSet.contains(itemStack.getType())) continue;

            itemStacks.add(itemStack);
        }

        return itemStacks;
    }

}

