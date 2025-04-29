package Utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;


public class PropertiesUtils {
    public static final String propertiesDirectoryPath = "src/main/resources/";

    private PropertiesUtils() {
    }

    public static Properties loadProperties() {
        try {
            Properties properties = new Properties();
            Collection<File> propertiesFilesList;
            propertiesFilesList = FileUtils.listFiles(new File(propertiesDirectoryPath), new String[]{"properties"}, true);
            propertiesFilesList.forEach(propertiesFile -> {
                try {
                    properties.load(new FileInputStream(propertiesFile));
                    LogsUtils.info("Properties file loaded successfully");
                } catch (IOException e) {
                    LogsUtils.error("Error loading properties", e.getMessage());
                }
                properties.putAll(System.getProperties());
                System.getProperties().putAll(properties);
            });
            LogsUtils.info("Loading properties file data");
            return properties;
        } catch (Exception e) {
            LogsUtils.error("Error loading properties", e.getMessage());
            return null;
        }
    }

    public static String getPropertyValue(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            LogsUtils.error("Error getting property", e.getMessage());
            return "";
        }
    }
}
