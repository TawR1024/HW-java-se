package com.epam.training.task_2;

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
   private final Map<String, String> propeties;

    public PropertiesReader(Map<String, String> file) {
        this.propeties = file;
    }

    /**
     * @param path
     * @throws IOException
     */
    public void readPropertyFile(Path path)throws  IOException {
        Objects.requireNonNull(path);

        Properties properties = new Properties();

        try(FileInputStream fileInputStream = new FileInputStream(path.toFile())) {
            properties.load(fileInputStream);
        }
        Map<String, String> data = readPropertiesIntoMap(properties);
    }

    /**
     *
     * Read properties and convert data from file to Map.
     * @param properties
     * @return <code>dataFromProperties</code>converted HashMap from properies to Map
     */
    private Map<String,String> readPropertiesIntoMap(Properties properties) {
        Map<String, String> dataFromProperties = new HashMap<>();

        for (Map.Entry<Object, Object> pair : properties.entrySet()){
            String key = (String) pair.getKey();
            String value = (String) pair.getValue();

            dataFromProperties.put(key, value);
        }
        return dataFromProperties;
    }

    public void getProperty(String key) {
    }
}
