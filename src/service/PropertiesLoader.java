package service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties loadProperties() {
        Properties configuration = new Properties();
        InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream(String.valueOf(Paths.get("main","resources","applications.properties")));
        try {
            configuration.load(inputStream);
        } catch (IOException e) {
            System.out.println("File application.properties not found!");
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return configuration;
    }
}