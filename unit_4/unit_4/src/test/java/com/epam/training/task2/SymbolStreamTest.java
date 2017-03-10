package com.epam.training.task2;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Ilya Kulakov on 10.03.17.
 */
public class SymbolStreamTest {
    SymbolStream keyWordCounter;

    @Before
    public void init() {
        keyWordCounter = new SymbolStream();
        String pathFile = "src/main/java/com/epam/training/JustForFun/TrySerial.java";
        keyWordCounter.openFile(pathFile);
        keyWordCounter.getBasicKeyWords();
    }


    @Test
    public void readFile() throws Exception {
        keyWordCounter.readFile();

    }

    @Test
    public void analyseJavaFile() throws Exception {

    }

    @Test
    public void writeResultToFile() throws Exception {

    }

}