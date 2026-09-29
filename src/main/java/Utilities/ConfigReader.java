package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;  //stores Key-Value Pairs

    // Load config.properties file 
    static {    //automatically executes the block when class is loaded
    	
    	prop = new Properties();

        try {
        	
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
            fis.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    // Get property value
    public static String getProperty(String key) {

        return prop.getProperty(key);
    }
}
