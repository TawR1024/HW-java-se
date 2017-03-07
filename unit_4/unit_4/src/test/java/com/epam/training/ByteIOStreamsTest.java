package com.epam.training;

import com.epam.training.task1.ByteIOStreamss;
import org.junit.Test;

/**
 * Created by Ilya Kulakov on 05.03.17.
 */
public class ByteIOStreamsTest {
    @Test
    public void keyWordCounter() {
        ByteIOStreamss keyWordChecker = new ByteIOStreamss();
        String pahtFile = "src/main/java/com/epam/training/JustForFun/TrySerial.java";
        keyWordChecker.openFile(pahtFile);
        keyWordChecker.readFile();
    }


}