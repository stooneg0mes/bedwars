package net.stonegomes.bedwars.arena;

import net.stonegomes.bedwars.core.arena.GameArena;
import net.stonegomes.bedwars.core.arena.GameArenaDao;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

public class GameArenaDaoImpl implements GameArenaDao {

    @Override
    public void replace(GameArena gameArena) {
        /*
        TODO
         */
    }

    @Override
    public void delete(UUID uuid) {
        /*
        TODO
         */
    }

    @Override
    public GameArena find(UUID uuid) {
        /*
        TODO
         */

        return null;
    }

    @Override
    public Collection<GameArena> find() {
        /*
        TODO
         */

        return Set.of();
    }

}
