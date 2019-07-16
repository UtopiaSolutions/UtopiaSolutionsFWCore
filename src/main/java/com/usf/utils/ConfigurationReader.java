package com.usf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;


public class ConfigurationReader {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationReader.class);

    private static Properties clientConfigProperty;
    private static Properties coreConfigProperty;

    public static HashMap<String, String> configurations;


    public static void readConfigurations() {
        coreConfigProperty = new Properties();

        configurations = new HashMap<>();

        readCoreConfigFile();
    }

    public static void readConfigurations(String filename) {
        coreConfigProperty = new Properties();
        clientConfigProperty = new Properties();

        configurations = new HashMap<>();

        readCoreConfigFile();
        readClientConfigFile(filename);
    }

    /**
     * Return the configuration value from client
     * or "Invalid Configuration Key" as default
     * @param key
     * @return
     */
    public static String getConfigValue(String key) {
        return configurations.get(key);
    }

    private static String checkName(String name) {
        if (!name.contains(".properties")) {
            name += ".properties";
        }
        return name;
    }


    private static void readCoreConfigFile() {
        try {
            InputStream properties = ConfigurationReader.class.getClassLoader().getResourceAsStream("config.properties");
            coreConfigProperty.load(properties);
            for (String key : coreConfigProperty.stringPropertyNames()) {
                String value = coreConfigProperty.getProperty(key);
                configurations.put(key, String.valueOf(value));
                log.debug("USF configuration loaded: " + key + "=" + value);
            }
            properties.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void readClientConfigFile(String filename) {
        try {
            InputStream properties = ConfigurationReader.class.getClassLoader().getResourceAsStream(checkName(filename));
            clientConfigProperty.load(properties);
            for (String key : clientConfigProperty.stringPropertyNames()) {
                String value = clientConfigProperty.getProperty(key);
                if(configurations.containsKey(key)) {
                    log.debug("USF configuration overwritten with custom configuration: " + key + "=" + value);
                } else {
                    log.debug("Custom configuration loaded: " + key + "=" + value);
                }
                configurations.put(key, String.valueOf(value));
            }
            properties.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}