package net.stonegomes.bedwars.view;

import me.saiintbrisson.minecraft.PaginatedView;
import me.saiintbrisson.minecraft.PaginatedViewSlotContext;
import me.saiintbrisson.minecraft.ViewItem;
import net.stonegomes.bedwars.arena.player.GamePlayerImpl;
import net.stonegomes.bedwars.commons.builder.ItemStackBuilder;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GameArenaPaginatedView extends PaginatedView<GameArena> {

    private final GameManager gameManager;

    public GameArenaPaginatedView(GameManager gameManager) {
        this.gameManager = gameManager;

        setSource(gameManager.getArenaCache().values().stream().toList());
        setLayout(
            "XXXXXXXXX",
            "XOOOOOOOX",
            "XOOOOOOOX",
            "XXXXXXXXX"
        );

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
        final Player player = render.getPlayer();

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

            GamePlayer gamePlayer = GamePlayerImpl.builder()
                .uniqueId(player.getUniqueId())
                .arena(value)
                .island(null)
                .spectatorTime(null)
                .build();

            value.getPlayerMap().putGamePlayer(gamePlayer.getUniqueId(), gamePlayer);
            value.getGameState().onEnter(gameManager.buildContext(player, value));

            player.teleport(value.getWaitingSpawnLocation());
        });
    }

}
