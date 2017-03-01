package com.epam.training;

import java.util.Locale;
import java.util.ResourceBundle;

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
            case 1: locale = new Locale("ru");
            break;
            case 2: locale = new Locale("en");
            break;
            default: locale = Locale.getDefault();
            break;
        }
    }

    public String getLocale() {
        return locale.getLanguage();
    }

    public void showQuestions() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages.properties",locale);
        System.out.println(locale.getLanguage());
        System.out.println(resourceBundle.getString("key"));
    }
}
