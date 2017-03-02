package com.epam.training;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ilya Kulakov on 28.02.17.
 */
public class QuizTest {
    @Test
    public void chooseLanguageRu() {
        Quiz quiz = new Quiz("Math for children");
        quiz.chaooseLanguage(1);
        assertEquals(new Locale("ru").getLanguage(), quiz.getLocale());

    }

    @Test
    public void chooseLanguageEn() {
        Quiz quiz = new Quiz("Math for children");
        quiz.chaooseLanguage(2);
        assertEquals(new Locale("en").getLanguage(), quiz.getLocale());

    }

    @Test
    public void chooseLanguageDefault() {
        Quiz quiz = new Quiz("Math for children");
        quiz.chaooseLanguage(6);
        assertEquals(Locale.getDefault().getLanguage(), quiz.getLocale());
    }

    @Test
    public void showQuestions() {
        Quiz quiz = new Quiz("Math for children");
        quiz.chaooseLanguage(2);
        quiz.showQuestions();
    }

    @Test
    public void checkL10nTest(){
        Quiz quiz = new Quiz();
        quiz.checkLocale();
    }
}