package net.stonegomes.bedwars.core.island.member;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class GameIslandMemberSet {

    private final Set<UUID> memberSet = new HashSet<>();

    /**
     * Add a member to the set
     *
     * @param uuid the member uuid
     */
    public void addMember(UUID uuid) {
        memberSet.add(uuid);
    }

    /**
     * Remove a member from the set
     *
     * @param uuid the member uuid
     */
    public void removeMember(UUID uuid) {
        memberSet.remove(uuid);
    }

    /**
     * Check if the set has a member
     *
     * @param uuid the member uuid
     * @return if the set has this member
     */
    public boolean hasMember(UUID uuid) {
        return memberSet.contains(uuid);
    }

    /**
     * Get the set size
     *
     * @return the set size
     */
    public int size() {
        return memberSet.size();
    }

}
