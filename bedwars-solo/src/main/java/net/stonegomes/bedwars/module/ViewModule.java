package net.stonegomes.bedwars.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.ViewFrame;
import net.stonegomes.bedwars.GamePlugin;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.view.GameArenaPaginatedView;

@ModuleId(id = "viewModule")
@RequiredArgsConstructor
public class ViewModule extends Module {

    private final GamePlugin gamePlugin;

    @Getter
    private ViewFrame viewFrame;

    @Override
    public void handleLoad() {
        viewFrame = new ViewFrame(gamePlugin);
    }

    public void handleEnable() {
        viewFrame.register(
            new GameArenaPaginatedView(gamePlugin.getGameManager())
        );
    }

}
