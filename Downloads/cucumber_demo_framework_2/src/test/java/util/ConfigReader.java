package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mohammad Muntakim
 */
public class ConfigReader {

    private String url;
    private String chromeDriverPath;
    private String url2;

    public ConfigReader() {

        Properties prop = new Properties();
        Properties prop2 = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.url = prop.getProperty("url");
            this.url2 = prop2.getProperty("url2");
            this.chromeDriverPath = prop.getProperty("chrome_driver_path");

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

    public String getUrl() {

        return url;
    }

    public String getChromeDriverPath() {

        return chromeDriverPath;
    }
    public String getUrl2(){
        return url2;
    }
}
