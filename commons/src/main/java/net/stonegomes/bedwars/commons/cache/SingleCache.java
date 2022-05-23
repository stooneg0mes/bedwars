package net.stonegomes.bedwars.commons.cache;

import com.google.common.collect.ImmutableSet;
import lombok.Getter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class SingleCache<T> {

    @Getter
    private final Set<T> elements = new HashSet<>();

    public boolean containsKey(T key) {
        return elements.contains(key);
    }

    public void addElement(T value) {
        elements.add(value);
    }

    public void removeElement(T value) {
        elements.remove(value);
    }

    public T find(Predicate<T> predicate) {
        for (T value : elements) {
            if (predicate.test(value)) return value;
        }

        return null;
    }

    public Set<T> toImmutable() {
        return ImmutableSet.copyOf(elements);
    }

    public Iterator<T> iterator() {
        return elements.iterator();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

}