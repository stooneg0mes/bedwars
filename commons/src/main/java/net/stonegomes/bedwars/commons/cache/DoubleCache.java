package net.stonegomes.bedwars.commons.cache;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;

import java.util.*;
import java.util.function.Predicate;

public class DoubleCache<K, V> {

    @Getter
    private final Map<K, V> elements = new HashMap<>();

    public boolean containsKey(K key) {
        return elements.get(key) != null;
    }

    public boolean containsValue(V value) {
        return elements.containsValue(value);
    }

    public void putElement(K key, V value) {
        elements.put(key, value);
    }

    public V removeElement(K key) {
        if (!containsKey(key)) return null;

        return elements.remove(key);
    }

    public V get(K key) {
        return elements.get(key);
    }

    public V get(Predicate<V> predicate) {
        for (V value : elements.values()) {
            if (predicate.test(value)) return value;
        }

        return null;
    }

    public Collection<V> getValues() {
        return elements.values();
    }

    public Collection<K> getKeys() {
        return elements.keySet();
    }

    public Optional<V> find(Predicate<V> predicate) {
        return Optional.ofNullable(get(predicate));
    }

    public Map<K, V> toImmutable() {
        return ImmutableMap.copyOf(elements);
    }

    public Iterator<V> iterator() {
        return elements.values().iterator();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return elements.entrySet();
    }

}