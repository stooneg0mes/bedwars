package net.stonegomes.bedwars.commons.time;

import java.util.concurrent.TimeUnit;

public class TimeFormatter {

    public static String formatTime(long time, boolean compareDifference) {
        return formatTimeToString(false, time, compareDifference);
    }

    public static String formatTime(long time) {
        return formatTime(time, false);
    }

    public static String formatTimeMinimalist(long time, boolean compareDifference) {
        return formatTimeToString(true, time, compareDifference);
    }

    public static String formatTimeMinimalist(long time) {
        return formatTimeMinimalist(time, false);
    }

    private static String formatTimeToString(boolean minimalist, long time, boolean compareDifference) {
        long currentTime = (compareDifference ? time - System.currentTimeMillis() : time);

        long day = TimeUnit.MILLISECONDS.toDays(currentTime);
        long hours = TimeUnit.MILLISECONDS.toHours(currentTime) - day * 24L;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(currentTime) - TimeUnit.MILLISECONDS.toHours(currentTime) * 60L;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(currentTime) - TimeUnit.MILLISECONDS.toMinutes(currentTime) * 60L;

        StringBuilder stringBuilder = new StringBuilder();
        if (minimalist) {
            if (currentTime <= 0) return "0s";

            if (day > 0L) stringBuilder.append(day).append("d");
            if (hours > 0L) stringBuilder.append(hours).append("h");
            if (minutes > 0L) stringBuilder.append(minutes).append("m");
            if (seconds > 0L) stringBuilder.append(seconds).append("s");
        } else {
            if (currentTime <= 0) return "0 seconds";

            stringBuilder.append(day)
                .append(":")
                .append(hours)
                .append(":")
                .append(minutes)
                .append(":")
                .append(seconds);
        }

        return stringBuilder.toString();
    }

}