package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Configuration {
    public static String getProperties(String key) throws IOException, IOException {
        //specify the needed file
        File credsFile = new File("src/test/Resource/conf/Configuration.properties");
        //read from file, it reads line by line, but it will not get you
        //keys or values seperately
        FileReader fileReader = new FileReader(credsFile);
        Properties properties = new Properties();
        properties.load(fileReader);


        Set<Object> set = properties.keySet();
        String value="";
        if(set.contains(key)){
            value=properties.getProperty(key);

            return value;
        }else {
            System.out.println("Sorry, no such key in properties file");
        }
        return value;
    }
}
