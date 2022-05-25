package net.stonegomes.bedwars.solo.game;

import lombok.*;
import net.stonegomes.bedwars.core.game.GameManager;
import net.stonegomes.bedwars.core.game.GameState;

@Data
@RequiredArgsConstructor
public class GameManagerImpl implements GameManager {

    private GameState gameState;

}
