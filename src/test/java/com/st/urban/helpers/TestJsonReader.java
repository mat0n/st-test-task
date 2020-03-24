package com.st.urban.helpers;

import com.codeborne.selenide.conditions.CssValue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;
import java.util.Map;

public class TestJsonReader {

    private static final String UTF = "UTF-8";

    public static <T> T readJson(Class clazz, String path, Class<T> entityClass) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(clazz.getResourceAsStream(path), UTF)) {
            return new Gson().fromJson(inputStreamReader, entityClass);
        } catch (Exception ex) {
            throw new RuntimeException("Can't read test data files", ex);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, CssValue[]> readCssAttributeJson(Class clazz, String path) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(clazz.getResourceAsStream(path), UTF)) {
            return new GsonBuilder()
                    .registerTypeAdapter(Map.class, new CssAttributeDeserializer())
                    .create()
                    .fromJson(inputStreamReader, Map.class);
        } catch (Exception ex) {
            throw new RuntimeException("Can't read test data files", ex);
        }
    }

}
