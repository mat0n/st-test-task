package com.st.urban.helpers;

import com.codeborne.selenide.conditions.CssValue;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.*;

public class CssAttributeDeserializer implements JsonDeserializer<Map<String, CssValue[]>> {

    @Override
    public Map<String, CssValue[]> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Map<String, CssValue[]> result = new HashMap<>();

        JsonObject jsonObject = json.getAsJsonObject();
        for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            List<CssValue> cssValues = new ArrayList<>();
            entry.getValue().getAsJsonArray().forEach(jsonElement -> {
                jsonElement.getAsJsonObject().entrySet()
                        .forEach(eEntry -> cssValues.add(new CssValue(eEntry.getKey(), eEntry.getValue().getAsString())));
            });

            result.put(key, cssValues.toArray(new CssValue[cssValues.size()]));
        }

        return result;
    }
}
