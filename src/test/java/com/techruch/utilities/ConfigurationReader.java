package com.techruch.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    // properties --> class that store properties in key / value format
    private static Properties properties = new Properties();

    // static block: runs first before our codes
    static {

        try {
            // which file to read
            String path = "configuration.properties";
            // FileInputStream object finds the file using the string path, reads the file into java.
            FileInputStream file = new FileInputStream(path);

            // the values from the "configuration.properties" are loaded to file object
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {

        return properties.getProperty(keyName);
    }
}
