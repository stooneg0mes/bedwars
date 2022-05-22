package net.stonegomes.commons.helper;

import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@UtilityClass
public class TablistHelper {

    public void sendTablist(Player player, String[] header, String[] footer) {
        try {
            Class<?> chatBaseComponent = ReflectionHelper.getNMSClass("IChatBaseComponent");

            Object tabHeader = ReflectionHelper.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + String.join("\n", header) + "\"}");
            Object tabFooter = ReflectionHelper.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + String.join("\n", footer) + "\"}");

            Constructor<?> titleConstructor = ReflectionHelper.getNMSClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(ReflectionHelper.getNMSClass("IChatBaseComponent"));

            Object packet = titleConstructor.newInstance(tabHeader);

            Field field = packet.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(packet, tabFooter);

            ReflectionHelper.sendPacket(player, packet);
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

}
