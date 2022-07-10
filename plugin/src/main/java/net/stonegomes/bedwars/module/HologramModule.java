package net.stonegomes.bedwars.module;

import eu.decentsoftware.holograms.api.DecentHologramsAPI;
import lombok.RequiredArgsConstructor;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;

@ModuleId(id = "hologramModule")
@RequiredArgsConstructor
public class HologramModule extends Module {

    private final GamePlugin gamePlugin;

    @Override
    public void handleEnable() {
        DecentHologramsAPI.onEnable();
    }
}
