package org.booker.config;

import org.booker.utils.PropertyUtils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;
    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("src/main/resources/app.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getUrl(){
        String prop = properties.getProperty("url");
        if(prop != null) return prop;
        else throw new RuntimeException("property url is not specified in the config.properties file");
    }

    public String getUserName(){
        String prop = properties.getProperty("username");
        if(prop != null) return prop;
        else throw new RuntimeException("property username is not specified in the config.properties file");
    }

    public String getPassword(){
        String prop = properties.getProperty("username");
        if(prop != null) return prop;
        else throw new RuntimeException("property username is not specified in the config.properties file");
    }
}
