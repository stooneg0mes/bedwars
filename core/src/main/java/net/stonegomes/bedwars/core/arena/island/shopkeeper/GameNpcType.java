package net.stonegomes.bedwars.core.arena.island.shopkeeper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GameNpcType {

    SHOP("Shop"),
    UPGRADE("Upgrade");

    private final String name;

}
