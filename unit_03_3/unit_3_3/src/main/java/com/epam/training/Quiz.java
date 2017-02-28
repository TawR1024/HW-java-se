package com.epam.training;

import java.util.Locale;

/**
 * Created by Ilya Kulakov on 28.02.17.
 */
public class Quiz {


    private String quizeName;
    private Locale locale;

    public Quiz() {

    }

    public Quiz(String quizName) {
        this.quizeName = quizName;
    }

    public void chaooseLanguage(int i) {
        switch (i) {
            case 1: locale = new Locale("ru", "Ru", "Unix");
            break;
            case 2: locale = new Locale("en", "En", "Unix");
            break;
            default: locale = Locale.getDefault();
            break;
        }

    }

    public String getLocale() {
        return locale.getLanguage();
    }
}
