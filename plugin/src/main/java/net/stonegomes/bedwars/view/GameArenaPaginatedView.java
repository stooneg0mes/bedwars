package net.stonegomes.bedwars.view;

import me.saiintbrisson.minecraft.PaginatedView;
import me.saiintbrisson.minecraft.PaginatedViewSlotContext;
import me.saiintbrisson.minecraft.ViewContext;
import me.saiintbrisson.minecraft.ViewItem;
import net.stonegomes.bedwars.arena.player.GamePlayerImpl;
import net.stonegomes.bedwars.commons.builder.ItemStackBuilder;
import net.stonegomes.bedwars.core.GameManager;
import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.player.GamePlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GameArenaPaginatedView extends PaginatedView<GameArena> {

    private static final Integer[] DECORATION_SLOTS = new Integer[] {
        0, 1, 2, 3, 4, 5, 6, 7, 8,
        9, 17,
        18, 26,
        27, 35,
        36, 37, 38, 39, 40, 41, 42, 43, 44
    };

    private final GameManager gameManager;

    public GameArenaPaginatedView(GameManager gameManager) {
        super(5, "Available Games");

        this.gameManager = gameManager;

        setSource(gameManager.getArenaCache().values().stream().toList());
        setLayout(
            "XXXXXXXXX",
            "XOOOOOOOX",
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
    protected void onRender(@NotNull ViewContext context) {
        for (int decorationSlot : DECORATION_SLOTS) {
            context.slot(decorationSlot).withItem(new ItemStackBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .name("§8Decoration")
                .build()
            );
        }

        if (gameManager.getArenaCache().values().isEmpty()) {
            context.slot(22).withItem(new ItemStackBuilder(Material.COBWEB)
                .name("§cNo games available")
                .lore(
                    "§7Seems that there's no games available",
                    "§7at the moment."
                )
                .build()
            );
        }
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
