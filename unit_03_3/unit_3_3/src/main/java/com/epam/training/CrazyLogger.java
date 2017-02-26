package com.epam.training;

/**
 * Created by Ilya Kulakov on 26.02.17.
 */
public class CrazyLogger {
    StringBuilder log = new StringBuilder();
    int indexOfLastMessageExclusiveFirst = 0;

    public void addNewLogMessage(String message) {
        log.append(message);
        log.append(";\n");
        log.trimToSize();
        indexOfLastMessageExclusiveFirst = log.capacity()-message.length()-2;
    }

    public String getLastMessage()throws RuntimeException {
        log.trimToSize();
        if (log.capacity() == 0)
            throw new RuntimeException("CrazyLogger is empty");
        return log.substring(indexOfLastMessageExclusiveFirst);
    }
    public void showLog() {
        System.out.println(log);
    }
}
