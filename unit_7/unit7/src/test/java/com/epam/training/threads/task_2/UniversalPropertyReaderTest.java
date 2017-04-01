package com.epam.training.threads.task_2;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Ilya Kulakov on 01.04.17.
 */
public class UniversalPropertyReaderTest {

    public UniversalPropertyReader reader;
    public String propertyFile;
    public Properties properties;

    @Before
    public void init(){
        propertyFile ="/unit7/src/main/java/com/epam/training/threads/task_2";
        Properties properties = new Properties();
        reader = new UniversalPropertyReader();
    }


}