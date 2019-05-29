package com.usf.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;


public class ConfigurationReader {

    private enum location {
        CORE, CLIENT, NONE
    }

    private Properties clientConfigProperty;
    private Properties coreConfigProperty;
    private String filePath;
    private HashMap clientConfigs;
    private HashMap coreConfigs;

    public ConfigurationReader(String filename) {
        this.coreConfigProperty = new Properties();
        this.clientConfigProperty = new Properties();
        this.filePath = checkName(filename);

        readCoreConfigFile();
        readClientConfigFile();
    }

    public HashMap getClientConfigs() {
        return clientConfigs;
    }

    public HashMap getCoreConfigs() {
        return coreConfigs;
    }

    /**
     * Return the configuration value from client
     * or "Invalid Configuration Key" as default
     * @param key
     * @return
     */
    public String getConfigValue(String key) {
        switch (getOwner(key)) {
            case CLIENT:
                return clientConfigProperty.getProperty(key);
            case CORE:
                return coreConfigProperty.getProperty(key);
            case NONE:
                return "Invalid Configuration Key!";
            default:
                return null;
        }
    }

    private String checkName(String name) {
        if (!name.contains(".properties")) {
            name += ".properties";
        }
        return name;
    }


    private void readCoreConfigFile() {
        try {
            coreConfigs = new HashMap();
            InputStream properties = this.getClass().getClassLoader().getResourceAsStream("config.properties");
            coreConfigProperty.load(properties);
            for (String key : coreConfigProperty.stringPropertyNames()) {
                String value = coreConfigProperty.getProperty(key);
                coreConfigs.put(key, String.valueOf(value));
            }
            properties.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readClientConfigFile() {
        try {
            clientConfigs = new HashMap();
            InputStream properties = this.getClass().getClassLoader().getResourceAsStream(this.filePath);
            clientConfigProperty.load(properties);
            for (String key : clientConfigProperty.stringPropertyNames()) {
                String value = clientConfigProperty.getProperty(key);
                clientConfigs.put(key, String.valueOf(value));
            }
            properties.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private location getOwner(String key) {
        // if the key is in both client and core properties
        if(isInClientConfigs(key) && isInCoreConfigs(key)) {
            // if the key is blank in the client file
            if(clientConfigs.get(key).equals("")) {
                // use the core property
                return location.CORE;
            } else {
                // if it's not blank use the client property
                return location.CLIENT;
            }
        } // if the key is only in the client property
        else if(isInClientConfigs(key) && !isInCoreConfigs(key)) {
            // the key has a blank value
            if(clientConfigs.get(key).toString().equals("")) {
                return location.NONE;
            } // use the client property
            else {
                return location.CLIENT;
            }
        } // if the key is only in the core property
        else if(!isInClientConfigs(key) && isInCoreConfigs(key)) {
            // the key has as blank value
            if(coreConfigs.get(key).toString().equals("")) {
                return location.NONE;
            } // use the core property
            else {
                return location.CORE;
            }
        } // if the key can't be located in either property file
        else {
            return location.NONE;
        }
    }

    private boolean isInClientConfigs(String key) {
        if(this.clientConfigs == null) {
            return false;
        } else if(clientConfigs.containsKey(key)
                && clientConfigs.get(key) != null) {
            return true;
        }
        return false;
    }

    private boolean isInCoreConfigs(String key) {
        if(this.coreConfigs == null) {
            return false;
        } else if(coreConfigs.containsKey(key)
                && coreConfigs.get(key) != null) {
            return true;
        }
        return false;
    }

}