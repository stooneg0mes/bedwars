package net.stonegomes.bedwars.commons.builder;

import com.google.common.collect.Lists;
import de.tr7zw.changeme.nbtapi.NBTCompound;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ItemStackBuilder {

    private ItemStack itemStack;

    private final ItemMeta itemMeta;

    public ItemStackBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder name(String name) {
        itemMeta.setDisplayName(name.replace("&", "§"));
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStackBuilder lore(List<String> lore) {
        lore.replaceAll(string -> string.replace("&", "§"));

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStackBuilder customModelData(Integer data) {
        itemMeta.setCustomModelData(data);
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStackBuilder lore(String... lore) {
        return lore(Lists.newArrayList(lore));
    }

    public ItemStackBuilder addLore(String... lore) {
        List<String> actualLore = itemMeta.getLore();
        if (actualLore == null) {
            itemMeta.setLore(Arrays.asList(lore));
        } else {
            actualLore.addAll(Arrays.asList(lore));
            itemMeta.setLore(actualLore);
        }

        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStackBuilder owner(String owner) {
        NBTItem nbtItem = new NBTItem(itemStack);
        NBTCompound skullCompound = nbtItem.addCompound("SkullOwner");
        skullCompound.setString("Name", owner);

        itemStack = nbtItem.getItem();

        return this;
    }

    public ItemStackBuilder owner(UUID owner) {
        SkullMeta skullMeta = (SkullMeta) itemMeta;
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(owner));

        itemStack.setItemMeta(skullMeta);

        return this;
    }

    public ItemStackBuilder nbtValue(String key, Object value) {
        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setObject(key, value);

        itemStack = nbtItem.getItem();

        return this;
    }

    public ItemStackBuilder flag(ItemFlag... itemFlags) {
        itemMeta.addItemFlags(itemFlags);
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStackBuilder enchantment(Enchantment enchantment, int value) {
        itemStack.addUnsafeEnchantment(enchantment, value);

        return this;
    }

    public ItemStackBuilder amount(int amount) {
        itemStack.setAmount(amount);

        return this;
    }

    public ItemStack build() {
        return itemStack;
    }

}