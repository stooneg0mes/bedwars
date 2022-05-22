package net.stonegomes.commons.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplacerBuilder {

    private final Map<String, String> elements = new HashMap<>();

    public ReplacerBuilder(String key, Object value) {
        elements.put(key, value.toString());
    }

    public ReplacerBuilder replace(String key, Object value) {
        elements.put(key, value.toString());

        return this;
    }

    public String apply(String string) {
        for (Map.Entry<String, String> replaceElement : elements.entrySet()) {
            string = string.replace(replaceElement.getKey(), replaceElement.getValue());
        }

        return string;
    }

    public List<String> apply(List<String> list) {
        for (Map.Entry<String, String> replaceElement : elements.entrySet()) {
            list.replaceAll(string -> string.replace(replaceElement.getKey(), replaceElement.getValue()));
        }

        return list;
    }

    public String[] apply(String[] array) {
        List<String> list = new ArrayList<>(List.of(array));
        for (Map.Entry<String, String> replaceElement : elements.entrySet()) {
            list.replaceAll(string -> string.replace(replaceElement.getKey(), replaceElement.getValue()));
        }

        return list.toArray(new String[0]);
    }

}