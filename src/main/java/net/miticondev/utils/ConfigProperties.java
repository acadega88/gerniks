package net.miticondev.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    private static final Properties prop = new Properties();

    static {
        try (InputStream input = ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties file not found");
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getURL() {
        return prop.getProperty("url");
    }

    public static String getBrowser() {
        return prop.getProperty("browser");
    }
}
