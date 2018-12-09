package io.github.ovso.jmerge;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class Jmerge {

    public JsonObject merge(List<JsonObject> $objs) {
        final List<JsonObject> from = new ArrayList<>();
        for (JsonObject $obj : $objs) {
            from.add(new Gson().fromJson($obj.toString(), JsonObject.class));
        }
        final JsonObject merged = new JsonObject();
        for (JsonObject obj : from) {
            Iterator it = obj.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                JsonElement jsonElement = obj.get(key);
                if (!jsonElement.isJsonArray()) {
                    merged.add(key, jsonElement);
                } else {
                    if (!merged.has(key)) {
                        merged.add(key, jsonElement);
                    } else {
                        JsonArray oldArray = merged.get(key).getAsJsonArray();
                        oldArray.addAll(jsonElement.getAsJsonArray());
                    }
                }
            }
        }
        return merged;
    }

    public JsonObject merge(JsonObject... $objs) {
        return merge(Arrays.asList($objs));
    }

    public JsonArray append(List<JsonArray> $jsonArrays) {
        JsonArray jsonArray = new JsonArray();

        for (int i = 0; i < $jsonArrays.size(); i++) {
            for (int j = 0; j < $jsonArrays.get(i).size(); j++) {
                JsonElement o = $jsonArrays.get(i).get(j);
                jsonArray.add(o);
            }
        }
        return jsonArray;
    }

    public JsonArray append(JsonArray... $jsonArrays) {
        return append(Arrays.asList($jsonArrays));
    }
}
