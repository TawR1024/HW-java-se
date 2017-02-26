package com.epam.training;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static org.junit.Assert.assertTrue;

public class CrazyLoggerTest {
    @Test
    public void addNewLogMessageTest() {
        CrazyLogger logger = new CrazyLogger();
        String message = "Error #1";

        logger.addNewLogMessage("Error #1 ");
        assertTrue(logger.getLastMessage().contains(message));
    }

    @Test
    public void showLogTest() {
        CrazyLogger logger = new CrazyLogger();

        logger.addNewLogMessage("Error 1");
        logger.addNewLogMessage("Error 2");
        logger.addNewLogMessage("Error 3");
        logger.addNewLogMessage("Error 4");
        logger.addNewLogMessage("Error 5");
        logger.addNewLogMessage("Error 6");
        logger.addNewLogMessage("Error 7");
        logger.showLog();
    }

    @Test
    public void getLastMessageTest() {
        CrazyLogger logger = new CrazyLogger();

        logger.addNewLogMessage("NPE");
        logger.addNewLogMessage("Compile Error #7");

        assertTrue(logger.getLastMessage().contains("7"));
    }

    @Test
    public void getLastMessageTestIfLoggerIsEmpty() {
        CrazyLogger logger = new CrazyLogger();

        try {
            logger.getLastMessage();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            logger.addNewLogMessage(e.getMessage());
            assertTrue(logger.getLastMessage().contains(e.getMessage()));
        }

    }

}
