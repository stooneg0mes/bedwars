package net.stonegomes.commons.serializer;

public interface Serializer<T> {

    String serialize(T value);

    T deserialize(String key);

}