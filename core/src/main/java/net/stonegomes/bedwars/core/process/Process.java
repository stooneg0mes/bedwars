package net.stonegomes.bedwars.core.process;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public abstract class Process {

    private final List<ProcessPhase> processPhases = new ArrayList<>();
    private final ProcessContext processContext = new ProcessContext();

    private int currentPhase;

    /**
     * Gets the current phase of the process.
     *
     * @return the current phase
     */
    public ProcessPhase getCurrentPhase() {
        return processPhases.get(currentPhase);
    }

    /**
     * Check if the process is on the last phase.
     *
     * @return if the process is on the last phase
     */
    public boolean isOnLastPhase() {
        return currentPhase == (processPhases.size() - 1);
    }

    /**
     * Add a phase to the process.
     *
     * @param processPhase the phase
     */
    public void addPhase(ProcessPhase processPhase) {
        processPhases.add(processPhase);
    }

    /**
     * Add multiple phases to the process.
     *
     * @param processPhases the phases
     */
    public void addPhases(ProcessPhase... processPhases) {
        this.processPhases.addAll(Arrays.asList(processPhases));
    }

    /**
     * Check if the process has a phase.
     *
     * @param processPhase the phase
     * @return if the process has the phase
     */
    public boolean hasPhase(ProcessPhase processPhase) {
        return processPhases.contains(processPhase);
    }

    /**
     * Remove a phase from the process
     * @param processPhase the phase
     */
    public void removePhase(ProcessPhase processPhase) {
        processPhases.remove(processPhase);
    }

    /**
     * Start the process to a player.
     *
     * @param player the player
     */
    public void startProcess(Player player) {
        currentPhase = 0;
        startCurrentPhase(player);
    }

    /**
     * Start the previous phase of the process to a player.
     *
     * @param player the player
     */
    private void backPhase(Player player) {
        currentPhase--;
        startCurrentPhase(player);
    }

    /**
     * Start the next phase of the process to a player.
     *
     * @param player the player
     */
    public void advancePhase(Player player) {
        currentPhase++;
        startCurrentPhase(player);
    }

    /**
     * Start the current phase of the process to a player.
     *
     * @param player the player
     */
    protected void startCurrentPhase(Player player) {
        if (currentPhase < 0 || currentPhase >= processPhases.size()) return;

        final ProcessPhase processPhase = processPhases.get(currentPhase);
        if (processPhase == null) return;

        player.sendMessage(processPhase.getStartMessage());
    }

    /**
     * Finish the process to a player.
     *
     * @param player the player
     * @param context the context
     */
    public abstract void onFinish(Player player, ProcessContext context);

}
