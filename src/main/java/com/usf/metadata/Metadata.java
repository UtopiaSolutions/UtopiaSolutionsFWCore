package com.usf.metadata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Metadata {
    private static final Logger log = LoggerFactory.getLogger(Metadata.class);

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
        log.debug("A new value with the key \"" + key + "\" was added to metadata." );
    }

    public static Map<String, String> getMetadata() {
        return metadata;
    }

    public static String getValue(String key) {
        if(metadata.get(key).equals("") || metadata.get(key) == null) {
            log.debug("getValue(" + key + ") returned invalid metadata.");
        } else {
            log.debug("getValue(" + key + ") returned valid metadata.");
        }
        return metadata.get(key.toLowerCase());
    }

    public static void remove(String key) {
        metadata.remove(key);
    }

    public static void deleteInstance() {
        instance = null;
    }
}
