package net.stonegomes.bedwars.view;

import me.saiintbrisson.minecraft.PaginatedView;
import me.saiintbrisson.minecraft.PaginatedViewSlotContext;
import me.saiintbrisson.minecraft.ViewItem;
import net.stonegomes.bedwars.commons.builder.ItemStackBuilder;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.arena.GameArena;
import org.bukkit.Material;

public class GameArenaPaginatedView extends PaginatedView<GameArena> {

    public GameArenaPaginatedView(GameManager gameManager) {
        setLayout(
            "XXXXXXXXX",
            "XOOOOOOOX",
            "XOOOOOOOX",
            "XXXXXXXXX"
        );
        setSource(gameManager.getArenaCache().getGameArenas().stream().toList());

        setCancelOnClick(true);
        setCancelOnClone(true);
        setCancelOnDrag(true);
        setCancelOnDrop(true);
        setCancelOnMoveIn(true);
        setCancelOnMoveOut(true);
        setCancelOnPickup(true);
        setCancelOnShiftClick(true);
    }

    @Override
    protected void onItemRender(PaginatedViewSlotContext<GameArena> render, ViewItem item, GameArena value) {
        item.withItem(new ItemStackBuilder(Material.PAPER)
            .name("§e" + value.getName())
            .lore(
                "§7Players: §f" + value.getPlayerMap().size() + "/" + value.getMaxPlayers(),
                "§7Status: §f" + value.getGameState().getName(),
                "",
                value.getGameState().isFirstState() ? "§eClick to join this game!" : "§cThis game is already started!"
            )
            .build()
        ).onClick(handler -> {
           if (!value.getGameState().isFirstState()) return;

           /*
           TODO
            */
        });
    }

}
