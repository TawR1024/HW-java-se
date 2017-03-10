package com.epam.training;

import com.epam.training.task1.ByteIOStreamss;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Ilya Kulakov on 05.03.17.
 */
public class ByteIOStreamsTest {

        ByteIOStreamss keyWordChecker;
    @Before
    public void init(){
        keyWordChecker = new ByteIOStreamss();
        String pathFile = "src/main/java/com/epam/training/JustForFun/TrySerial.java";
        keyWordChecker.openFile(pathFile);
        keyWordChecker.readFile();
    }

    @Test
    public void keyWordCounter() {
        String pahtFile = "src/main/java/com/epam/training/JustForFun/TrySerial.java";
        keyWordChecker.openFile(pahtFile);
    }

    @Test
    public void getKeysTest(){
        keyWordChecker.getBasicKeyWords();
        System.out.println(keyWordChecker.getKeys());
    }

    @Test
    public void analyticTest() {
        keyWordChecker.getBasicKeyWords();
        keyWordChecker.analyseJavaFile();
        System.out.println(keyWordChecker.getResult());
    }

    @Test
    public void writeResultTest() {
        keyWordChecker.getBasicKeyWords();
        keyWordChecker.analyseJavaFile();
        keyWordChecker.writeResultToFile("src/main/java/com/epam/training/JustForFun/result.task1");
    }



}