package config;

import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Agatino D'Agate on 29/06/2017.
 */
public class LoadProperties {

    private static LoadProperties instance = null;
    Properties prop = new Properties();

    InputStream input = null;

    private LoadProperties() {
    }

    public static LoadProperties getInstance() {
        return (instance == null) ? (instance = new LoadProperties()) : instance;
    }

    public List<String> getProperties() {
        try {
            input = new FileInputStream("src" + File.separator + "config" + File.separator + "db-dev.properties");
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // get the property value and print it out
        return prop.keySet().stream().map(Object::toString).collect(Collectors.toList());
    }

    public String getProp(String properties) {
        if (prop.containsKey(properties)) {
            return prop.getProperty(properties);
        }
        return null;
    }
}
