package com.epam.training.task_2;

/**
 * Created by Ilya Kulakov on 26.03.17.
 */
public class NoSuchKeyException extends RuntimeException {
    public NoSuchKeyException(String message) {
        super(message);
    }
}
