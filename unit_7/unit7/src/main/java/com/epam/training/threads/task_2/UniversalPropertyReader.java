package com.epam.training.threads.task_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Threadsafe property reader
 * <p>
 * Created by Ilya Kulakov on 01.04.17.
 */
public class UniversalPropertyReader extends Thread {

    private final Properties properties;

    private UniversalPropertyReader(Properties properties) {
        this.properties = properties;
    }

    /**
     * Cause we must read property file only one time.
     * Map contains path to file as a Key, and reference to Properties object as a Value
     */
    private static Map<String, Properties> cachedProperties = new ConcurrentHashMap<>();

    /**
     * Builder for UniversalPropertyReader class
     *
     * @param pathToProperties path to file with properties
     * @return reference to UniversalPropertyReader object
     * @throws NoSuchFileException if file with properties not exist or path to file bad
     */
    public static UniversalPropertyReader builder(String pathToProperties) throws IOException {
        File propertyFile = new File(pathToProperties);

        if (!propertyFile.exists())
            throw new NoSuchFileException(propertyFile.getAbsolutePath().toString());

        synchronized (propertyFile) {
            if (cachedProperties.containsKey(pathToProperties)) {
                return new UniversalPropertyReader(cachedProperties.get(pathToProperties));
            } else {
                Properties properties = new Properties();
                try (FileInputStream fileInputStream = new FileInputStream(propertyFile)) {
                    properties.load(fileInputStream);
                }

                cachedProperties.put(pathToProperties, properties);
                return new UniversalPropertyReader(properties);
            }
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
