package com.epam.training.task_2;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Ilya Kulakov on 26.03.17.
 */
public class PropertiesReaderTest {
    private Path path;
    private PropertiesReader propertiesReader;

    @Before
    public void init() throws IOException {


    }


    @Test(expected = java.io.FileNotFoundException.class)
    public void readPropertiesWithBadPathTest() throws IOException {
        propertiesReader.readPropertyFile();
    }


    @Test
    public void readPropertiesSuccessfulTest(){
        propertiesReader.readPropertyFile();
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void getEmtyPropertyTest(){
        propertiesReader.getProperty();
    }

    @Test
    public void getPropertyWithNotExistingKeyTest(){
        propertiesReader.getProperty();
    }

    @Test
    public void getPropertyWithNormalKey(){

    }


}