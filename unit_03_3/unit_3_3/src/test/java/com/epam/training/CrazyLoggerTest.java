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
        String message1 =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Error #1";
        String message2 =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Error #2";
        String message3 =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Error #3";
        String message4 =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Error #4";
        String message5 =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Error #5";
        String message6 =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Error #6";
        String message7 =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Error #7";
        CrazyLogger logger = new CrazyLogger();

        logger.addNewLogMessage(message1);
        logger.addNewLogMessage(message2);
        logger.addNewLogMessage(message3);
        logger.addNewLogMessage(message4);
        logger.addNewLogMessage(message5);
        logger.addNewLogMessage(message6);
        logger.addNewLogMessage(message7);
        logger.showLog();
    }

    @Test
    public void getLastMessageTest() {
        CrazyLogger logger = new CrazyLogger();
        LocalDateTime now = LocalDateTime.now();
        String message1 =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Error #1";
        String message7 =  now.format(DateTimeFormatter.ofPattern("dd-mm-YYYY:hh-mm")) + " - Compile Error #7";

        logger.addNewLogMessage(message1);
        logger.addNewLogMessage(message7);

        assertTrue(logger.getLastMessage().contains("7"));
    }

    @Test
    public void getLastMessageTestIfLoggerIsEmpty() {
        CrazyLogger logger = new CrazyLogger();

        try {
            logger.getLastMessage();
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            logger.addNewLogMessage(e.getMessage());
            assertTrue(logger.getLastMessage().contains(e.getMessage()));
        }

    }

}
