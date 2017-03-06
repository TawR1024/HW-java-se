package com.epam.training.task4;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ilya Kulakov on 06.03.17.
 */
public class FilmCollection {
    private HashMap<Film, List<Actor>> films;
    String nameOFCollection;

    public FilmCollection(String name) {
        this.nameOFCollection = name;
        films = new HashMap<>();
    }

    public void addFilm(Film film, Actor... actor1) {
        throw  new UnsupportedOperationException();
    }
}
