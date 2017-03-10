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
    }

    @Test
    public void keyWordCounter() {
        String pahtFile = "src/main/java/com/epam/training/JustForFun/TrySerial.java";
        keyWordChecker.openFile(pahtFile);
        keyWordChecker.readFile();
    }

    @Test
    public void getKeysTest(){
        keyWordChecker.getBasicKeyWords();
        System.out.println(keyWordChecker.getKeys());
    }

}