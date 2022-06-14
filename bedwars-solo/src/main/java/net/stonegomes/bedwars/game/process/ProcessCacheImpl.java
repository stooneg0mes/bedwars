package net.stonegomes.bedwars.game.process;

import net.stonegomes.bedwars.core.process.Process;
import net.stonegomes.bedwars.core.process.ProcessCache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProcessCacheImpl implements ProcessCache {

    private final Map<UUID, Process> processCache = new HashMap<>();

    @Override
    public void putProcess(UUID uuid, Process process) {
        processCache.put(uuid, process);
    }

    @Override
    public Process getProcess(UUID uuid) {
        return processCache.get(uuid);
    }

    @Override
    public boolean hasProcess(UUID uuid) {
        return getProcess(uuid) != null;
    }

    @Override
    public void removeProcess(UUID uuid) {
        processCache.remove(uuid);
    }

    @Override
    public Collection<Process> getProcesses() {
        return processCache.values();
    }

}
