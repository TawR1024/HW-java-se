package com.epam.training;

import org.junit.Test;

import java.util.Locale;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Unix;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ilya Kulakov on 28.02.17.
 */
public class QuizTest {
    @Test
    public void chooseLanguageRu() {
        Quiz quiz = new Quiz("Math for children");
        quiz.chaooseLanguage(1);
        assertEquals(new Locale("ru", "Ru", "Unix").getLanguage(), quiz.getLocale());

    }
    @Test
    public void chooseLanguageEn() {
        Quiz quiz = new Quiz("Math for children");
        quiz.chaooseLanguage(2);
        assertEquals(new Locale("en", "En", "Unix").getLanguage(), quiz.getLocale());

    }
    @Test
    public void chooseLanguageDefault() {
        Quiz quiz = new Quiz("Math for children");
        quiz.chaooseLanguage(6);
        assertEquals(Locale.getDefault().getLanguage(), quiz.getLocale());

    }
}
