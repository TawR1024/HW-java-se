package com.epam.training;

/**
 * Created by Ilya Kulakov on 26.02.17.
 */
public class CrazyLogger {
    StringBuilder log = new StringBuilder();

    public void addNewLogMessage(String message) {
        log.append(message);
        log.append('\n');
    }

    public String getLastMessage() {
        return "nope";
    }
    public void showLog() {
        System.out.println(log);
    }
}
