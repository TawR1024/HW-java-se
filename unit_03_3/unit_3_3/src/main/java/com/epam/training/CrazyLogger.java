package com.epam.training;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * CrazyLogger logs yours errors;
 * <p>
 * <br>CrazyLogger used to log errors.</br>
 * <br>This logger does`t save log messages to the disk, all logs stored in RAM.</br>
 *
 * @author Ilya Kulakov
 * @date 26.02.2017
 */
public class CrazyLogger {

    StringBuilder log = new StringBuilder();
    int indexOfLastMessageExclusiveFirst = 0;


    /**
     * Adds new message to the log;
     *
     * @param message to add
     *                <br>All messages will have format  dd-mm--YYYY:hh-mm - message;</br>
     *                <br>Each message ends with ';' character;</br>
     */
    public void addNewLogMessage(String message) {
        LocalDateTime now = LocalDateTime.now();
        log.append(now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")));
        log.append(" - ");
        log.append(message);
        log.append(";\n");
        log.trimToSize();
        indexOfLastMessageExclusiveFirst = log.capacity() - message.length() - 2;
    }

    /**
     * @return string which contains last message in the log;
     * @throws RuntimeException if log is empty;
     */
    public String getLastMessage() throws RuntimeException {
        log.trimToSize();
        if (log.capacity() == 0)
            throw new RuntimeException("CrazyLogger is empty");
        return log.substring(indexOfLastMessageExclusiveFirst);
    }

    /**
     * Writes all log messages to the console
     */
    public void showLog() {
        System.out.println(log);
    }


    public StringBuilder getLog() {
        StringBuilder stringBuilder = this.log;
        return stringBuilder;
    }


}
