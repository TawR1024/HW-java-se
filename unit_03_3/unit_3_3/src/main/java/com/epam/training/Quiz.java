package com.epam.training;


import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by Ilya Kulakov on 28.02.17.
 */
public class Quiz {


    private String quizeName;
    private Locale locale;

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.checkLocale();
        quiz.showQuestions();
    }

    public Quiz() {

    }

    public Quiz(String quizName) {
        this.quizeName = quizName;
    }

    public void chaooseLanguage(int i) {
        switch (i) {
            case 1:
                locale = new Locale("ru");
                break;
            case 2:
                locale = new Locale("en");
                break;
            default:
                locale = Locale.getDefault();
                break;
        }
    }

    public String getLocale() {
        return locale.getLanguage();
    }

    public void showQuestions() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
        System.out.println(locale.getLanguage());
        Enumeration<String> keys = resourceBundle.getKeys();
        while (keys.hasMoreElements()) {
            System.out.println(resourceBundle.getString(keys.nextElement()));
        }
    }

    public void startQuiz() {

        checkLocale();
        showQuestions();


    }

    public void checkLocale() {
        if (locale == null) {
            System.out.println("To select language pres\n 1 - eng\n 2 - rus\n" +
                    "Для выбора языка нажимите\n 1 - русский\n 2 - английский\n> ");
        }
        Scanner scanner = new Scanner(System.in);
        chaooseLanguage(scanner.nextInt());
    }
}
