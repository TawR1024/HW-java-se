package com.epam.training.task4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ilya Kulakov on 06.03.17.
 */
public class FilmCollectionTest {
    @Test
    public void saveCollectionAsFile() throws Exception {
        Actor actor1 = new Actor("Bob", 15);
        Actor actor2 = new Actor("Jack", 89);
        Actor actor3 = new Actor("John", 45);
        Film film1 = new Film("Film Name 1", "comedy");
        Film film2 = new Film("Film name 2", "genre 1");
        Film film3 = new Film("Kin-dza-dza", "genre 2");
        FilmCollection filmCollection = new FilmCollection("MyCollection");
        filmCollection.addFilm(film1, actor1);
        filmCollection.addFilm(film2, actor2);
        filmCollection.addFilm(film3, actor3);
        filmCollection.saveCollectionAsFile("src/main/resources/task_4.serialized");
    }

    @Test
    public void addToCollection() {
        FilmCollection filmCollection = new FilmCollection("MyCollection");
        Actor actor1 = new Actor("Bob", 15);
        Film film = new Film("Kin-dza-dza", "comedy");
    }

    @Test(expected = NullPointerException.class)
    public void addEmptyArguments() {
        FilmCollection filmCollection = new FilmCollection();
        Actor actor = null;
        Film film = null;
        filmCollection.addFilm(film, actor);
    }

}