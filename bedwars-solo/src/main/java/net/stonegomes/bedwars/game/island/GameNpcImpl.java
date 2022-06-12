package net.stonegomes.bedwars.game.island;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.stonegomes.bedwars.core.island.npc.GameNpc;
import net.stonegomes.bedwars.core.island.npc.GameNpcType;
import org.bukkit.Location;

@AllArgsConstructor
@Builder
@Getter
public class GameNpcImpl implements GameNpc {

    private final Location location;
    private final GameNpcType type;

}
