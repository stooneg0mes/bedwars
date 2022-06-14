package net.stonegomes.bedwars.core.process;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public abstract class Process {

    private final List<ProcessPhase> processPhases = new ArrayList<>();
    private final Map<String, Object> processContext = new HashMap<>();

    private int currentPhase;

    public ProcessPhase getCurrentPhase() {
        return processPhases.get(currentPhase);
    }

    public boolean isOnLastPhase() {
        return currentPhase == (processPhases.size() - 1);
    }

    public void startProcess(Player player) {
        currentPhase = 0;
        startCurrentPhase(player);
    }

    private void backPhase(Player player) {
        currentPhase--;
        startCurrentPhase(player);
    }

    public void advancePhase(Player player) {
        currentPhase++;
        startCurrentPhase(player);
    }

    private void startCurrentPhase(Player player) {
        if (currentPhase < 0 || currentPhase >= processPhases.size()) return;

        final ProcessPhase processPhase = processPhases.get(currentPhase);
        if (processPhase == null) return;

        player.sendMessage(processPhase.getStartMessage());
    }

    public abstract void onFinish(Player player, Map<String, Object> context);

}
