package agh.cs.POprojekt;

import agh.cs.POprojekt.dataTypes.Judgment;
import agh.cs.POprojekt.deserializers.DateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.List;

public class Loader {
    public List<Judgment> load(String path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        Gson gson = gsonBuilder.create();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            JsonObject jsonObject = gson.fromJson(reader, JsonElement.class).getAsJsonObject();
            List<Judgment> judgments = gson.fromJson(jsonObject.get("items"), new TypeToken<List<Judgment>>(){}.getType());
            return judgments;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
