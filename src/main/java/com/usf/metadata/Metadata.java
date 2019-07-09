package com.usf.metadata;

import java.util.HashMap;
import java.util.Map;

public class Metadata {
    private static Metadata instance = null;

    public static HashMap<String, String> metadata;

    private Metadata() {
        metadata = new HashMap<>();
    }

    public static Metadata getInstance() {
        if(instance == null) {
            instance = new Metadata();
        }
        return instance;
    }

    public static void add(String key, String value) {
        metadata.put(key, value);
    }

    public static Map<String, String> getMetadata() {
        return metadata;
    }

    public static String getValue(String key) {
        return metadata.get(key);
    }

    public static void remove(String key) {
        metadata.remove(key);
    }

    public static void deleteInstance() {
        instance = null;
    }
}
