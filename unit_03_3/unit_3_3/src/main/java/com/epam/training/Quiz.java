package com.epam.training;


import java.util.*;

import static java.util.Collections.*;

/**
 * Created by Ilya Kulakov on 28.02.17.
 */
public class Quiz {


    private String quizeName;
    private Locale locale;

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
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
        List<String> keys  = Collections.list(resourceBundle.getKeys());
        Collections.sort(keys);
        for(int i = 0; i < keys.size(); i++){
            String key = keys.get(i);
            String question = resourceBundle.getString(key);
            System.out.println(question);
        }
    }

    public void startQuiz() {
        checkLocale();
        showAnswer();
    }

    private void showAnswer() {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("answer", locale);
        List<String> keys = Collections.list(resourceBundle.getKeys());
        Collections.sort(keys);
        int numberOfQuestion;
        String key;
        for (; ; ) {
            showQuestions();
            System.out.print("Для введите номер вопроса, что бы увидеть ответ\nДля выхода нажмите 0\n>");
            numberOfQuestion = scanner.nextInt();
            if (numberOfQuestion == 0)
                return;
            key = keys.get(numberOfQuestion-1);
            System.out.println(resourceBundle.getString("message") + " "+ resourceBundle.getString(key)+ "\n");
        }
    }

    public void checkLocale() {
        if (locale == null) {
            System.out.print("To select language press\n 1 - rus\n 2 - eng\n" +
                    "Для выбора языка нажимите\n 1 - русский\n 2 - английский\n> ");
        }
        Scanner scanner = new Scanner(System.in);
        chaooseLanguage(scanner.nextInt());
    }
}
