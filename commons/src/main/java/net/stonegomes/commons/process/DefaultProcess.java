package net.stonegomes.commons.process;

import lombok.Getter;
import net.stonegomes.commons.builder.ReplacerBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.util.*;

public abstract class DefaultProcess implements Process, Listener {

    @Getter
    private final Map<Integer, Phase> phaseMap = new HashMap<>();

    @Getter
    private final Map<UUID, Integer> playerMap = new HashMap<>();

    @Getter
    private final Map<UUID, List<Object>> replyPlayerMap = new HashMap<>();

    private final ReplacerBuilder replacerBuilder = new ReplacerBuilder("&", "§");

    protected DefaultProcess(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean startProcess(Player player) {
        if (playerMap.containsKey(player.getUniqueId())) return false;
        nextPhase(player);

        return true;
    }

    @Override
    public boolean nextPhase(Player player) {
        int position = playerMap.getOrDefault(player.getUniqueId(), 0);
        int next = position + 1;

        if (phaseMap.containsKey(next)) {
            Phase phase = phaseMap.get(next);

            player.sendMessage(replacerBuilder.apply(phase.getMessage()));
            player.sendTitle(
                replacerBuilder.apply(phase.getMessageTitle()[0]),
                replacerBuilder.apply(phase.getMessageTitle()[1]),
                20,
                20,
                20
            );

            playerMap.put(player.getUniqueId(), next);
            return true;
        }

        return false;
    }

    @Override
    public boolean previousPhase(Player player) {
        int position = playerMap.getOrDefault(player.getUniqueId(), -1);
        int previous = position - 1;

        if (phaseMap.containsKey(previous)) {
            Phase phase = phaseMap.get(previous);

            player.sendMessage(replacerBuilder.apply(phase.getMessage()));
            player.sendTitle(
                replacerBuilder.apply(phase.getMessageTitle()[0]),
                replacerBuilder.apply(phase.getMessageTitle()[1]),
                20,
                20,
                20
            );

            playerMap.put(player.getUniqueId(), previous);
            return true;
        }

        return false;
    }

    @Override
    public void createPhase(int position, Phase phase) {
        phaseMap.put(position, phase);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (playerMap.containsKey(player.getUniqueId())) {
            event.setCancelled(true);

            int position = playerMap.get(player.getUniqueId());
            Phase phase = phaseMap.get(position);

            if (event.getMessage().equalsIgnoreCase("cancel")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getCancelMessage()));

                playerMap.remove(player.getUniqueId());
                replyPlayerMap.remove(player.getUniqueId());
                return;
            }

            if (phase.getType() == PhaseType.INTERACT) return;

            if (!phase.getInput().test(message, player)) return;


            if (replyPlayerMap.containsKey(player.getUniqueId())) {
                replyPlayerMap.get(player.getUniqueId()).add(event.getMessage());
            } else {
                replyPlayerMap.put(player.getUniqueId(), new ArrayList<>(Collections.singletonList(event.getMessage())));
            }

            if (!nextPhase(player)) {
                run(player, replyPlayerMap.get(player.getUniqueId()));
                playerMap.remove(player.getUniqueId());
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!event.hasBlock()) return;
        Block block = event.getClickedBlock();

        if (playerMap.containsKey(player.getUniqueId())) {
            event.setCancelled(true);

            int position = playerMap.get(player.getUniqueId());
            Phase phase = phaseMap.get(position);
            if (phase.getType() != PhaseType.INTERACT) return;

            if (!phase.getInput().test(block, player)) return;

            if (replyPlayerMap.containsKey(player.getUniqueId())) {
                replyPlayerMap.get(player.getUniqueId()).add(block);
            } else {
                replyPlayerMap.put(player.getUniqueId(), new ArrayList<>(Collections.singletonList(block)));
            }

            if (!nextPhase(player)) {
                run(player, replyPlayerMap.get(player.getUniqueId()));
                playerMap.remove(player.getUniqueId());
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        UUID uniqueId = event.getPlayer().getUniqueId();

        replyPlayerMap.remove(uniqueId);
        playerMap.remove(uniqueId);
    }

}
