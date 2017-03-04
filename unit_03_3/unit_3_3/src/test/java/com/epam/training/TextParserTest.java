package com.epam.training;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by Ilya Kulakov on 04.03.17.
 */
public class TextParserTest {
        TextParser textParser;

    @Before
    public void openFileTest(){
        textParser = new TextParser();
        textParser.openFile("src/main/resources/fileToParse.html");
    }

    @Test
    public void parseFile(){
            textParser.parseFile();
    }
}