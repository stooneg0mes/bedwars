package net.stonegomes.bedwars.module;

import com.github.juliarn.npc.NPCPool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;

@ModuleId(id = "npcModule")
@RequiredArgsConstructor
public class NpcModule extends Module {

    private final GamePlugin gamePlugin;

    @Getter
    private NPCPool npcPool;

    @Override
    public void handleEnable() {
        npcPool = NPCPool.builder(gamePlugin)
            .spawnDistance(60)
            .actionDistance(30)
            .tabListRemoveTicks(20)
            .build();
    }

    @Override
    public void handleDisable() {
        // npcPool.getNPCs().forEach(npc -> npcPool.removeNPC(npc.getEntityId()));
    }

}
