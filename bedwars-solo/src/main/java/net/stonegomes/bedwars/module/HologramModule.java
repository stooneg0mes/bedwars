package net.stonegomes.bedwars.module;

import com.github.eokasta.hologram.HologramRegistry;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;

@ModuleId(id = "hologramModule")
@RequiredArgsConstructor
public class HologramModule extends Module {

    private final GamePlugin gamePlugin;

    @Getter
    private HologramRegistry hologramRegistry;

    @Override
    public void handleEnable() {
        hologramRegistry = new HologramRegistry(gamePlugin);
    }

}
