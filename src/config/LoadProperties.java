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
    private static String fp = null;
    private static Properties prop = new Properties();

    private static InputStream input = null;

    private LoadProperties() {
        try {
            input = new FileInputStream(fp);
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
    }

    public static LoadProperties getInstance() {
        if (fp==null){
            System.err.println("Caricare il file di property prima di usarlo.");
            return null;
        }
        return (instance == null) ? (instance = new LoadProperties()) : instance;
    }

    public List<String> getProperties() {
        // get the property value and print it out
        return prop.keySet().stream().map(Object::toString).collect(Collectors.toList());
    }

    public String getProp(String properties) {
        if (prop.containsKey(properties)) {
            return prop.getProperty(properties);
        }
        return null;
    }

    public static void setFp(String file) {
        File f = new File(file);
        if(f.exists()) {
            fp = file;
        }else{
            fp=null;
            System.err.println("File di property non valido!");
        }
    }
}
