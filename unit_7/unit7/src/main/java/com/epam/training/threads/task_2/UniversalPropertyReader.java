package com.epam.training.threads.task_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
     * Builder for UniversalPropertyReader class
     *
     * @param pathToProperties path to file with properties
     * @return reference to UniversalPropertyReader object
     * @throws NoSuchFileException if file with properties not exist or path to file bad
     */
    public static UniversalPropertyReader builder(String pathToProperties) throws NoSuchFileException {
        File propertyFile = new File(pathToProperties);
        if (!propertyFile.exists())
            throw new NoSuchFileException(propertyFile.getAbsolutePath().toString());
        synchronized (propertyFile) {
            Properties properties = new Properties();
            try (FileInputStream fileInputStream = new FileInputStream(propertyFile)) {
                properties.load(fileInputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new UniversalPropertyReader(properties);
        }

    }
}
