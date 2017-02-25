package com.epam.training;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.StringJoiner;

import static org.junit.Assert.assertTrue;

public class CrazyLoggerTest {
    @Test
    public void addNewLogMessageTest() {
        CrazyLogger logger = new CrazyLogger();
        LocalDateTime now = LocalDateTime.now();
        String message =  now + " - Error! Bug was finded in youre code!";

        logger.addNewLogMessage(message);
        assertTrue(logger.getLastMessage().contains(message));
    }

    @Test
    public void showLogTest() {
        CrazyLogger logger = new CrazyLogger();
        logger.addNewLogMessage("Bu");

        logger.showLog();
    }

}
