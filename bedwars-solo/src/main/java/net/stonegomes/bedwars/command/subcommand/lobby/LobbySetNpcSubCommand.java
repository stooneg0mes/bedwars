package net.stonegomes.bedwars.command.subcommand.lobby;

import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.builder.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@RequiredArgsConstructor
public class LobbySetNpcSubCommand {

    private final GamePlugin gamePlugin;

    @Command(
        name = "bedwars.lobby.set.npc",
        description = "BigCats Bedwars - Set arena npc sub command",
        permission = "bedwars.admin",
        target = CommandTarget.PLAYER
    )
    public void handleCommand(Context<Player> context) {
        final Player player = context.getSender();
        player.sendMessage("§aYou set the arena npc location successfully.");

        gamePlugin.getLobby().setNpcLocation(player.getLocation());

        final ItemStack itemStack = new ItemStackBuilder(Material.ENDER_EYE)
            .enchantment(Enchantment.DIG_SPEED, 1)
            .build();

        Giant giant = player.getWorld().spawn(player.getLocation(), Giant.class);
        giant.getEquipment().setItemInMainHand(itemStack);
        giant.getEquipment().setItemInMainHandDropChance(0.0f);

        giant.setCustomNameVisible(false);
        giant.setCanPickupItems(false);
        giant.setRemoveWhenFarAway(false);

        giant.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 999));
    }

}
