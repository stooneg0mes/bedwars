package net.stonegomes.bedwars.core.process;

import java.util.Collection;
import java.util.UUID;

public interface ProcessCache {

    /**
     * Put a process into the cache.
     *
     * @param uuid    the player uuid
     * @param process the process
     */
    void putProcess(UUID uuid, Process process);

    /**
     * Get a process from the cache.
     *
     * @param uuid the player uuid
     * @return the process
     */
    Process getProcess(UUID uuid);

    /**
     * Check if a process is in the cache.
     *
     * @param uuid the player unique id
     * @return if the process is in the cache
     */
    boolean hasProcess(UUID uuid);

    /**
     * Remove a process from the cache.
     *
     * @param uuid the player unique id
     */
    void removeProcess(UUID uuid);

    /**
     * Get all processes from the cache.
     *
     * @return all processes
     */
    Collection<Process> getProcesses();
}
