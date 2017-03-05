package com.epam.training;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Ilya Kulakov on 04.03.17.
 */
public class TextParserTest {
        TextParser textParser;

    @Test
    public void openFileTest(){
        textParser = new TextParser();
        textParser.openFile("src/main/resources/fileToParse.html");
    }

    @Test
    public void parseFile(){
            textParser.readFile();
    }
    @Test
    public void showSentencesWithReferenceToPicture() {
        textParser = new TextParser();
        textParser.openFile("src/main/resources/fileToParse.html");
        String  stringsFromFile = textParser.readFile();
        textParser.showStringsWithPictures(stringsFromFile);
    }
}