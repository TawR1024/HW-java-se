package com.epam.training;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static org.junit.Assert.assertTrue;

public class CrazyLoggerTest {
    @Test
    public void addNewLogMessageTest() {
        CrazyLogger logger = new CrazyLogger();
        LocalDateTime now = LocalDateTime.now();
        String message =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Error #1";

        logger.addNewLogMessage(message);
        assertTrue(logger.getLastMessage().contains(message));
    }

    @Test
    public void showLogTest() {
        LocalDateTime now = LocalDateTime.now();
        String message =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Error #1";
        CrazyLogger logger = new CrazyLogger();

        logger.addNewLogMessage(message);
        logger.showLog();
    }

}
