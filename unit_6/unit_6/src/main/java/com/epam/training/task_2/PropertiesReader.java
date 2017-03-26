package com.epam.training.task_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by Ilya Kulakov on 26.03.17.
 */
public class PropertiesReader {
    private final Map<String, String> properties;

    public PropertiesReader(Map<String, String> file) {
        this.properties = file;
    }

    /**
     * @param path
     * @throws IOException
     */
    public static PropertiesReader readPropertyFile(Path path) throws IOException {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(path.toFile())) {
            properties.load(fileInputStream);
        }
        Map<String, String> data = readPropertiesIntoMap(properties);
        return new PropertiesReader(data);
    }

    /**
     * Read properties and convert data from file to Map.
     *
     * @param properties
     * @return <code>dataFromProperties</code>converted HashMap from properies to Map
     */
    private static Map<String, String> readPropertiesIntoMap(Properties properties) {
        Map<String, String> dataFromProperties = new HashMap<>();

        for (Map.Entry<Object, Object> pair : properties.entrySet()) {
            String key = (String) pair.getKey();
            String value = (String) pair.getValue();

            dataFromProperties.put(key, value);
        }
        return dataFromProperties;
    }

    public void getProperty(String key) throws NoSuchKeyException {
        Objects.requireNonNull(key);
        String property = properties.get(key);
        if (property == null)
            throw new NoSuchKeyException("Keu: " + key + "not found at properties");
    }
}
