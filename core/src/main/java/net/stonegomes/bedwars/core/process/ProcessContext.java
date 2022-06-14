package net.stonegomes.bedwars.core.process;

import java.util.HashMap;
import java.util.Map;

public class ProcessContext {

    private final Map<String, Object> processContext = new HashMap<>();

    /**
     * Sets a value in the process context.
     *
     * @param key the key
     * @param value the value
     */
    public void set(String key, Object value) {
        processContext.put(key, value);
    }

    /**
     * Gets a value from the process context
     *
     * @param key the key
     * @return the value
     */
    public <T> T get(String key) {
        return (T) processContext.get(key);
    }

}
