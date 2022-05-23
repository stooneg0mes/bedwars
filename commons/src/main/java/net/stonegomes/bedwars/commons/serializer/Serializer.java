package net.stonegomes.bedwars.commons.serializer;

public interface Serializer<T> {

    String serialize(T value);

    T deserialize(String key);

}