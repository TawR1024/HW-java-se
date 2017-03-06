package com.epam.training;

import org.junit.Test;

import java.io.InputStreamReader;

/**
 * Created by Ilya Kulakov on 05.03.17.
 */
public class ByteIOStreamsTest {
    @Test
    public  void keyWordCounter() {
        ByteIOStreamss keyWordChecker = new ByteIOStreamss();
        String pahtFile = "src/main/java/com/epam/training/TrySerial.java";
        keyWordChecker.openFile(pahtFile);
        keyWordChecker.readFile();
    }


}