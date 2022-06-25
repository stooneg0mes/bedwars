package net.stonegomes.bedwars.listener.food;

import lombok.AllArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.core.arena.GameArena;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

@AllArgsConstructor
public class FoodLevelChangeListener implements Listener {

    private final GamePlugin gamePlugin;

    @EventHandler
    public void handleFoodLevelChange(FoodLevelChangeEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;

        final GameArena gameArena = gamePlugin.getArenaCache().getGameArena(player);
        if (gameArena == null) return;

        event.setCancelled(gameArena.getGameState().isStarterState());
    }

}
