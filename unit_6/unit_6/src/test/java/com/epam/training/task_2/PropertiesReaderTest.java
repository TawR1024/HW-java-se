package com.epam.training.task_2;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Ilya Kulakov on 26.03.17.
 */
@FixMethodOrder
public class PropertiesReaderTest {
    private Path path;
    private PropertiesReader propertiesReader;
    private Path wrongPath;

    @Before
    public void init() throws IOException {
        path = Paths.get("/home/ilya-kulakov/Документы/training/unit_6/unit_6/src/main/resources/test.properties");
        wrongPath = Paths.get("/src/main/resources/test.property");
        propertiesReader = PropertiesReader.readPropertyFile(path);

    }

    @Test(expected = java.io.FileNotFoundException.class)
    public void readPropertiesWithBadPathTest() throws IOException {
        propertiesReader.readPropertyFile(wrongPath);
    }


    @Test
    public void readPropertiesSuccessfulTest() throws IOException {
        propertiesReader.readPropertyFile(path);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void getEmptyPropertyTest() {
        propertiesReader.getProperty(null);
    }

    @Test (expected = NoSuchKeyException.class)
    public void getPropertyWithNotExistingKeyTest() {
        propertiesReader.getProperty("psum");
    }

    @Test
    public void getPropertyWithNormalKey() {
        propertiesReader.getProperty("lore");
    }


}