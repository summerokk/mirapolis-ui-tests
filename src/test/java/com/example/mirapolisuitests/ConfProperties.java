package com.example.mirapolisuitests;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfProperties {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfProperties.class);
    private static Properties PROPERTIES;

    static {
        try(FileReader fileReader = new FileReader("src/test/resources/conf.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileReader);
        } catch (IOException exception) {
            LOGGER.error("Configuration file not found");
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
