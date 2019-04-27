package program;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    public static final String PROPERTY_FILE = "src/main/resources/config.properties";
    private static Properties properties = null;
    private static PropertyManager instance;
    private static Object lock = new Object();

    public PropertyManager() {

    }

    public static PropertyManager getInstance() throws IOException {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new PropertyManager();
                    instance.loadProperties();
                }
            }
        }
        return instance;

    }

    private void loadProperties() {

        try (InputStream input = new FileInputStream(PROPERTY_FILE)) {

            properties = new Properties();
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        String val = null;
        if (key != null) {
            if (properties != null)
                val = (String)properties.getProperty(key);
            if (val == null) {
                val = properties.getProperty(key);
            }
        }
        return val;
    }


}
