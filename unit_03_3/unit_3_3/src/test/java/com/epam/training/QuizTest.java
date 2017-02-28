package com.epam.training;

import org.junit.Test;

import java.util.Locale;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Unix;

/**
 * Created by Ilya Kulakov on 28.02.17.
 */
public class QuizTest {
    @Test
    public void chooseLanguage() {
        Quiz quiz = new Quiz("Math for children");
        quiz.chaooseLanguage(new Locale("ru", "Ru", Unix));

    }
}
