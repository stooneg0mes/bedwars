package net.stonegomes.bedwars.core.map.island.npc;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GameNpcType {

    SHOP("Shop"),
    UPGRADE("Upgrade");

    private final String name;

}
