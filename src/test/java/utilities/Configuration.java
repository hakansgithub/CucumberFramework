package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    public static String getProperties (String key) throws IOException {

        File credsFile = new File("src/test/resources/conf/Configuration.properties");
        FileReader fileReader = new FileReader(credsFile);
        Properties properties = new Properties();
        properties.load(fileReader);

        if (properties.getProperty(key) != null) {
            String value = properties.getProperty(key);
            return value;
        } else {
            return "invalid input";
        }
    }
}