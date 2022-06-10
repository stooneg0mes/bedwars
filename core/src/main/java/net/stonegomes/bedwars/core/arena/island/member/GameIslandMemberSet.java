package net.stonegomes.bedwars.core.arena.island.member;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class GameIslandMemberSet {

    private final Set<UUID> memberSet = new HashSet<>();

    public void addMember(UUID uuid) {
        memberSet.add(uuid);
    }

    public void removeMember(UUID uuid) {
        memberSet.remove(uuid);
    }

    public boolean hasMember(UUID uuid) {
        return memberSet.contains(uuid);
    }

    public int size() {
        return memberSet.size();
    }

}
