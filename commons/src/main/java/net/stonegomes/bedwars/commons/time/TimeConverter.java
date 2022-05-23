package net.stonegomes.bedwars.commons.time;

import net.stonegomes.bedwars.commons.time.multiplier.TimeMultiplier;

public class TimeConverter {

    public static Long convertToMillis(String string) {
        long time = 0;

        for (String split : string.split(" ")) {
            char charAt = split.charAt(split.length() - 1);

            int timeInt;
            try {
                timeInt = Integer.parseInt(split.replace(Character.toString(charAt), ""));
            } catch (NumberFormatException exception) {
                return (long) -1;
            }

            for (TimeMultiplier timeMultiplier : TimeMultiplier.values()) {
                if (timeMultiplier.getDiminutive() != charAt) continue;

                time += timeMultiplier.getMultiplier() * timeInt;
            }
        }

        return time;
    }

}