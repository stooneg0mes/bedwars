package net.stonegomes.bedwars.commons.fetcher;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.UUID;

public class UUIDFetcher {

    public static String getFromName(String name) {
        try {
            final InputStream inputStream = new URL("https://api.mojang.com/users/profiles/minecraft/" + name).openStream();
            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            final String uuidString = (((JsonObject) JsonParser.parseReader(bufferedReader)).get("id")).toString().replace("\"", "");
            bufferedReader.close();

            return uuidString.substring(0, 8)
                + "-"
                + uuidString.substring(8, 12)
                + "-"
                + uuidString.substring(12, 16)
                + "-"
                + uuidString.substring(16, 20)
                + "-"
                + uuidString.substring(20, 32);
        } catch (Exception ignored) {
            return null;
        }
    }

}
