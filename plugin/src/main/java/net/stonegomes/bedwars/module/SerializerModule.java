package net.stonegomes.bedwars.module;

import de.leonhard.storage.internal.serialize.SimplixSerializer;
import net.stonegomes.bedwars.commons.Module;
import net.stonegomes.bedwars.commons.ModuleId;
import net.stonegomes.bedwars.storage.LocationSerializable;

@ModuleId(id = "serializerModule")
public class SerializerModule extends Module {

    @Override
    public void handleEnable() {
        SimplixSerializer.registerSerializable(new LocationSerializable());
    }

}
