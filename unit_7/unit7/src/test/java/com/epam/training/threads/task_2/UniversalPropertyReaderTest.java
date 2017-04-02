package com.epam.training.threads.task_2;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.NoSuchFileException;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by Ilya Kulakov on 01.04.17.
 */
public class UniversalPropertyReaderTest {

    public UniversalPropertyReader reader1;
    public UniversalPropertyReader reader2;
    public UniversalPropertyReader reader3;
    public String propertyFile;

    @Before
    public void init(){
        propertyFile ="src/main/java/com/epam/training/threads/task_2/data.properties";
        try {
            reader1 = UniversalPropertyReader.builder(propertyFile);
            reader2 = UniversalPropertyReader.builder(propertyFile);
            reader3 = UniversalPropertyReader.builder(propertyFile);

        } catch (NoSuchFileException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getKeyTest() throws Exception {
        assertTrue(reader1.getProperty("key1").equals("value 1"));
    }

    @Test
    public void MultyThreadingTest() throws Exception {

        assertTrue(reader1.getProperty("key2").equals("value 2"));
        assertTrue(reader2.getProperty("key2").equals("value 2"));
        assertTrue(reader3.getProperty("key3").equals("value 3"));
    }
}