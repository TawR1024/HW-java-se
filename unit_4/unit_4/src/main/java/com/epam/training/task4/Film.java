package com.epam.training.task4;

import java.io.Serializable;

/**
 * Created by Ilya Kulakov on 06.03.17.
 */
public class Film implements Serializable {
    String name;
    String genre;

    public Film() {
    }

    public Film(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

}
