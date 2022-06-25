package net.stonegomes.bedwars.arena.npc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.stonegomes.bedwars.core.arena.island.npc.GameNpc;
import net.stonegomes.bedwars.core.arena.island.npc.GameNpcType;
import org.bukkit.Location;

@AllArgsConstructor
@Builder
@Getter
public class GameNpcImpl implements GameNpc {

    private final Location location;
    private final GameNpcType type;

}
