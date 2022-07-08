package net.stonegomes.bedwars.storage;

import de.leonhard.storage.internal.serialize.SimplixSerializable;
import lombok.NonNull;
import org.bukkit.Location;

import java.util.Map;

public class LocationSerializable implements SimplixSerializable<Location> {

    @Override
    public Location deserialize(@NonNull Object object) throws ClassCastException {
        final Map<String, Object> data = (Map<String, Object>) object;
        return Location.deserialize(data);
    }

    @Override
    public Object serialize(@NonNull Location location) throws ClassCastException {
        return location.serialize();
    }

    @Override
    public Class<Location> getClazz() {
        return Location.class;
    }

}
