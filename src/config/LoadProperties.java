package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Agatino D'Agate on 29/06/2017.
 */
public class LoadProperties {

    private static LoadProperties instance = null;
    Properties prop = new Properties();
    String propUser = prop.getProperty("db.connection.user");
    String propPassword = prop.getProperty("db.connection.password");
    String propHost = prop.getProperty("db.connection.host");
    String propPort = prop.getProperty("db.connection.port");
    String propEncode = prop.getProperty("db.connection.encode");
    String propDatabase = prop.getProperty("db.connection.database");

    InputStream input = null;

    private LoadProperties() {
    }

    public static LoadProperties getInstance() {
        return (instance == null) ? (instance = new LoadProperties()) : instance;
    }

    public String getProperties() {
        try {
            input = new FileInputStream("db-dev.properties");
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
        return propUser + " " + propPassword + " " + propHost +
                " " + propPort + " " + propEncode + " " + propDatabase;
    }

    public String getProp(String properties) {
        if (properties.equals(propUser) || properties.equals(propPassword)
                || properties.equals(propHost) || properties.equals(propPort)
                || properties.equals(propEncode) || properties.equals(propDatabase)) {
            return properties;
        } else {
            return null;
        }
    }
}
